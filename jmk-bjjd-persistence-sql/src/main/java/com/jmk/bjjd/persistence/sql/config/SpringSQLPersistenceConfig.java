package com.jmk.bjjd.persistence.sql.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jmk.bjjd.persistence.config.SpringPersistenceConfig;


@Configuration
@EnableTransactionManagement					//To enable transaction management
@EnableJpaRepositories(basePackages={"com.jmk.bjjd.persistence.sql.repository"})							//To configure JPA repositories
@ComponentScan(basePackages="com.jmk.bjjd.persistence.sql.service")
@Import(value={SpringPersistenceConfig.class})
public class SpringSQLPersistenceConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		
		HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);
		
		Properties jpaProperties=new Properties();
		//jpaProperties.put("hibernate.hbm2ddl.auto","update");
		jpaProperties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(jpaVendorAdapter);
		factory.setPackagesToScan("com.jmk.bjjd.persistence.sql.entities");
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		
		return factory;
	}
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:localhost:1521:orcl");
		dataSource.setUsername("bjjd");
		dataSource.setPassword("bjjd");
		return dataSource;
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		EntityManagerFactory factory=entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}
}
