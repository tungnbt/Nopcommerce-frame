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
import org.testng.Assert;
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
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
	}

	@Test
	public void TCS_01_Search_with_empty_data() {
		userSearchPage.clickToSearchBtn();
		Assert.assertEquals(userSearchPage.getTxtErrorMessage("warning"), "Search term minimum length is 3 characters");
	}

	@Test
	public void TCS_02_Search_with_data_not_exist() {
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
		userSearchPage.inputToSearchTxtbox(searchKeyNoExist);
		userSearchPage.clickToSearchBtn();
		Assert.assertEquals(userSearchPage.getTxtErrorMessage("no-result"), "No products were found that matched your criteria.");
	}

	@Test
	public void TCS_03_Search_with_product_name_Relative() {
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
		userSearchPage.inputToSearchTxtbox(relativeSearchKey);
		userSearchPage.clickToSearchBtn();
		System.out.println("Found" + userSearchPage.isNumberOfProductResult() + "Product(s)" );
	}

	@Test
	public void TCS_04_Search_with_product_name_Absolute() {
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
		userSearchPage.inputToSearchTxtbox(absoluteSearchKey);
		userSearchPage.clickToSearchBtn();
		System.out.println("Found" + userSearchPage.isNumberOfProductResult() + "Product(s)" );
	}

	@Test
	public void TCS_05_Advanced_Searc_with_Parent_Categories() {
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers","Category");
		userSearchPage.clickToSearchBtn();
		Assert.assertEquals(userSearchPage.getTxtErrorMessage("no-result"), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TCS_06_Advanced_Search_with_Sub_Categories() {
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers","Category");
		userSearchPage.clickToAutomaticallySrchSubCategoriesCheckBox("Automatically search sub categories");
		userSearchPage.clickToSearchBtn();
		System.out.println("Found" + userSearchPage.isNumberOfProductResult() + "Product(s)" );
	}

	@Test
	public void TCS_07_Advanced_Searc_with_Incorrect_Manufacturer() {
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers","Category");
		userSearchPage.clickToAutomaticallySrchSubCategoriesCheckBox("Automatically search sub categories");
		userSearchPage.selectManufacturerDropDown("HP","Manufacturer");
		userSearchPage.clickToSearchBtn();
		Assert.assertEquals(userSearchPage.getTxtErrorMessage("no-result"), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TCS_08_Advanced_Searc_with_Correct_Manufacturer() {
		userSearchPage = userHomePage.openSearchPage("Customer service", "Search");
		userSearchPage.inputToSearchTxtbox(advancedSearch);
		userSearchPage.clickToAdvancedSearchCheckBox("Advanced search");
		userSearchPage.selectCategoryDropDown("Computers","Category");
		userSearchPage.clickToAutomaticallySrchSubCategoriesCheckBox("Automatically search sub categories");
		userSearchPage.selectManufacturerDropDown("Apple","Manufacturer");
		userSearchPage.clickToSearchBtn();
		System.out.println("Found" + userSearchPage.isNumberOfProductResult() + "Product(s)" );
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserSearchPageObject userSearchPage;
	private UserRegisterPageObject userRegisterPage;
	private String lstName, fstName, existEmail, password, confirmPassword; 
	private String searchKeyNoExist, relativeSearchKey, absoluteSearchKey, advancedSearch;
}
