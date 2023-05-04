package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCompareProductListPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNoteBooksPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserRecentlyProductListPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;

public class Function_06_Wishlist_Compare_Recent_View extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		lstName = "man";
		fstName = "iron";
		fullName = fstName + " " + lstName;
		password = "123456";
		confirmPassword = "123456";
		existEmail = "ironman" + getRandomNumber() + "@gmail.com.vn";
		productTitle1 = "Asus N551JK-XO076H Laptop";
		productTitle2 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
		productTitle3 = "HP Spectre XT Pro UltraBook";
		productTitle4 = "Lenovo Thinkpad X1 Carbon Laptop";
		productTitle5 = "Samsung Series 9 NP900X4C Premium Ultrabook";
		System.out.println("Pre-condition: Login success + open any product");
		registerPageObject = userHomePage.openRegisterPage();
		registerPageObject.RegisterAsUser(fstName, lstName, existEmail, password, confirmPassword);
		loginPageObject = userHomePage.openUserLoginPage();
		loginPageObject.LoginAsUser(existEmail, password);
		System.out.println("Login success");
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userProductDetailPage = userNoteBooksPage.clickToTitleProductLink(productTitle2);
		System.out.println("Open any product");
	}

	@Test
	public void TCS_01_Add_to_Wishlist() {
		System.out.println("TCS_01_Add_to_Wishlist");
		userProductDetailPage.clickToOverviewBtn("Add to wishlist");
		verifyEquals(userProductDetailPage.getTxtMessageAddedToWhislist(),
				"The product has been added to your wishlist");
		userWishlistPage = userProductDetailPage.openWishlistPageAtMessage();
		verifyEquals(userWishlistPage.getTxtNameProductByWishlistTableTitle(productTitle2), productTitle2);
		userWishlistPage.clickToYourWishlistURLForSharing();
		verifyEquals(userWishlistPage.getTxtWishlistPageTitle(), "Wishlist of" + " " + fullName);
	}

	@Test
	public void TCS_02_Add_Product_To_Cart_from_Wishlist_page() {
		System.out.println("TCS_02_Add_Product_To_Cart_from_Wishlist_page");
		userWishlistPage.clickToCheckBoxByProductName(productTitle2);
		userShoppingCartPage = userWishlistPage.clickToAddToCartBtn();
		sleepInSecond(3);
		userWishlistPage = userHomePage.clickWishlistPage();
		verifyTrue(userWishlistPage.isProductUndisplayed(productTitle2));
	}

	@Test
	public void TCS_03_Remove_product_in_Wishlist_page() {
		System.out.println("TCS_03_Remove_product_in_Wishlist_page");
		userWishlistPage.clickToRemoveProductByWishlistTableTitle(productTitle2);
		verifyTrue(userWishlistPage.isProductUndisplayed(productTitle2));
		verifyEquals(userWishlistPage.getTxtMessageEmpty().contains("The wishlist is empty!"), "The wishlist is empty!");
	}

	@Test
	public void TCS_04_Add_product_to_Compare() {
		System.out.println("TCS_04_Add_product_to_Compare");
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userNoteBooksPage.clickToButtonByProductName(productTitle1, "Add to compare list");
		verifyEquals(userNoteBooksPage.isMessageAddedToCompareDisplayed(),
				"The product has been added to your product comparison");
		userNoteBooksPage.clickToButtonByProductName(productTitle2, "Add to compare list");
		verifyEquals(userNoteBooksPage.isMessageAddedToCompareDisplayed(),
				"The product has been added to your product comparison");
		userCompareProductListPage = userNoteBooksPage.clickToProductComparisonLink();
		verifyTrue(userCompareProductListPage.isPageTitleDisplayed());
		verifyTrue(userCompareProductListPage.isClearListBtnDisplayed());
		verifyTrue(userCompareProductListPage.isRemoveBtnByProductNameDisplayed(productTitle1));
		verifyTrue(userCompareProductListPage.isRemoveBtnByProductNameDisplayed(productTitle2));
		verifyTrue(userCompareProductListPage.isLabelDisplayed("Name"));
		verifyTrue(userCompareProductListPage.isLabelDisplayed("Price"));
		verifyTrue(userCompareProductListPage.isInfoByProductNameDisplayed(productTitle1, "$1,500.00"));

		userCompareProductListPage.clickToClearListBtn();
		verifyEquals(userCompareProductListPage.getTxtMessageClearList(), "You have no items to compare.");
		verifyTrue(userCompareProductListPage.isInfoByProductNameUndisplayed(productTitle2, "Intel Core i7"));
	}

	@Test
	public void TCS_05_Add_product_to_Compare() {
		System.out.println("TCS_05_Add_product_to_Compare");
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userNoteBooksPage.clickToTitleProductLink(productTitle1);
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userNoteBooksPage.clickToTitleProductLink(productTitle2);
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userNoteBooksPage.clickToTitleProductLink(productTitle3);
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userNoteBooksPage.clickToTitleProductLink(productTitle4);
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userNoteBooksPage.clickToTitleProductLink(productTitle5);
		userHomePage.openPageAtFooterPage("Customer service", "Recently viewed products");
		userRecentlyProductListPage = PageGeneratorManager.getRecentlyProductListPage(driver);
		verifyEquals(userRecentlyProductListPage.getTxtTitleProductNameByPosition("1"), productTitle5);
		verifyEquals(userRecentlyProductListPage.getTxtTitleProductNameByPosition("2"), productTitle4);
		verifyEquals(userRecentlyProductListPage.getTxtTitleProductNameByPosition("3"), productTitle3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject loginPageObject;
	private UserRegisterPageObject registerPageObject;
	private UserProductDetailPageObject userProductDetailPage;
	private UserNoteBooksPageObject userNoteBooksPage;
	private UserWishlistPageObject userWishlistPage;
	private UserCompareProductListPageObject userCompareProductListPage;
	private UserRecentlyProductListPageObject userRecentlyProductListPage;
	private UserShoppingCartPageObject userShoppingCartPage;
	private String lstName, fstName, fullName, password, confirmPassword, existEmail;
	private String productTitle1, productTitle2, productTitle3, productTitle4, productTitle5;
}
