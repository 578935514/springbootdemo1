package com.cxp.sbt.conf;

import com.cxp.sbt.filter.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot配置拦截器
 */
public class SpringConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/*.ico")
                .excludePathPatterns()
                .excludePathPatterns();
    }
}
