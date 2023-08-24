package com.study.common.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用ServletRequestListener获取访问信息
 * @author
 * @date
 */
@Component
public class HttpRequestListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        //logger.info("session id为：{}", request.getRequestedSessionId());
        //logger.info("request url为：{}", request.getRequestURL());

        request.setAttribute("nameSession", "sun");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        //logger.info("request end");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        //logger.info("request域中保存的name值为：{}", request.getAttribute("nameSession"));

    }

}
