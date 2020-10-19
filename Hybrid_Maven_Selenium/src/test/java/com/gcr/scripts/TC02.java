package com.gcr.scripts;

import org.testng.annotations.Test;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class TC02 extends StartBrowser{
  @Test
  public void Excel_LoginLogout() throws Exception {
	  CommonFunctions cfs = new CommonFunctions();
	  Fillo f = new Fillo();
	  Connection con = f.getConnection("TestData/Data.xlsx");
	  String strQuery = "Select * from TC1";
	  Recordset rs = con.executeQuery(strQuery);
	  while(rs.next())
	  {
	  cfs.login(rs.getField("UserName"), rs.getField("Password"));
	  }
	  cfs.logout();
  }
}
