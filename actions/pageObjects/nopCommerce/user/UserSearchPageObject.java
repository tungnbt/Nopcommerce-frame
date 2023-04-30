package pageObjects.nopCommerce.user;

import org.bouncycastle.math.Primes.STOutput;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchBtn() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BTN);
		clickToElement(driver, UserSearchPageUI.SEARCH_BTN);
	}

	public String getTxtErrorMessage(String valueLocator) {
		waitForElementVisible(driver, UserSearchPageUI.ERROR_MESSAGE_PRODUCT_SEACHED_NOT_FOUND, valueLocator);
		return getElementText(driver, UserSearchPageUI.ERROR_MESSAGE_PRODUCT_SEACHED_NOT_FOUND, valueLocator);
	}

	public void inputToSearchTxtbox(String keyValue) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_TXT_BOX);
		sendKeyToElement(driver, UserSearchPageUI.SEARCH_TXT_BOX, keyValue);

	}

	public int isNumberOfProductResult() {
		waitForAllElementsVisible(driver, UserSearchPageUI.PRODUCT_TITLE);
		return getElementSize(driver, UserSearchPageUI.PRODUCT_TITLE);
	}

	public void clickToAdvancedSearchCheckBox(String valueLocator) {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECK_BOX, valueLocator);
		clickToElementByJS(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECK_BOX, valueLocator);
	}

	public void selectCategoryDropDown(String txtItem, String valueLocator) {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_DROP_DOWN, valueLocator);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.ADVANCED_SEARCH_DROP_DOWN, txtItem, valueLocator);
	}

	public void clickToAutomaticallySrchSubCategoriesCheckBox(String valueLocator) {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECK_BOX, valueLocator);
		clickToElementByJS(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECK_BOX, valueLocator);
	}

	public void selectManufacturerDropDown(String txtItem, String valueLocator) {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_DROP_DOWN, valueLocator);
		selectItemInDefaultDropdown(driver, UserSearchPageUI.ADVANCED_SEARCH_DROP_DOWN, txtItem, valueLocator);
	}
}
