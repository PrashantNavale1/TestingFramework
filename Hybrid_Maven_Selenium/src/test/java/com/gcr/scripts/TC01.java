package com.gcr.scripts;

import org.testng.annotations.Test;

import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class TC01 extends StartBrowser{
  @Test
  public void Login_Logout() throws Exception {
	  CommonFunctions cfs = new CommonFunctions();
	  cfs.login();
	  Thread.sleep(3000);
	  cfs.logout();
  }
}
