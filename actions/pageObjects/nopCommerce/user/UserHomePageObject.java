package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driverClassTest) {
		this.driver = driverClassTest;
	}

	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public UserLoginPageObject openUserLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public boolean isMyAccLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.My_ACC_LINK);
		return isElementDisplayed(driver, UserHomePageUI.My_ACC_LINK);
	}

	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.My_ACC_LINK);
		clickToElement(driver, UserHomePageUI.My_ACC_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public UserHomePageObject clickToHompageLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGO_HOME_PAGE_LINK);
		clickToElement(driver, UserHomePageUI.LOGO_HOME_PAGE_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void inputToSearchStoreTxtbox(String valueKeySearchStore) {
		waitForElementVisible(driver, UserHomePageUI.SMALL_SEARCH_TERMS_TXT_BOX);
		sendKeyToElement(driver, UserHomePageUI.SMALL_SEARCH_TERMS_TXT_BOX, valueKeySearchStore);
	}

	public UserProductDetailPageObject clickToHintFromSearchStore() {
		waitForElementClickable(driver, UserHomePageUI.HINT_FROM_SEARCH_STORE);
		clickToElement(driver, UserHomePageUI.HINT_FROM_SEARCH_STORE);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void openPageAtFooterPage(String... valueLocator) {
		waitForElementClickable(driver, UserHomePageUI.OPEN_PAGE_LINK_AT_FOOTER_PAGE, valueLocator);
		clickToElement(driver, UserHomePageUI.OPEN_PAGE_LINK_AT_FOOTER_PAGE, valueLocator);
	}

	public void openSubMenuPageAtHeaderMenu(String parentLocator, String subLocator) {
		waitForElementVisible(driver, UserHomePageUI.TOP_MENU_AT_HEADER, parentLocator);
		hoverMouseToElement(driver, UserHomePageUI.TOP_MENU_AT_HEADER, parentLocator);
		waitForElementVisible(driver, UserHomePageUI.SUB_MENU_AT_HEADER, subLocator);
		clickToElement(driver, UserHomePageUI.SUB_MENU_AT_HEADER, subLocator);
	}

	public UserWishlistPageObject clickWishlistPage() {
		waitForElementClickable(driver, UserHomePageUI.WISHLIST_LINK);
		clickToElement(driver, UserHomePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getUserWishlistPage(driver);
	}

}
