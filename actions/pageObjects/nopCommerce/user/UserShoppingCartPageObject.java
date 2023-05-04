package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage{
	WebDriver driver;
	
	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getInfoProductNameByProductName(String value) {
		waitForElementVisible(driver, UserShoppingCartPageUI.INFO_PRODUCT_NAME ,value);
		return getElementText(driver, UserShoppingCartPageUI.INFO_PRODUCT_NAME, value);
	}

	public String getTxtTotalPriceByProductName() {
		waitForElementVisible(driver, UserShoppingCartPageUI.TOTAL_PRICE_BY_PRODUCT_NAME);
		return getElementText(driver, UserShoppingCartPageUI.TOTAL_PRICE_BY_PRODUCT_NAME);
	}

	public void clickToRemoveBtnByProductName(String productName) {
		waitForElementClickable(driver, UserShoppingCartPageUI.REMOVE_BTN_BY_PRODUCT_NAME, productName);
		clickToElementByJS(driver, UserShoppingCartPageUI.REMOVE_BTN_BY_PRODUCT_NAME, productName);
	}

	public String getTxtEmptyAtShoppingCartPage() {
		waitForElementVisible(driver, UserShoppingCartPageUI.TXT_EMPTY_AT_SHOPPING_CART_PAGE);
		return getElementText(driver, UserShoppingCartPageUI.TXT_EMPTY_AT_SHOPPING_CART_PAGE);
	}

	public void inputToQtyTxtboxByProductName(String valueQty) {
		waitForElementVisible(driver, UserShoppingCartPageUI.QTY_TXT_BOX_BY_PRODUCT_NAME);
		sendKeyToElement(driver, UserShoppingCartPageUI.QTY_TXT_BOX_BY_PRODUCT_NAME, valueQty);
	}

	public void clickToUpdateShoppingCart() {
		waitForElementClickable(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART);
		clickToElement(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART);
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

	public UserProductDetailPageObject clickToEditBtnByProductName() {
		waitForElementClickable(driver, UserShoppingCartPageUI.EDIT_BTN_BY_PRODUCT_NAME);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_BTN_BY_PRODUCT_NAME);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public void clickToUpdateShoppingCartBtn() {
		waitForElementClickable(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BTN);
		clickToElement(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BTN);
	}
}
