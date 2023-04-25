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

public class Function_01_Login extends BaseTest {
	private WebDriver driverClassTest;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	private LoginPageObject loginPageObject;
	private String existEmail, password, confirmPassword, lstName, fstName, invalidEmail, notFoundEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverClassTest = getBrowserDriver(browserName);
		homePageObject = new HomePageObject(driverClassTest);
		registerPageObject = new RegisterPageObject(driverClassTest);
		loginPageObject = new LoginPageObject(driverClassTest);
		lstName = "iron";
		fstName = "man";
		existEmail = "ironman" + getRandomNumber() + "@gmail.com.vn";
		invalidEmail = "asdskm";
		notFoundEmail = "";
		password = "123456";
		confirmPassword = "123456";
		System.out.println("Precondition: Register sucess");
		homePageObject.clickToRegisterLink();

		registerPageObject.inputToFstNameTxtbox(fstName);
		registerPageObject.inputToLstNameTxtbox(lstName);
		registerPageObject.inputToEmailTxtbox(existEmail);
		registerPageObject.inputToPasswordTxtbox(password);
		registerPageObject.inputToConfirmPasswordTxtbox(confirmPassword);
		registerPageObject.clickToRegisterBtn();

		homePageObject.clickToLoginLink();
	}

	@Test
	public void TC_01_Empty_Data() {
		loginPageObject.clickToLoginBtn();

		Assert.assertEquals(loginPageObject.getErrorMessageEmail(), "Please enter your email");
	}

	@Test
	public void TC_02_Invalid_Email() {
		homePageObject.clickToLoginLink();

		loginPageObject.inputToEmailTxtbox(invalidEmail);
		loginPageObject.clickToLoginBtn();

		Assert.assertEquals(loginPageObject.getErrorMessageEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Email_Not_Found() {
		homePageObject.clickToLoginLink();

		loginPageObject.inputToEmailTxtbox(notFoundEmail);
		loginPageObject.clickToLoginBtn();

		Assert.assertEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Existing_Email_Empty_Password() {
		homePageObject.clickToLoginLink();

		loginPageObject.inputToEmailTxtbox(existEmail);
		loginPageObject.clickToLoginBtn();

		Assert.assertEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Existing_Email_Incorrect_Password() {
		homePageObject.clickToLoginLink();

		loginPageObject.inputToEmailTxtbox(existEmail);
		loginPageObject.inputToPasswordTxtbox("89789798");
		loginPageObject.clickToLoginBtn();

		Assert.assertEquals(loginPageObject.unsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Valid_Email_Password() {
		homePageObject.clickToLoginLink();

		loginPageObject.inputToEmailTxtbox(existEmail);
		loginPageObject.inputToPasswordTxtbox("89789798");
		loginPageObject.clickToLoginBtn();
		
		Assert.assertTrue(homePageObject.isMyAccLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driverClassTest.quit();
	}

}
