package com.kaleldo.handler;

import com.kaleldo.pojo.KaleldoResponse;
import com.kaleldo.utils.KaleldoUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//处理403类型异常
public class KaleldoAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        KaleldoResponse kaleldoResponse = new KaleldoResponse();
        KaleldoUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_FORBIDDEN, kaleldoResponse.message("没有权限访问该资源"));
    }
}
