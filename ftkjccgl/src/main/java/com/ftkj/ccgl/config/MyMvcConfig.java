package com.ftkj.ccgl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ftkj.ccgl.component.LoginHandlerInterceptor;
import com.ftkj.ccgl.component.MyLocaleResolver;

/**
 * 使用
 * @author Administrator
 *
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

	
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		
		WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {

			/**
			 * 注册拦截器拦截规则
			 */
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				// TODO Auto-generated method stub
				/**
				 * 拦截全部请求，除了登录请求和
				 * SpringBoot已经做好了静态资源映射,无需添加静态资源的拦截规则
				 */
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/index.html","/","/user/login");//登录请求
			}

			/**
			 * 默认首页，登录页，防止刷新重复提交表单配置
			 */
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// TODO Auto-generated method stub
				registry.addViewController("/").setViewName("login");//默认访问登录页
				registry.addViewController("/index.html").setViewName("login");//访问首页也返回登录页
				registry.addViewController("/main").setViewName("main");//刷新时候，如果请求地址栏显示的是主页，刷新，也会到主页
				registry.addViewController("/welcome").setViewName("welcome");//刷新时候，如果请求地址栏显示的是主页，刷新，也会到主页

			}
			
			
		};
		
		return webMvcConfigurerAdapter;		
	}
	
	/**
	 * 将自己的国际化配置注册到组件中
	 * @return
	 */
	@Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }
	
}
