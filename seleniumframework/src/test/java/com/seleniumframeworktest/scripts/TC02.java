package com.seleniumframeworktest.scripts;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.seleniumframeworktest.config.startBrowser;
import com.seleniumframeworktest.reUse.commonFunction;

public class TC02 extends startBrowser{
  @Test
  public void excel_Login_Logout() throws Exception, FilloException {
	  commonFunction cfs = new commonFunction();
	  Fillo f = new Fillo();
	  Connection con = f.getConnection("TestData//Data.xlsx");
	  String strQuery = "Select * from Users";
	  Recordset rs = con.executeQuery(strQuery);
	  while(rs.next()) {
		  cfs.login(rs.getField("UserName"), rs.getField("Password"));
		  cfs.logout();
	  }
	  
  }
}
