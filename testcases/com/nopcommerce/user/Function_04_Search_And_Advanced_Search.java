package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Function_04_Search_And_Advanced_Search extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		lstName = "iron";
		fstName = "man";
		existEmail = "ironman" + getRandomNumber() + "@gmail.com.vn";
		password = "123123";
		confirmPassword = "123123";
		searchKeyNoExist = "Macbook Pro 2050";
		relativeSearchKey = "Lenovo";
		absoluteSearchKey = "ThinkPad X1 Carbon";
		advancedSearch = "Apple Macbook Pro";
		System.out.println("Pre-Condition: Login success and Open Search Page(under footer)");
		userRegisterPage = userHomePage.openRegisterPage();
		userRegisterPage.RegisterAsUser(lstName, fstName, existEmail, password, confirmPassword);
		userLoginPage = userHomePage.openUserLoginPage();
		userLoginPage.LoginAsUser(existEmail, password);
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
	}

	@Test
	public void TCS_01_Search_with_empty_data() {
		userSearchPage.clickToSearchBtn();
		verifyEquals(userSearchPage.getTxtErrorMessage("warning"), "Search term minimum length is 3 characters");
	}

	@Test
	public void TCS_02_Search_with_data_not_exist() {
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.inputToSearchTxtbox(searchKeyNoExist);
		userSearchPage.clickToSearchBtn();
		verifyEquals(userSearchPage.getTxtErrorMessage("no-result"),
				"No products were found that matched your criteria.");
	}

	@Test
	public void TCS_03_Search_with_product_name_Relative() {
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.inputToSearchTxtbox(relativeSearchKey);
		userSearchPage.clickToSearchBtn();
		System.out.println("Found" + userSearchPage.isNumberOfProductResult() + "Product(s)");
		verifyEquals(userSearchPage.isNumberOfProductResult(), 2);
	}

	@Test
	public void TCS_04_Search_with_product_name_Absolute() {
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.inputToSearchTxtbox(absoluteSearchKey);
		userSearchPage.clickToSearchBtn();
		System.out.println("Found" + userSearchPage.isNumberOfProductResult() + "Product(s)");
		verifyEquals(userSearchPage.isNumberOfProductResult(), 1);
	}

	@Test
	public void TCS_05_Advanced_Searc_with_Parent_Categories() {
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers", "Category");
		userSearchPage.clickToSearchBtn();
		verifyEquals(userSearchPage.getTxtErrorMessage("no-result"),
				"No products were found that matched your criteria.");
	}

	@Test
	public void TCS_06_Advanced_Search_with_Sub_Categories() {
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers", "Category");
		userSearchPage.clickToAutomaticallySrchSubCategoriesCheckBox("Automatically search sub categories");
		userSearchPage.clickToSearchBtn();
		verifyEquals(userSearchPage.isNumberOfProductResult(), 1);
		System.out.println("Found" + "" + userSearchPage.isNumberOfProductResult() + "" + "Product(s)");
	}

	@Test
	public void TCS_07_Advanced_Searc_with_Incorrect_Manufacturer() {
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers", "Category");
		userSearchPage.clickToAutomaticallySrchSubCategoriesCheckBox("Automatically search sub categories");
		userSearchPage.selectManufacturerDropDown("HP", "Manufacturer");
		userSearchPage.clickToSearchBtn();
		verifyEquals(userSearchPage.getTxtErrorMessage("no-result"),
				"No products were found that matched your criteria.");
	}

	@Test
	public void TCS_08_Advanced_Searc_with_Correct_Manufacturer() {
		userHomePage.openPageAtFooterPage("Customer service", "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers", "Category");
		userSearchPage.clickToAutomaticallySrchSubCategoriesCheckBox("Automatically search sub categories");
		userSearchPage.selectManufacturerDropDown("Apple", "Manufacturer");
		userSearchPage.clickToSearchBtn();
		verifyEquals(userSearchPage.isNumberOfProductResult(), 1);
		System.out.println("Found" + userSearchPage.isNumberOfProductResult() + "Product(s)");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserSearchPageObject userSearchPage;
	private String lstName, fstName, existEmail, password, confirmPassword;
	private String searchKeyNoExist, relativeSearchKey, absoluteSearchKey, advancedSearch;
}
