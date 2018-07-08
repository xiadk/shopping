package com.ZIBShopping.controller.Interceptor;

import com.ZIBShopping.common.Constants;
import com.ZIBShopping.common.Annotation.LoginRequired;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Token验证过滤器,判断是否已登录
 *  @author:xiadekang
 *  @Date:2018-15-14
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(AuthenticationInterceptor.class);

        @Autowired
    private RedisTemplate<String, String> redis;
    /**
     * 在请求前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JSONObject result = new JSONObject();
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 判断是否存在令牌信息，如果存在，则允许登录
            String accessToken = request.getHeader(Constants.TOKEN);
            if (null == accessToken) {
                result.put("code","-1");
                result.put("msg","no token parameter");

                response.getWriter().write(result.toJSONString());
                return false;
            }
            Object uid =  redis.opsForHash().get(Constants.TOKEN,Constants.UID);
            if(uid == null) {
                result.put("code","-1");
                result.put("msg","no token，please login again");

                response.getWriter().write(result.toJSONString());
                return false;
            }
            request.setAttribute(Constants.UID,Long.valueOf(uid+""));
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
