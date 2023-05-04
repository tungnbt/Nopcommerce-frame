package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserNoteBooksPageUI;

public class UserDesktopsPageObject extends BasePage{
	WebDriver driver;
	
	public UserDesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductDetailPageObject clickToTitleProductLink(String productTitle1) {
		waitForElementClickable(driver, UserNoteBooksPageUI.PRODUCT_TITLE_LINK, productTitle1);
		clickToElement(driver, UserNoteBooksPageUI.PRODUCT_TITLE_LINK, productTitle1);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}
}
