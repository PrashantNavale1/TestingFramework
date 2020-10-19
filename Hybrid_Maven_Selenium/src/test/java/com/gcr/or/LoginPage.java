package com.gcr.or;

import org.openqa.selenium.By;

public class LoginPage {
	
	public static By txtUserName= By.id("login-form-email");
	public static By txtPassword= By.name("loginPassword");
	public static By btnSignIn= By.xpath("//button[text()='Sign in']");
}
