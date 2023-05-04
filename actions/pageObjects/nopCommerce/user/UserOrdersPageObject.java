package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserOrdersPageUI;

public class UserOrdersPageObject extends BasePage{
	WebDriver driver;
	
	public UserOrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTxtOrderNumber(String string) {
		waitForElementVisible(driver, UserOrdersPageUI.TXT_ORDER_NUMBER, string);
		return getElementText(driver, UserOrdersPageUI.TXT_ORDER_NUMBER, string);
	}

	public UserOrderInformationPageObject clickToDetailsBtnByOrderNumber(String orderNumber) {
		waitForElementClickable(driver, UserOrdersPageUI.DETAILS_BTN_BY_ORDER_NUMBER, orderNumber);
		clickToElement(driver, UserOrdersPageUI.DETAILS_BTN_BY_ORDER_NUMBER, orderNumber);
		return PageGeneratorManager.getUserOrderInformationPage(driver);
	}
}
