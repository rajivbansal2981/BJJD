package com.jmk.bjjd.web.webdriverhtmlunit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbstractPage {
	protected WebDriver driver;
	
	@FindBy(css="label.error,.alert-error")
	private WebElement errors;
	
	public AbstractPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	
	public String getErrors(){
		return errors.getText();
	}
	
	protected static void get(WebDriver driver,String relativeUrl){
		String url=System.getProperty("geb.build.baseUrl","http://localhost:9090/jmk-bjjd-web") + relativeUrl;
		driver.get(url);
	}
	
}
