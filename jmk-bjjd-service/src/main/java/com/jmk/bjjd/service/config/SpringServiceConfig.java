package com.jmk.bjjd.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.jmk.bjjd.persistence.nosql.config.SpringNoSQLPersistenceConfig;
import com.jmk.bjjd.persistence.sql.config.SpringSQLPersistenceConfig;

@Configuration
@ComponentScan("com.jmk.bjjd.service")
@PropertySource("classpath:/service.properties")
@Import(value={SpringSQLPersistenceConfig.class,SpringNoSQLPersistenceConfig.class})
public class SpringServiceConfig {
		//To resolve ${} in @Value
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
			return new PropertySourcesPlaceholderConfigurer();
		}
}

