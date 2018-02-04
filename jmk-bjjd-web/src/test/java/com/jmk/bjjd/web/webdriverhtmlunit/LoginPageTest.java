package com.jmk.bjjd.web.webdriverhtmlunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
/**
 * Application must be deployed on server to run this test
 * @author rajivb
 *
 */
@Ignore
public class LoginPageTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		driver=new HtmlUnitDriver(true);
	}
	
	@Test
	public void testLoginPage(){
		LoginPage.login(driver);
	}
	
	@After
	public void destroy(){
		if(driver!=null){
			driver.close();
		}
	}
	
	
}
