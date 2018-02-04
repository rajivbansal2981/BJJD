package com.jmk.bjjd.web.config.core;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.jmk.bjjd.web.config.SpringWebMvcConfig;
import com.jmk.bjjd.web.config.SpringWebSecurityConfig;

@Order(value=1)
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SpringWebMvcConfig.class,SpringWebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	//Optional: To add spring security
	/*@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new DelegatingFilterProxy("springSecurityFilterChain")};
	}*/

}
