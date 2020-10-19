package com.gcr.reuse;

import com.gcr.config.StartBrowser;
import com.gcr.or.HomePage;
import com.gcr.or.LoginPage;
import com.gcr.wdcmds.ActionDriver;

public class CommonFunctions {
	
	public ActionDriver aDriver;
	
	public CommonFunctions()
	{
		aDriver = new ActionDriver();
	}

	public void login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to ATHome");
		aDriver.navigateToApplication("https://www.athome.com/login/");
		aDriver.type(LoginPage.txtUserName, "nagatraining@gmail.com", "Email Textbox");
		aDriver.type(LoginPage.txtPassword, "Sample@1234", "Password field");
		aDriver.click(LoginPage.btnSignIn, "Sign In button");
	}
	
	public void login(String un, String pwd) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to ATHome");
		aDriver.navigateToApplication("https://www.athome.com/login/");
		aDriver.type(LoginPage.txtUserName, un, "Email Textbox");
		aDriver.type(LoginPage.txtPassword, pwd, "Password field");
		aDriver.click(LoginPage.btnSignIn, "Sign In button");
	}
	
	public void logout() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout of ATHome");
		aDriver.mouseHover(HomePage.menuAccount, "My Account Menu");
		aDriver.click(HomePage.lnkLogout, "Logout Link");
		
	}
}
