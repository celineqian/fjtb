package com.cq.fjtb.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Celine Q
 * @Create 25/09/2018 10:51 AM
 **/
@Component
public class CommonIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        request.setAttribute("ctxPath",request.getContextPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
