package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getInfoProductNameByProductName(String value) {
		waitForElementVisible(driver, UserShoppingCartPageUI.INFO_PRODUCT_NAME, value);
		return getElementText(driver, UserShoppingCartPageUI.INFO_PRODUCT_NAME, value);
	}

	public String getTxtTotalPriceByProductName(String valueLocator) {
		waitForElementVisible(driver, UserShoppingCartPageUI.TOTAL_PRICE_BY_PRODUCT_NAME,valueLocator);
		return getElementText(driver, UserShoppingCartPageUI.TOTAL_PRICE_BY_PRODUCT_NAME,valueLocator);
	}

	public void clickToRemoveBtnByProductName(String productName) {
		waitForElementClickable(driver, UserShoppingCartPageUI.REMOVE_BTN_BY_PRODUCT_NAME, productName);
		clickToElementByJS(driver, UserShoppingCartPageUI.REMOVE_BTN_BY_PRODUCT_NAME, productName);
	}

	public String getTxtEmptyAtShoppingCartPage() {
		waitForElementVisible(driver, UserShoppingCartPageUI.TXT_EMPTY_AT_SHOPPING_CART_PAGE);
		return getElementText(driver, UserShoppingCartPageUI.TXT_EMPTY_AT_SHOPPING_CART_PAGE);
	}

	public void inputToQtyTxtboxByProductName(String valueLocator, String valueQty) {
		waitForElementVisible(driver, UserShoppingCartPageUI.QTY_TXT_BOX_BY_PRODUCT_NAME,valueLocator);
		sendKeyToElement(driver, UserShoppingCartPageUI.QTY_TXT_BOX_BY_PRODUCT_NAME, valueQty, valueLocator);
	}

	public void clickToUpdateShoppingCartBtn() {
		waitForElementClickable(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BTN);
		clickToElement(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BTN);
	}

	public void clickToChkboxTheTermOfService() {
		waitForElementClickable(driver, UserShoppingCartPageUI.CHKBOX_THE_TERM_OF_SERVICE);
		clickToElement(driver, UserShoppingCartPageUI.CHKBOX_THE_TERM_OF_SERVICE);
	}

	public UserCheckoutPageObject openUserCheckoutPage() {
		waitForElementClickable(driver, UserShoppingCartPageUI.CHECK_OUT_BTN);
		clickToElement(driver, UserShoppingCartPageUI.CHECK_OUT_BTN);
		return PageGeneratorManager.getUserCheckoutPage(driver);
	}

	public UserProductDetailPageObject clickToEditBtnByProductName(String valueLocator) {
		waitForElementClickable(driver, UserShoppingCartPageUI.EDIT_BTN_BY_PRODUCT_NAME, valueLocator);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_BTN_BY_PRODUCT_NAME, valueLocator);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

}
