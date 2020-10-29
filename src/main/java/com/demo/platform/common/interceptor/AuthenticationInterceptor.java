package com.demo.platform.common.interceptor;

import com.demo.platform.common.annotation.*;
import com.demo.platform.common.exception.CustomException;
import com.demo.platform.common.utils.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 授权验证拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 http 请求头中取出 token
//        String token = request.getHeader("token");
//        boolean verity = JwtUtil.validateToken(token);
//        if (!verity){
//            throw new CustomException(4040,"token过期，请重新登录");
//        }

        //基于注解配置登录拦截
        if (handler instanceof  HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 接口是否有@LoginRequired注解, 有则需要判断是否登录
            boolean annotationPresent = method.isAnnotationPresent(LoginRequired.class);
            if (annotationPresent) {
                // 验证token
                String token = request.getHeader("token");
                boolean verity = JwtUtil.validateToken(token);
                if (!verity) {
                    throw new CustomException(4040, "token过期，请重新登录");
                }
                return true;
            }
        }



        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
