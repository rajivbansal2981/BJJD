package com.jmk.bjjd.web.mockmvchtmlunit;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.jmk.bjjd.web.config.SpringWebMvcConfig;
import com.jmk.bjjd.web.config.SpringWebSecurityConfig;

/**
 * Application should not be deployed to run this test but without deploying the application this test is not running.
 * @author rajivb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringWebMvcConfig.class,SpringWebSecurityConfig.class})
@WebAppConfiguration
//@WithMockUser
@Ignore
public class LoginPageTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private WebClient webClient;
	
	@Before
	public void setUp() {
		/********** Approach 1****************/
		// webClient=MockMvcWebClientBuilder.webAppContextSetup(context,SecurityMockMvcConfigurers.springSecurity()).contextPath("").build();
		/********** Approach 2****************/
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		webClient = new WebClient();
		//webClient.setWebConnection(new MockMvcWebConnection(mockMvc));

		/*webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		*/ webClient.getOptions().setJavaScriptEnabled(true);
		    webClient.getOptions().setUseInsecureSSL(true);
		//webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	}
	
	@Test
	public void testLoginPage() throws IOException{
		
		HtmlPage loginPage=webClient.getPage("http://localhost:9090/jmk-bjjd-web/login");
		System.out.println("Login Page:"+loginPage);
		HtmlForm form = loginPage.getHtmlElementById("loginForm");
		HtmlTextInput userName = loginPage.getHtmlElementById("userName");
		userName.setValueAttribute("rajivbansal2981");
		HtmlPasswordInput  password = loginPage.getHtmlElementById("password");
		password.setText("rajiv379");
		HtmlSelect userType = loginPage.getHtmlElementById("userType");
		userType.setDefaultValue("MEMBER");
		HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input", "type", "submit");
		HtmlPage homePage = submit.click();
		System.out.println("Home Page:"+homePage);
		Assert.assertNotNull(form);
	}
	
	@After
	public void destroy(){
		if(webClient!=null){
			webClient.close();
		}
	}
	
	
}
