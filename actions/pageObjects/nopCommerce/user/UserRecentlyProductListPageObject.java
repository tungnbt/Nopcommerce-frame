package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserRecentlyProductListPageUI;

public class UserRecentlyProductListPageObject extends BasePage{
	WebDriver driver;
	
	public UserRecentlyProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTxtTitleProductNameByPosition(String position) {
		waitForElementVisible(driver, UserRecentlyProductListPageUI.TITLE_PRODUCT_NAME_BY_POSITION,position);
		return getElementText(driver, UserRecentlyProductListPageUI.TITLE_PRODUCT_NAME_BY_POSITION,position);
	}
}
