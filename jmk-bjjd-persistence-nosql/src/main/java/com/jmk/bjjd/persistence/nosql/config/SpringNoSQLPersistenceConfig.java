package com.jmk.bjjd.persistence.nosql.config;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.jmk.bjjd.persistence.nosql.converter.BooleanToStringConverter;
import com.jmk.bjjd.persistence.nosql.converter.StringToBooleanConverter;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan("com.jmk.bjjd.persistence.nosql")
@EnableMongoRepositories(basePackages="com.jmk.bjjd.persistence.nosql.repository")
public class SpringNoSQLPersistenceConfig {
	
	 @Autowired
	 private ApplicationContext context;


	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException  {
		return new SimpleMongoDbFactory(new MongoClient("localhost",27017),"bjjd");
	}
	
	/**
	 * To apply specific data type conversion
	 * @return
	 */
	@Bean
	public CustomConversions customConversion(){
		List<Converter<?,?>> converters=new ArrayList<Converter<?,?>>();
		converters.add(new BooleanToStringConverter());
		converters.add(new StringToBooleanConverter());
		return new CustomConversions(converters);
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException{
		MappingMongoConverter converter=new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		converter.setCustomConversions(customConversion());
		converter.afterPropertiesSet();
		MongoTemplate mongoTemplate=new MongoTemplate(mongoDbFactory(),converter);
		return mongoTemplate;
	}
	
}
