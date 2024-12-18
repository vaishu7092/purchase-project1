package org.login;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindAll({@FindBy(id="ema"),@FindBy(xpath="//input[@type='text']")})
	private WebElement txtUserName;
	
	@FindAll({@FindBy(id="pas"),@FindBy(xpath="//input[@type='password']")})
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private WebElement btnLogin;
	
	//@FindBy(xpath="(//a[@role='button'])[2]")
//	private WebElement btnCreate;
	
	//@FindBy(xpath="//a[@role='button']")
	//private List<WebElement>btnCreateNew;
	
//	public List<WebElement>getBtnCreateNew() {
	//	return btnCreateNew;
//	}
	
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword()
	{
     return txtPassword;

	}
	
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
}







