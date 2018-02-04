package com.jmk.bjjd.persistence.config;

import java.io.IOException;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@ComponentScan("com.jmk.bjjd.persistence")
public class SpringPersistenceConfig {
	
	@Autowired
	private ApplicationContext context;

	 
	@Bean(name="dozerBeanMapper")
	public DozerBeanMapperFactoryBean getDozerBeanMapper() throws IOException{
		DozerBeanMapperFactoryBean dozzerBeanMapper=new DozerBeanMapperFactoryBean();
		Resource[] mappingFiles=((ResourcePatternResolver)context).getResources("classpath*:dozer/**/*mapping.dzr.xml");
		dozzerBeanMapper.setMappingFiles(mappingFiles);
		return dozzerBeanMapper;
	}
	
}
