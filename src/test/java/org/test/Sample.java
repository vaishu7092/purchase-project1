package org.test;

import java.io.IOException;

import org.base.BaseClass;
import org.login.LoginPage;

public class Sample extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		
		browserLaunch("chrome");
		urlLaunch("https://www.facebook.com/");
		implicitlyWait(20);
		
	//	String currentUrl=getCurrentUrl();
		//System.out.println(currentUrl);
		
	//	String title=getTitle();
	//	System.out.println(title);
		
		LoginPage l=new LoginPage();
		//WebElement txtUserName =l.getTxtUserName();
	sendKeys(l.getTxtUserName(), excelReadData("Datass","Sheet1",2,0));
		//WebElement txtPassword =l.getTxtPassword();
		sendKeys(l.getTxtPassword(), excelReadData("Datass","Sheet1",2,1));
	//	WebElement btnLogin =l.getBtnLogin();
		click(l.getBtnLogin());
	//	List<WebElement> buttons=l.getBtnCreateNew();
	//	WebElement btnCreate=buttons.get(1);
	//	click(btnCreate);
		
		
		quit();
	}
	

}
