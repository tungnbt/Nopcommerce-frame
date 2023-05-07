package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserCheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
	WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTxtboxByLabel(String valueLabel, String valueTxt) {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_BOX_BY_LABEL, valueLabel);
		sendKeyToElement(driver, UserCheckoutPageUI.TXT_BOX_BY_LABEL, valueTxt, valueLabel);
	}

	public void selectToDropDownByLabel(String valueLabel, String txtItem) {
		waitForElementVisible(driver, UserCheckoutPageUI.DROP_DOWN_BY_LABEL, valueLabel);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.DROP_DOWN_BY_LABEL, txtItem, valueLabel);
	}

	public UserHomePageObject clickToContinueBtnByStepName(String valueLocator) {
		waitForElementClickable(driver, UserCheckoutPageUI.CONTINUE_BTN_BY_STEP_NAME, valueLocator);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BTN_BY_STEP_NAME, valueLocator);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void clickToShippingMethodRadioBtn(String valueLocator) {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_METHOD_RADIO_BTN, valueLocator);
		clickToElement(driver, UserCheckoutPageUI.SHIPPING_METHOD_RADIO_BTN, valueLocator);
	}

	public void clickToPaymentMethodRadioBtn(String valueLocator) {
		waitForElementClickable(driver, UserCheckoutPageUI.PAYMENT_METHOD_RADIO_BTN, valueLocator);
		clickToElement(driver, UserCheckoutPageUI.PAYMENT_METHOD_RADIO_BTN, valueLocator);
	}

	public boolean isPaymentInfoUndisplayed() {
		return isElementDisplayed(driver, UserCheckoutPageUI.SELECT_DROP_DOWN_BY_ID);
	}

	public String getTxtAddressConfirmOrder(String valueLocator) {
		waitForElementVisible(driver, UserCheckoutPageUI.ADDRESS_CONFIRM_ORDER, valueLocator);
		return getElementText(driver, UserCheckoutPageUI.ADDRESS_CONFIRM_ORDER, valueLocator);
	}

	public String getTxtProductNameByProductLabel(String valueLocator) {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_PRODUCT_NAME_BY_PRODUCT_LABEL, valueLocator);
		return getElementText(driver, UserCheckoutPageUI.TXT_PRODUCT_NAME_BY_PRODUCT_LABEL, valueLocator);
	}

	public String getTxtInfoByProductName(String productName, String valueLabel) {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_INFO_BY_PRODUCT_NAME, productName, valueLabel);
		return getElementText(driver, UserCheckoutPageUI.TXT_INFO_BY_PRODUCT_NAME, productName, valueLabel);
	}

	public String getTxtTotlaByLabelName(String labelName, String value) {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_TOTAL_BY_LABEL_NAME, labelName, value);
		return getElementText(driver, UserCheckoutPageUI.TXT_TOTAL_BY_LABEL_NAME, labelName, value);
	}

	public String getTxtShippingMethod() {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_SHIPPING_METHOD);
		return getElementText(driver, UserCheckoutPageUI.TXT_SHIPPING_METHOD);
	}

	public String getTxtOrderSuccessfully() {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_ORDER_SUCCESSFULLY);
		return getElementText(driver, UserCheckoutPageUI.TXT_ORDER_SUCCESSFULLY);
	}

	public String getTxtNumberOrder() {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_NUMBER_ORDER);
		return getElementText(driver, UserCheckoutPageUI.TXT_NUMBER_ORDER);
	}

	public void selectDropdownByID(String valueLocator, String creditCardType) {
		waitForElementClickable(driver, UserCheckoutPageUI.DROP_DOWN_BY_ID, valueLocator);
		selectItemInDefaultDropdown(driver, UserCheckoutPageUI.DROP_DOWN_BY_ID, creditCardType, valueLocator);
	}

	public void inputTxtboxByID(String valueLocator, String cardholderName) {
		waitForElementVisible(driver, UserCheckoutPageUI.TXT_BOX_BY_ID, valueLocator);
		sendKeyToElement(driver, UserCheckoutPageUI.TXT_BOX_BY_ID, cardholderName, valueLocator);
	}

	public UserHomePageObject clickToContinueBtnAtCheckoutCompleted() {
		waitForElementClickable(driver, UserCheckoutPageUI.CONTINUE_BTN_AT_CHECKOUT_COMPLETED);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BTN_AT_CHECKOUT_COMPLETED);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
