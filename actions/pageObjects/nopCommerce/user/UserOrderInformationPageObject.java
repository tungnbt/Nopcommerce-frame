package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserOrderInformationPageUI;

public class UserOrderInformationPageObject extends BasePage{
	WebDriver driver;
	
	public UserOrderInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserShoppingCartPageObject clickToReOrderBtn() {
		waitForElementClickable(driver, UserOrderInformationPageUI.RE_OPEN_BTN);
		clickToElement(driver, UserOrderInformationPageUI.RE_OPEN_BTN);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}
}
