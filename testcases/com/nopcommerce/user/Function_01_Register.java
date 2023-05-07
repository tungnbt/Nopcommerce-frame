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
		log.info("Pre-condition: Open Register Page");
		registerPageObject = homePageObject.openRegisterPage();
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		log.info("Register_Empty_Data - Step 01: Click to Register link");
		homePageObject.openRegisterPage();

		log.info("Register_Empty_Data - Step 02: Click to Register btn");
		registerPageObject.clickToRegisterBtn();

		log.info("Register_Empty_Data - Step 03: Verify error message Firt Name");
		verifyEquals(registerPageObject.getErrorMessageFstName("FirstName-error"), "First name is required.");

		log.info("Register_Empty_Data - Step 04: Verify error message Last Name");
		verifyEquals(registerPageObject.getErrorMessageLstName("LastName-error"), "Last name is required.");

		log.info("Register_Empty_Data - Step 05: Verify error message Email");
		verifyEquals(registerPageObject.getErrorMessageEmail("Email-error"), "Email is required.");

		log.info("Register_Empty_Data - Step 06: Verify error message Password-error");
		verifyEquals(registerPageObject.getErrorMessagePassword("Password-error"), "Password is required.");

		log.info("Register_Empty_Data - Step 07: Verify error message ConfirmPassword-error");
		verifyEquals(registerPageObject.getErrorMessageConfirmPassword("ConfirmPassword-error"),
				"Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		log.info("Register_Invalid_Email - Step 01: Click to Register link");
		registerPageObject = homePageObject.openRegisterPage();

		log.info("Register_Invalid_Email - Step 02: Input to txtbox: \n" + "FirstName with right value: " + fstName
				+ "\n" + "LastName with right value: " + lstName + "\n" + "Email with wrong value: asd \n"
				+ "Password with right value: " + password + "\n" + "ConfirmPassword with right value: "
				+ confirmPassword);
		log.info("Register_Invalid_Email - Step 03: Click to Register btn");
		registerPageObject.RegisterAsUser(fstName, lstName, "asd", password, confirmPassword);

		log.info("Register_Invalid_Email - Step 04: Verify error message Email");
		verifyEquals(registerPageObject.getErrorMessageEmail("Email-error"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		log.info("Register_Success - Step 01: Click to Register link");
		registerPageObject = homePageObject.openRegisterPage();

		log.info("Register_Success - Step 02: Input to txtbox: \n" + "FirstName with right value: " + fstName + "\n"
				+ "LastName with right value: " + lstName + "\n" + "Email with right value: " + email + "\n"
				+ "Password with right value: " + password + "\n" + "ConfirmPassword with right value: "
				+ confirmPassword );
		log.info("Register_Success - Step 03: Click to Register btn");
		registerPageObject.RegisterAsUser(fstName, lstName, email, password, confirmPassword);
		
		log.info("Register_Success - Step 04: Click to Login link");
		loginPageObject = homePageObject.openUserLoginPage();

		log.info("Register_Success - Step 05: Input to txtbox:\n"
				+"Email with value right: "+email+"\n"
				+"Password with value right: "+confirmPassword);
		log.info("Register_Success - Step 06: Click to Login btn");
		loginPageObject.LoginAsUser(email, confirmPassword);
		
		log.info("Register_Success - Step 07: Verify My Account link displayed");
		Assert.assertTrue(homePageObject.isMyAccLinkDisplayed());

		log.info("Register_Success - Step 08: Click to Logout link");
		homePageObject.clickToLogoutLink();
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		log.info("Register_Existing_Email - Step 01: Click to Register link");
		registerPageObject = homePageObject.openRegisterPage();

		log.info("Register_Existing_Email - Step 02: Input to txtbox: \n" + "FirstName with old value: " + fstName + "\n"
				+ "LastName with old value: " + lstName + "\n" + "Email with old value: " + email + "\n"
				+ "Password with old value: " + password + "\n" + "ConfirmPassword with old value: "
				+ confirmPassword);
		log.info("Register_Success - Step 03: Click to Login btn");
		registerPageObject.RegisterAsUser(fstName, lstName, email, password, confirmPassword);

		log.info("Register_Existing_Email - Step 04: Verify exist Message Email");
		verifyEquals(registerPageObject.existMessageEmail(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		log.info("Register_Password_Less_Than_6_Chars - Step 01: Click to Register link");
		registerPageObject = homePageObject.openRegisterPage();

		log.info("Register_Password_Less_Than_6_Chars - Step 02: Input to txtbox: \n" + "FirstName with right value: " + fstName + "\n"
				+ "LastName with right value: " + lstName + "\n" + "Email with right value: " + email + "\n"
				+ "Password with wrong value: 123" + "\n" + "ConfirmPassword with right value: "
				+ confirmPassword );
		log.info("Register_Password_Less_Than_6_Chars - Step 03: Click to Login btn");
		registerPageObject.RegisterAsUser(fstName, lstName, email, "123", confirmPassword);

		log.info("Register_Password_Less_Than_6_Chars - Step 04: Verify error message Password-error");
		verifyEquals(registerPageObject.getErrorMessagePassword("Password-error"),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		log.info("Register_Invalid_Confirm_Password - Step 01: Click to Register link");
		registerPageObject = homePageObject.openRegisterPage();

		log.info("Register_Success - Step 02: Input to txtbox: \n" + "FirstName with right value: " + fstName + "\n"
				+ "LastName with right value: " + lstName + "\n" + "Email with right value: " + email + "\n"
				+ "Password with right value: " + password + "\n" + "ConfirmPassword with wrong value: 98757324");
		log.info("Register_Success - Step 03: Click to Register btn");
		registerPageObject.RegisterAsUser(fstName, lstName, email, password, "98757324");

		log.info("Register_Success - Step 04: Verify error message Confirm Password-error ");
		verifyEquals(registerPageObject.getErrorMessageConfirmPassword("ConfirmPassword-error"),
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
