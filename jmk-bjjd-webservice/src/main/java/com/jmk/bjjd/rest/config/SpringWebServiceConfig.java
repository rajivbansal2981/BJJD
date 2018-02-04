package com.jmk.bjjd.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.jmk.bjjd.service.config.SpringServiceConfig;

@Configuration
@Import(SpringServiceConfig.class)
@ComponentScan("com.jmk.bjjd.rest")
@EnableWebMvc
public class SpringWebServiceConfig{
	//To resolve ${} in @Value
			@Bean
			public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
				return new PropertySourcesPlaceholderConfigurer();
			}
}
