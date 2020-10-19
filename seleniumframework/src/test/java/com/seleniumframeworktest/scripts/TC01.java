package com.seleniumframeworktest.scripts;

import org.testng.annotations.Test;

import com.seleniumframeworktest.config.startBrowser;
import com.seleniumframeworktest.reUse.commonFunction;

public class TC01 extends startBrowser {
  @Test
  public void Login_Logout() throws Exception {
	  commonFunction cfs = new commonFunction();
	  cfs.login("", "");
	  Thread.sleep(3000);
	  cfs.logout();
  }
}
