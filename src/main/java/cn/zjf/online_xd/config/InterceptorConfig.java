package cn.zjf.online_xd.config;

import cn.zjf.online_xd.interceptor.AdminLoginInterceptor;
import cn.zjf.online_xd.interceptor.CorsInterceptor;
import cn.zjf.online_xd.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 配置拦截器
 * @author OneBird
 * @date 2022/3/19 19:53
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }

    @Bean
    AdminLoginInterceptor adminLoginInterceptor(){
        return new AdminLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截全部路径
         * 跨域需要放在最上面
         */
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        /**
         * 拦截未登录用户
         */
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);

        /**
         * 拦截管理员
         */
        registry.addInterceptor(adminLoginInterceptor()).addPathPatterns("/admin/v1/pri/*/*/**")
                .excludePathPatterns("/admin/v1/pri/user/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
