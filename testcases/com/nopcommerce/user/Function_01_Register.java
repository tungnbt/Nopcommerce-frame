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

public class Function_01_Register extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverClassTest = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driverClassTest);
		lstName = "iron";
		fstName = "man";
		email = "ironman" + getRandomNumber() + "@gmail.com.vn";
		password = "123456";
		confirmPassword = "123456";
		System.out.println("Pre-condition: Open Register Page");
		registerPageObject = homePageObject.openRegisterPage();
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePageObject.openRegisterPage();

		registerPageObject.clickToRegisterBtn();

		Assert.assertEquals(registerPageObject.getErrorMessageFstName("FirstName-error"), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageLstName("LastName-error"), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageEmail("Email-error"), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessagePassword("Password-error"), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPassword("ConfirmPassword-error"), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		registerPageObject = homePageObject.openRegisterPage();

		registerPageObject.RegisterAsUser(fstName, lstName, "asd", password, confirmPassword);

		Assert.assertEquals(registerPageObject.getErrorMessageEmail("Email-error"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		registerPageObject = homePageObject.openRegisterPage();

		registerPageObject.RegisterAsUser(fstName, lstName, email, password, confirmPassword);

		loginPageObject = homePageObject.openUserLoginPage();

		loginPageObject.LoginAsUser(email, confirmPassword);
		Assert.assertTrue(homePageObject.isMyAccLinkDisplayed());

		homePageObject.clickToLogoutLink();
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		registerPageObject = homePageObject.openRegisterPage();

		registerPageObject.RegisterAsUser(fstName, lstName, email, password, confirmPassword);

		Assert.assertEquals(registerPageObject.existMessageEmail(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		registerPageObject = homePageObject.openRegisterPage();

		registerPageObject.RegisterAsUser(fstName, lstName, email, "123", confirmPassword);

		Assert.assertEquals(registerPageObject.getErrorMessagePassword("Password-error"),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		registerPageObject = homePageObject.openRegisterPage();

		registerPageObject.RegisterAsUser(fstName, lstName, email, password, "98757324");

		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPassword("ConfirmPassword-error"),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driverClassTest.quit();
	}

	private WebDriver driverClassTest;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private String lstName, fstName, email, password, confirmPassword;

}
