package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserInputeReviewProductPageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Function_03_My_Account extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverClassTest = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driverClassTest);
		lstName = "iron";
		fstName = "man";
		password = "123456";
		confirmPassword = "123456";
		existEmail = "ironman" + getRandomNumber() + "@gmail.com.vn";
		editedEmail = "abc" + getRandomNumber() + "@gmail.com";
		dayOfBirth = "2";
		monthOfBirth = "September";
		yearOfBirth = "2000";
		companyName = "doofenshmirtz evil incorporated";
		addFstName = "Tony";
		addLstName = "Cruise";
		addFullName = addFstName + " " + addLstName;
		addEmail = "tonycruise@gmail.vn";
		addCompany = "Tony Company";
		addCountry = "Viet Nam";
		addCity = "Ha Noi";
		address1 = "123/34 Le Duan";
		address2 = "123/21 Le Van Luong";
		addZipcode = "1000";
		addPhonenumer = "123456789";
		addFaxNumber = "098765543";
		newPassword = "123123";
		confirmNewPassword = "123123";
		valueKeySearchStore = "MacBook";
		reviewTitle = "Abcdf";
		reviewTxt = "doofenshmirtz\nevil\nincorporated";
		System.out.println("Precondition: Register and Login sucess");
		registerPageObject = homePageObject.openRegisterPage();
		registerPageObject.RegisterAsUser(lstName, fstName, existEmail, password, confirmPassword);
		loginPageObject = homePageObject.openUserLoginPage();
		loginPageObject.LoginAsUser(existEmail, password);
	}

	@Test
	public void TC_01_Customer_Info() {
		userCustomerInfoPage = homePageObject.clickToMyAccountLink();
		userCustomerInfoPage.clickToGenderRadioBtn("male");
		userCustomerInfoPage.inputToFstNameTxtBox(fstName, "FirstName");
		userCustomerInfoPage.inputToLstNameTxtBox(lstName, "LastName");
		userCustomerInfoPage.selectDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
		userCustomerInfoPage.inputToEmailTxtBox(editedEmail, "Email");
		userCustomerInfoPage.inputToCompanyTxtBox(companyName, "Company");
		userCustomerInfoPage.clickToSaveBtn();
		Assert.assertEquals(userCustomerInfoPage.getTxtNotificationUpdatedSuccessfully(),
				"The customer info has been updated successfully.");
	}

	@Test
	public void TC_02_Addresses() {
		userCustomerInfoPage.openPageAtMyAccountPageName(driverClassTest, "Addresses");
		userUserAddressesPage = PageGeneratorManager.getUserAddressesPage(driverClassTest);
		userUserAddressesPage.clickAddNewBtn();
		userUserAddressesPage.inputToFstNameTxtBox(addFstName, "FirstName");
		userUserAddressesPage.inputToLstNameTxtBox(addLstName, "LastName");
		userUserAddressesPage.inputToEmailTxtBox(addEmail, "Email");
		userUserAddressesPage.inputToCompanyTxtBox(addCompany, "Company");
		userUserAddressesPage.selectToCountryTxtBox(addCountry);
		userUserAddressesPage.selectToCityTxtBox(addCity, "City");
		userUserAddressesPage.inputToAddress1TxtBox(address1, "Address1");
		userUserAddressesPage.inputToAddress2TxtBox(address2, "Address2");
		userUserAddressesPage.inputToZipCodeTxtBox(addZipcode, "ZipPostalCode");
		userUserAddressesPage.inputToPhoneNumberTxtBox(addPhonenumer, "PhoneNumber");
		userUserAddressesPage.inputToFaxNumberTxtBox(addFaxNumber, "FaxNumber");
		userUserAddressesPage.clickToSaveBtn();
		Assert.assertTrue(userUserAddressesPage.getTxtFullName(addFullName, "name").contains(addFullName));
		Assert.assertTrue(userUserAddressesPage.getTxtEmail(addFullName, "email").contains(addEmail));
		Assert.assertTrue(userUserAddressesPage.getTxtCompany(addFullName, "company").contains(addCompany));
		Assert.assertTrue(userUserAddressesPage.getTxtAddress1(addFullName, "address1").contains(address1));
		Assert.assertTrue(userUserAddressesPage.getTxtAddress2(addFullName, "address2").contains(address2));
		Assert.assertTrue(userUserAddressesPage.getTxtCity(addFullName, "city-state-zip").contains(addCity));
		Assert.assertTrue(userUserAddressesPage.getTxtZipcode(addFullName, "city-state-zip").contains(addZipcode));
		Assert.assertTrue(userUserAddressesPage.getTxtPhoneNumber(addFullName, "phone").contains(addPhonenumer));
		Assert.assertTrue(userUserAddressesPage.getTxtFaxNumber(addFullName, "fax").contains(addFaxNumber));
		Assert.assertTrue(userUserAddressesPage.getTxtCountry(addFullName, "country").contains(addCountry));
	}

	@Test
	public void TC_03_Change_password() {
		userUserAddressesPage.openPageAtMyAccountPageName(driverClassTest, "Change password");
		userChangePasswordPage = PageGeneratorManager.getUserChangePassword(driverClassTest);
		userChangePasswordPage.inputToOldPasswordTxtbox(password, "OldPassword");
		userChangePasswordPage.inputToNewPasswordTxtbox(newPassword, "NewPassword");
		userChangePasswordPage.inputToConfirmNewPasswordTxtbox(confirmNewPassword, "ConfirmNewPassword");
		userChangePasswordPage.clickToChangePasswordBtn();
		Assert.assertTrue(userChangePasswordPage.isMessageChangedPassSuccess());

		homePageObject.clickToHompageLink();
		loginPageObject = homePageObject.openUserLoginPage();
		loginPageObject.LoginAsUser(editedEmail, newPassword);
		Assert.assertTrue(homePageObject.isMyAccLinkDisplayed());
	}

	@Test
	public void TC_04_My_Product_Reviews() {
		homePageObject.clickToHompageLink();
		homePageObject.inputToSearchStoreTxtbox(valueKeySearchStore);
		userProductDetailPage = homePageObject.clickToHintFromSearchStore();
		userInputeReviewProductPage = userProductDetailPage.clickToAddYourReviewLink();
		userInputeReviewProductPage.inputToReviewTitle(reviewTitle);
		userInputeReviewProductPage.inputToReviewTxt(reviewTxt);
		userInputeReviewProductPage.clickToSubmitReviewBtn();

		userCustomerInfoPage = homePageObject.clickToMyAccountLink();
		userCustomerInfoPage.openPageAtMyAccountPageName(driverClassTest, "My product reviews");
		userMyProductReviewsPage = PageGeneratorManager.getUserMyProductReviewsPage(driverClassTest);
		Assert.assertTrue(userMyProductReviewsPage.getTxtReviewTitle().equals(reviewTitle));
		Assert.assertTrue(userMyProductReviewsPage.getTxtReview().equals(reviewTxt));
		Assert.assertTrue(userMyProductReviewsPage.getTxtNameProductReview().contains(valueKeySearchStore));
	}

	@AfterClass
	public void afterClass() {
		driverClassTest.quit();
	}

	private WebDriver driverClassTest;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private UserCustomerInforPageObject userCustomerInfoPage;
	private UserAddressesPageObject userUserAddressesPage;
	private UserChangePasswordPageObject userChangePasswordPage;
	private UserMyProductReviewsPageObject userMyProductReviewsPage;
	private UserProductDetailPageObject userProductDetailPage;
	private UserInputeReviewProductPageObject userInputeReviewProductPage;
	private String existEmail, password, confirmPassword, lstName, fstName, editedEmail, companyName;
	private String dayOfBirth, monthOfBirth, yearOfBirth;
	private String addFstName, addLstName, addEmail, addCompany, addCountry, addCity, address1, address2, addZipcode,
			addPhonenumer, addFaxNumber, newPassword, confirmNewPassword, valueKeySearchStore, reviewTitle, reviewTxt,
			addFullName;
}
