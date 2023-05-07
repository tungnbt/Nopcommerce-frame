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
		log.info("Precondition: Register sucess");
		registerPageObject = homePageObject.openRegisterPage();
		registerPageObject.RegisterAsUser(lstName, fstName, existEmail, password, confirmPassword);
		loginPageObject = homePageObject.openUserLoginPage();
	}

	@Test
	public void TC_01_Empty_Data() {
		log.info("Empty_Data - Step 01: Click to Login btn");
		loginPageObject.clickToLoginBtn();

		log.info("Empty_Data - Step 02: Verify error message Email");
		verifyEquals(loginPageObject.getErrorMessageEmail(), "Please enter your email");
	}

	@Test
	public void TC_02_Invalid_Email() {
		log.info("Invalid_Email - Step 01: Click to Login link");
		loginPageObject = homePageObject.openUserLoginPage();

		log.info("Invalid_Email - Step 02: Enter to Email txtbox invalid: " + invalidEmail + "/n"
				+ "Password txtbox with valid is null");
		loginPageObject.LoginAsUser(invalidEmail, null);

		log.info("Invalid_Email - Step 03: Verify error message Email");
		verifyEquals(loginPageObject.getErrorMessageEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Email_Not_Found() {
		log.info("Email_Not_Found - Step 01: Click to Login link");
		loginPageObject = homePageObject.openUserLoginPage();

		log.info("Email_Not_Found - Step 02: Enter to Email txtbox invalid: " + notFoundEmail + "/n"
				+ "Password txtbox with valid is null");
		loginPageObject.LoginAsUser(notFoundEmail, null);

		log.info("Email_Not_Found - Step 03: Verify unsuccessful Message ");
		Assert.assertEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Existing_Email_Empty_Password() {
		log.info("Existing_Email_Empty_Password - Step 01: Click to Login link");
		loginPageObject = homePageObject.openUserLoginPage();

		log.info("Existing_Email_Empty_Password - Step 02: Enter to Email txtbox invalid: " + existEmail + "/n"
				+ "Password txtbox with valid is null");
		loginPageObject.LoginAsUser(existEmail, null);

		log.info("Existing_Email_Empty_Password - Step 03: Verify unsuccessful Message ");
		verifyEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Existing_Email_Incorrect_Password() {
		log.info("Existing_Email_Incorrect_Password - Step 01: Click to Login link");
		loginPageObject = homePageObject.openUserLoginPage();

		log.info("Existing_Email_Incorrect_Password - Step 02: Enter to Email txtbox invalid: " + existEmail + "/n"
				+ "Password txtbox with invalid: 89789798");
		loginPageObject.LoginAsUser(existEmail, "89789798");

		log.info("Existing_Email_Incorrect_Password - Step 03: Verify unsuccessful Message ");
		verifyEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Valid_Email_Password() {
		log.info("Valid_Email_Password - Step 01: Click to Login link");
		loginPageObject = homePageObject.openUserLoginPage();

		log.info("Existing_Email_Incorrect_Password - Step 02: Enter to Email txtbox invalid: " + existEmail + "/n"
				+ "Password txtbox with value: "+password);
		loginPageObject.LoginAsUser(existEmail, password);

		log.info("Valid_Email_Password - Step 03: Verify My Account Link displayed");
		verifyTrue(homePageObject.isMyAccLinkDisplayed());
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
