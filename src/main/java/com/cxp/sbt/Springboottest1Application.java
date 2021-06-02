package com.cxp.sbt;

import com.cxp.sbt.filter.LoginFilter;
import com.cxp.sbt.filter.LoginInterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.Filter;


//导入自定义配置文件
/*@ImportResource(locations = {""})*/
//忽略自动装配数据源，以禁用数据源默认自动配置。
//数据源默认自动配置会读取 spring.datasource.* 的属性创建数据源，所以要禁用以进行定制。
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan()

/*@mapperScan配置可以写在dataSource配置中*/
//@MapperScan(basePackages = "com.cxp.sbt.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//启动定时任务
@EnableScheduling
//扫描所有的servlet类，包含filter,listener和interceptor
@ServletComponentScan(basePackages = "com.cxp.sbt.filter;com.cxp.sbt.listener")
public class Springboottest1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboottest1Application.class, args);
    }


    //	ServletListenerRegistrationBean 用来注册监听器。
    //	ServletRegistrationBean 用来注册 Servlet。
    //	DispatcherServletRegistrationBean 用来注册 DispatcherServlet。
    //	FilterRegistrationBean 用来注册过滤器。
    //	DelegatingFilterProxyRegistrationBean 则用来注册 DelegatingFilterProxy，DelegatingFilterProxy 在 Spring Security、Spring Session、Shiro 等整合时非常有用。
    //此方法适用于第三方jar报导入的过滤应用
    @Bean
    public FilterRegistrationBean LogFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LoginFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}


