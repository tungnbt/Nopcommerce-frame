package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject  extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driverClassTest) {
		this.driver = driverClassTest;
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public boolean isMyAccLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.My_ACC_LINK);
		return true;
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
	}

}
