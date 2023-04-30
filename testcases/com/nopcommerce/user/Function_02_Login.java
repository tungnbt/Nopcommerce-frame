package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Function_02_Login extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverClassTest = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driverClassTest);
		lstName = "iron";
		fstName = "man";
		existEmail = "ironman" + getRandomNumber() + "@gmail.com.vn";
		invalidEmail = "asdskm";
		notFoundEmail = "abc123@gmail.net";
		password = "123456";
		confirmPassword = "123456";
		System.out.println("Precondition: Register sucess");
		registerPageObject = homePageObject.openRegisterPage();
		registerPageObject.RegisterAsUser(lstName, fstName, existEmail, password, confirmPassword);
		loginPageObject = homePageObject.openUserLoginPage();
	}

	@Test
	public void TC_01_Empty_Data() {
		loginPageObject.clickToLoginBtn();
		Assert.assertEquals(loginPageObject.getErrorMessageEmail(), "Please enter your email");
	}

	@Test
	public void TC_02_Invalid_Email() {
		loginPageObject = homePageObject.openUserLoginPage();

		loginPageObject.LoginAsUser(invalidEmail, null);

		Assert.assertEquals(loginPageObject.getErrorMessageEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Email_Not_Found() {
		loginPageObject = homePageObject.openUserLoginPage();

		loginPageObject.LoginAsUser(notFoundEmail, null);

		Assert.assertEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Existing_Email_Empty_Password() {
		loginPageObject = homePageObject.openUserLoginPage();

		loginPageObject.LoginAsUser(existEmail, null);

		Assert.assertEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Existing_Email_Incorrect_Password() {
		loginPageObject = homePageObject.openUserLoginPage();

		loginPageObject.LoginAsUser(existEmail, "89789798");

		Assert.assertEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Valid_Email_Password() {
		loginPageObject = homePageObject.openUserLoginPage();

		loginPageObject.LoginAsUser(existEmail, password);

		Assert.assertTrue(homePageObject.isMyAccLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driverClassTest.quit();
	}

	private WebDriver driverClassTest;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private String existEmail, password, confirmPassword, lstName, fstName, invalidEmail, notFoundEmail;
}
