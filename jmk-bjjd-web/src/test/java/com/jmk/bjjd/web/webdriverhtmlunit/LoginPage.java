package com.jmk.bjjd.web.webdriverhtmlunit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	private WebElement userName;
	
	private WebElement password;
	
	private WebElement userType;
	
	private WebElement submitBtn;
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	public void login(String userName,String password,String userType){
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.userType.sendKeys(userType);
		this.submitBtn.click();
	}

	public static void login(WebDriver driver){
		get(driver,"/login");
		LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
		loginPage.login("rajivbansal2981","rajiv379","MEMBER");
	}
	

}
