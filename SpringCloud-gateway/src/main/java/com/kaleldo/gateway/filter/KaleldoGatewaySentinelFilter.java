package com.kaleldo.gateway.filter;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayParamFlowItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulErrorFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPostFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPreFilter;
import com.kaleldo.gateway.fallback.KaleldoGatewayBlockFallbackProvider;
import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * 请求限流
 */
@Slf4j
@Configuration
public class KaleldoGatewaySentinelFilter {
    @Bean
    public ZuulFilter sentinelZuulPreFilter() {
        return new SentinelZuulPreFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulPostFilter() {
        return new SentinelZuulPostFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulErrorFilter() {
        return new SentinelZuulErrorFilter();
    }

    @PostConstruct
    public void doInit() {
        //对限流的异常进行翻译
        ZuulBlockFallbackManager.registerProvider(new KaleldoGatewayBlockFallbackProvider());
        initGatewayRules();
    }

    /**
     * GatewayFlowRule 网关限流规则，针对 API Gateway 的场景定制的限流规则，可以针对不同 route 或自定义的 API 分组进行限流，支持针对请求中的参数、Header、来源 IP 等进行定制化的限流。
     * ApiDefinition：用户自定义的 API 定义分组，可以看做是一些 URL 匹配的组合。比如我们可以定义一个 API 叫 my_api，请求 path 模式为 /foo/** 和 /baz/** 的都归到 my_api 这个 API 分组下面。限流的时候可以针对这个自定义的 API 分组维度进行限流。
     *
     */
    /**
     * 定义验证码请求限流，限流规则：
     * 60秒内同一个IP，同一个 key最多访问 10次
     */
    private void initGatewayRules() {
        Set<ApiDefinition> definitions = new HashSet<>();
        Set<ApiPredicateItem> predicateItems = new HashSet<>();
        // 添加限流的地址
        predicateItems.add(new ApiPathPredicateItem().setPattern("/auth/captcha"));
        //将限流组命名为captcha
        ApiDefinition definition = new ApiDefinition("captcha")
                .setPredicateItems(predicateItems);

        definitions.add(definition);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);

        Set<GatewayFlowRule> rules = new HashSet<>();

        rules.add(new GatewayFlowRule("captcha")
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_CUSTOM_API_NAME)
                .setParamItem(
                        new GatewayParamFlowItem()
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM)
                                .setFieldName("key")
                                .setMatchStrategy(SentinelGatewayConstants.PARAM_MATCH_STRATEGY_EXACT)
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_CLIENT_IP)
                )
                .setCount(10)
                .setIntervalSec(60) //60内同一个IP，同一个key最多访问10次
        );
        GatewayRuleManager.loadRules(rules);
    }
}
