package com.ZIBShopping.common.ArgumentResolver;

import com.ZIBShopping.common.Annotation.CurrentUser;
import com.ZIBShopping.common.Constants;
import com.ZIBShopping.controller.Interceptor.AuthenticationInterceptor;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @description:自定义解析器实现参数绑定
 * 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 * @author:xiadekang
 * @Date:2018-16-53
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private Logger logger = Logger.getLogger(CurrentUserMethodArgumentResolver.class);
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class)&&parameter.getParameterType().isAssignableFrom(Long.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Long currentUid = (Long) webRequest.getAttribute(Constants.UID, RequestAttributes.SCOPE_REQUEST);
        if (currentUid != null) {
            return currentUid;
        }

        logger.error("获取uid失败", new MissingServletRequestPartException(Constants.UID));
        return -1;
    }
}
