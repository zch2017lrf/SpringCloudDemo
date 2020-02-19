package com.kaleldo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.kaleldo.pojo.KaleldoConstant;
import com.kaleldo.pojo.KaleldoResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器
 */
public class KaleldoServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(KaleldoConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(KaleldoConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            KaleldoResponse kaleldoResponse = new KaleldoResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSONObject.toJSONString(kaleldoResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}