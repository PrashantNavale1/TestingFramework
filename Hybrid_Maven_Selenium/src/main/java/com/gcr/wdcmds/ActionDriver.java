package com.gcr.wdcmds;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gcr.config.StartBrowser;

public class ActionDriver {
	
	public WebDriver driver;
	
	public ActionDriver()
	{
		driver= StartBrowser.driver;
	}
	
/**
 * Used to navigate to application
 * @param url -- Application URL
 */
	public  void navigateToApplication(String url)
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfylly Navigated to application : "+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to  navigate to application : "+url);
		}
	}
	/**
	 * used to perform click action on buttons, links, check boxes and Radio buttons
	 * @param locator
	 * @param eleName
	 * @throws Exception
	 */
	public void click(By locator, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Successfully performed click action on :"+eleName);
		} catch (Exception e) {
			// TODO: handle exception
			StartBrowser.childTest.fail("Unable to perform click action on :"+eleName, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public void type(By locator, String testData, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Successfully performed type action on :"+eleName + " with data "+testData);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to  performed type action on :"+eleName + " with data "+testData, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	public void mouseHover(By locator, String eleName) throws Exception
	{
		try {
			WebElement mo=driver.findElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(mo).build().perform();
			StartBrowser.childTest.pass("Successfully performed mousehover action on :"+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perform mousehover action on :"+eleName, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}
