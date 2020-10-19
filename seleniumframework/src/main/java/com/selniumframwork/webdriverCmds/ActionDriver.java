package com.selniumframwork.webdriverCmds;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.seleniumframeworktest.config.startBrowser;

public class ActionDriver {

	public static WebDriver driver;
	
	public ActionDriver() {
		driver = startBrowser.driver;
	}
	
/**
 * used to navigate to application 
 * @param url -- Application URL
 */
	public static void navigateToApplication(String url) {
		try {
			driver.get(url);
			startBrowser.childTest.pass("Sucessfully Navigated to :" +url);
		} catch (Exception e) {
			startBrowser.childTest.fail("Unable to Navigated to :" +url);
		}
	}
/**
 * used to perform click action on button, links, check boxes and Radio buttons
 * @param locator
 * @param eleName
 * @throws Exception
 */
	public void click(By locator, String eleName) throws Exception {
		try {
			driver.findElement(locator).click();
			startBrowser.childTest.pass("Sucessfully performed Click action on : "+eleName); 
		} catch (Exception e) {
			startBrowser.childTest.fail("Unable to performed Click action on : "+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build()); 
			startBrowser.childTest.info(e);
			throw e;
		}
	}
	
	/**
	 * used to perform type action on edit box
	 * @param locator
	 * @param testData
	 * @param eleName
	 * @throws Exception
	 */
	public void type (By locator, String testData, String eleName) throws Exception {
		try {
			driver.findElement(locator).sendKeys(testData);
			startBrowser.childTest.pass("Sucessfully performed type action on : "+ eleName + "with Data "+ testData); 
		} catch (Exception e) {
			startBrowser.childTest.fail("Unable to perform type action on : "+eleName + "with Data "+ testData,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build()); 
			startBrowser.childTest.info(e);
		}
	}
	/**
	 * used to perform mouseOver action on the page
	 * @param locator
	 * @param eleName
	 * @throws IOException
	 */
	public void mouseOver(By locator, String eleName) throws IOException {
		try {
			WebElement mo = driver.findElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(mo).build().perform();
			startBrowser.childTest.pass("Sucessfully performed mouseOver action on : "+eleName ); 
			
		} catch (Exception e) {
			startBrowser.childTest.fail("Unable to performed mouseOver action on : "+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build()); 
			startBrowser.childTest.info(e);
		}
	}
	/**
	 * used to take screenshot for failed cases
	 * @return
	 */
	public String screenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
	}
}
