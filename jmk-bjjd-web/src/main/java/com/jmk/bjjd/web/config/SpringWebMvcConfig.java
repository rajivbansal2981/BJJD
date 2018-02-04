package com.jmk.bjjd.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@EnableWebMvc
@Configuration
@PropertySource("classpath:/web.properties")
@ComponentScan("com.jmk.bjjd.web")
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter{
	/*@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/
	
	@Bean
	public TilesViewResolver viewResolver(){
		TilesViewResolver viewResolver=new TilesViewResolver();
		return viewResolver;
	}
	
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer=new TilesConfigurer();
		tilesConfigurer.setDefinitions("WEB-INF/tiles.xml");
		tilesConfigurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
		return tilesConfigurer;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	
	//To resolve ${} in @Value
			@Bean
			public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
				return new PropertySourcesPlaceholderConfigurer();
			}
}
