package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.java")
@EnableAspectJAutoProxy(proxyTargetClass = true) // cglib proxy: true | false: jdk
@Import(DatabaseConfig.class)
public class SpringConfig implements WebMvcConfigurer {

	@Bean
	@Scope("singleton")
	public BeanNameUrlHandlerMapping getHandlerMapping() {
		return new BeanNameUrlHandlerMapping();
	}

	@Bean
	public ViewResolver getResolverDev() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("addProduct");
	}

}
