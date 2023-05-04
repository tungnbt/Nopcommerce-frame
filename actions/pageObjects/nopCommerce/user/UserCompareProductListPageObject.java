package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCompareProductListPageUI;

public class UserCompareProductListPageObject extends BasePage{
	WebDriver driver; 
	
	public UserCompareProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageTitleDisplayed() {
		return isElementDisplayed(driver, UserCompareProductListPageUI.PAGE_TITLE);
	}

	public boolean isClearListBtnDisplayed() {
		return isElementDisplayed(driver, UserCompareProductListPageUI.CLEAR_LIST_BTN);
	}

	public boolean isRemoveBtnByProductNameDisplayed(String valueLocator) {
		waitForElementVisible(driver, UserCompareProductListPageUI.REMOVE_BTN_BY_PRODUCT_NAME, valueLocator);
		return isElementDisplayed(driver, UserCompareProductListPageUI.REMOVE_BTN_BY_PRODUCT_NAME, valueLocator);
	}

	public boolean isLabelDisplayed(String valueLocator) {
		return isElementDisplayed(driver, UserCompareProductListPageUI.LABEL_AT_COMPARE_PAGE, valueLocator);
	}

	public boolean isInfoByProductNameDisplayed(String productName, String info) {
		return isElementDisplayed(driver, UserCompareProductListPageUI.INFO_BY_PRODUCT_NAME, productName, info);
	}

	public boolean isInfoByProductNameUndisplayed(String productName, String info) {
		return isElementUndisplayed(driver, UserCompareProductListPageUI.INFO_BY_PRODUCT_NAME, productName, info);
	}
	
	public void clickToClearListBtn() {
		waitForElementClickable(driver, UserCompareProductListPageUI.CLEAR_LIST_BTN);
		clickToElementByJS(driver, UserCompareProductListPageUI.CLEAR_LIST_BTN);
	}

	public String getTxtMessageClearList() {
		waitForElementVisible(driver, UserCompareProductListPageUI.MESSAGE_CLEARED_LIST);
		return getElementText(driver, UserCompareProductListPageUI.MESSAGE_CLEARED_LIST);
	}
	
}
