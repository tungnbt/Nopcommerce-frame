package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.UserCompareProductListPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserInputeReviewProductPageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.user.UserNoteBooksPageObject;
import pageObjects.nopCommerce.user.UserOrderInformationPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserRecentlyProductListPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;

public class PageGeneratorManager extends BasePage{
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInforPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	
	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	
	public static UserChangePasswordPageObject getUserChangePassword(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}
	
	public static UserInputeReviewProductPageObject getUserInputeReviewProductPage(WebDriver driver) {
		return new UserInputeReviewProductPageObject(driver);
	}
	
	public static UserProductDetailPageObject getUserProductDetailPage(WebDriver driver) {
		return new UserProductDetailPageObject(driver);
	}

	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}

	public static UserNoteBooksPageObject getUserNoteBooksPage(WebDriver driver) {
		return new UserNoteBooksPageObject(driver);
	}

	public static UserShoppingCartPageObject getUserShoppingCartPage(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}

	public static UserWishlistPageObject getUserWishlistPage(WebDriver driver) {
		return new UserWishlistPageObject(driver);
	}
	
	public static UserCompareProductListPageObject getUserCompareProductListPage(WebDriver driver) {
		return new UserCompareProductListPageObject(driver);
	}

	public static UserRecentlyProductListPageObject getRecentlyProductListPage(WebDriver driver) {
		return new UserRecentlyProductListPageObject(driver);
	}

	public static UserDesktopsPageObject getUserDesktopsPage(WebDriver driver) {
		return new UserDesktopsPageObject(driver);
	}
	
	public static UserCheckoutPageObject getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}

	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}

	public static UserOrderInformationPageObject getUserOrderInformationPage(WebDriver driver) {
		return new UserOrderInformationPageObject(driver);
	}
}
