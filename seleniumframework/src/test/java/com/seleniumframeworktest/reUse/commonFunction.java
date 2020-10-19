package com.seleniumframeworktest.reUse;

import com.seleniumframeworktest.config.startBrowser;
import com.seleniumframeworktest.objectRepo.HomePage;
import com.seleniumframeworktest.objectRepo.LoginPage;
import com.selniumframwork.webdriverCmds.ActionDriver;

public class commonFunction {

	public ActionDriver aDriver;
	public commonFunction() {
		aDriver = new ActionDriver();
	}
	public void login(String userName, String password) throws Exception {
		startBrowser.childTest = startBrowser.parentTest.createNode("Login to AtHome");
		aDriver.navigateToApplication("https://www.athome.com/login/");
		aDriver.type(LoginPage.textUserName, userName, "email TextBox");
		aDriver.type(LoginPage.textPassword, password, "password TextBox");
		aDriver.click(LoginPage.btnLogin, "login Button");
	}
	public void logout() throws Exception {
		startBrowser.childTest = startBrowser.parentTest.createNode("Logout from AtHome");
		aDriver.mouseOver(HomePage.menuAccont, "My Account Menu");
		aDriver.click(HomePage.lnkLogout, "logout link");
	}
	
	
}


