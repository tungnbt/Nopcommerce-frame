package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject  extends BasePage{
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

	public void searchingToSearchStoreTxtbox(String valueKeySearchStore) {
		waitForElementVisible(driver, UserHomePageUI.SMALL_SEARCH_TERMS_TXT_BOX);
		sendKeyToElement(driver, UserHomePageUI.SMALL_SEARCH_TERMS_TXT_BOX, valueKeySearchStore);
	}

	public UserProductDetailPageObject clickToHintFromSearchStore() {
		waitForElementClickable(driver, UserHomePageUI.HINT_FROM_SEARCH_STORE);
		clickToElement(driver, UserHomePageUI.HINT_FROM_SEARCH_STORE);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

}