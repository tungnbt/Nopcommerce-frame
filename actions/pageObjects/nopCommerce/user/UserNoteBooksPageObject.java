package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserNoteBooksPageUI;

public class UserNoteBooksPageObject extends BasePage {
	WebDriver driver;

	public UserNoteBooksPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductDetailPageObject clickToTitleProductLink(String valueLocator) {
		waitForElementClickable(driver, UserNoteBooksPageUI.PRODUCT_TITLE_LINK, valueLocator);
		clickToElement(driver, UserNoteBooksPageUI.PRODUCT_TITLE_LINK, valueLocator);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void clickToButtonByProductName(String productName, String titleBtn) {
		waitForElementClickable(driver, UserNoteBooksPageUI.BUTTON_BY_PRODUCT_NAME, productName, titleBtn);
		clickToElement(driver, UserNoteBooksPageUI.BUTTON_BY_PRODUCT_NAME, productName, titleBtn);
	}

	public String isMessageAddedToCompareDisplayed() {
		waitForElementVisible(driver, UserNoteBooksPageUI.MESSAGE_ADDED_TO_COMPARE);
		return getElementText(driver, UserNoteBooksPageUI.MESSAGE_ADDED_TO_COMPARE);
	}

	public UserCompareProductListPageObject clickToProductComparisonLink() {
		waitForElementClickable(driver, UserNoteBooksPageUI.PRODUCT_COMPARISON_LINK);
		clickToElement(driver, UserNoteBooksPageUI.PRODUCT_COMPARISON_LINK);
		return PageGeneratorManager.getUserCompareProductListPage(driver);
	}

}
