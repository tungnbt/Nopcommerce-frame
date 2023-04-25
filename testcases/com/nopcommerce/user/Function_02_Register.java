package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Function_02_Register extends BaseTest {
	private WebDriver driverClassTest;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	private LoginPageObject loginPageObject;
	private String lstName, fstName, email, password, confirmPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverClassTest = getBrowserDriver(browserName);
		homePageObject = new HomePageObject(driverClassTest);
		registerPageObject = new RegisterPageObject(driverClassTest);
		loginPageObject = new LoginPageObject(driverClassTest);
		lstName = "iron";
		fstName = "man";
		email = "ironman" + getRandomNumber() + "@gmail.com.vn";
		password = "123456";
		confirmPassword = "123456";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		homePageObject.clickToRegisterLink();

		registerPageObject.clickToRegisterBtn();

		Assert.assertEquals(registerPageObject.getErrorMessageFstName(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageLstName(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageEmail(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessagePassword(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPassword(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFstNameTxtbox(fstName);
		registerPageObject.inputToLstNameTxtbox(lstName);
		registerPageObject.inputToEmailTxtbox("asd");
		registerPageObject.inputToPasswordTxtbox(password);
		registerPageObject.inputToConfirmPasswordTxtbox(confirmPassword);
		registerPageObject.clickToRegisterBtn();

		Assert.assertEquals(registerPageObject.getErrorMessageEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFstNameTxtbox(fstName);
		registerPageObject.inputToLstNameTxtbox(lstName);
		registerPageObject.inputToEmailTxtbox(email);
		registerPageObject.inputToPasswordTxtbox(password);
		registerPageObject.inputToConfirmPasswordTxtbox(confirmPassword);
		registerPageObject.clickToRegisterBtn();

		homePageObject.clickToLoginLink();

		loginPageObject.inputToEmailTxtbox(email);
		loginPageObject.inputToPasswordTxtbox(confirmPassword);
		loginPageObject.clickToLoginBtn();
		Assert.assertTrue(homePageObject.isMyAccLinkDisplayed());

		homePageObject.clickToLogoutLink();
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFstNameTxtbox(fstName);
		registerPageObject.inputToLstNameTxtbox(lstName);
		registerPageObject.inputToEmailTxtbox(email);
		registerPageObject.inputToPasswordTxtbox(password);
		registerPageObject.inputToConfirmPasswordTxtbox(confirmPassword);
		registerPageObject.clickToRegisterBtn();

		Assert.assertEquals(registerPageObject.existMessageEmail(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFstNameTxtbox(fstName);
		registerPageObject.inputToLstNameTxtbox(lstName);
		registerPageObject.inputToEmailTxtbox(email);
		registerPageObject.inputToPasswordTxtbox("123");
		registerPageObject.inputToConfirmPasswordTxtbox(confirmPassword);
		registerPageObject.clickToRegisterBtn();

		Assert.assertEquals(registerPageObject.getErrorMessagePassword(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFstNameTxtbox(fstName);
		registerPageObject.inputToLstNameTxtbox(lstName);
		registerPageObject.inputToEmailTxtbox(email);
		registerPageObject.inputToPasswordTxtbox(password);
		registerPageObject.inputToConfirmPasswordTxtbox("98757324");
		registerPageObject.clickToRegisterBtn();

		Assert.assertEquals(registerPageObject.getErrorMessageConfirmPassword(),
				"The password and confirmation password do not match.\n");

	}

	@AfterClass
	public void afterClass() {

	}

}
