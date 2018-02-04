package com.jmk.bjjd.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import com.jmk.bjjd.web.facade.UserMgmtServiceFacade;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private Logger logger=LoggerFactory.getLogger(SpringWebSecurityConfig.class);

	
	@Autowired
	private UserMgmtServiceFacade userMgmtServiceFacade;
	
	@Bean
	public CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter()
	    throws Exception {
	    CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new CustomUsernamePasswordAuthenticationFilter();
	    customUsernamePasswordAuthenticationFilter
	        .setAuthenticationManager(authenticationManagerBean());
	    customUsernamePasswordAuthenticationFilter
	        .setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login","POST"));
	    return customUsernamePasswordAuthenticationFilter;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
			//authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		Assert.notNull(userMgmtServiceFacade);
		logger.info("******************************************");
		authenticationManagerBuilder.userDetailsService(userMgmtServiceFacade);
	}
	
	/*A simple controller :

    If URL = /welcome or / , return welcome page and no need to authenticate but you can as well.
    If URL = /admin , return admin page.*/
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.addFilterAfter(customUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		httpSecurity
			.authorizeRequests()
				.antMatchers("/","/j_spring_security_logout","/login").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/member/**").hasRole("ADMIN")
				.antMatchers("/expense/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.failureUrl("/login/failure").permitAll()
				.loginProcessingUrl("/j_spring_security_check")
				.defaultSuccessUrl("/home")
				.usernameParameter("userName")
				.passwordParameter("password")
			.and()
				.logout()
					.logoutSuccessUrl("/j_spring_security_logout").permitAll()
			.and()
				.rememberMe()
			.and()
				.csrf().disable();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                .antMatchers("/resources/**");
    }
}
