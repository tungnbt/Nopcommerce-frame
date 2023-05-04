package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserInputeReviewProductPageObject clickToAddYourReviewLink() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getUserInputeReviewProductPage(driver);
	}

	public void clickToOverviewBtn(String valueLocator) {
		waitForElementClickable(driver, UserProductDetailPageUI.OVERVIEW_BTN, valueLocator);
		clickToElement(driver, UserProductDetailPageUI.OVERVIEW_BTN, valueLocator);
	}

	public String getTxtMessageAddedToWhislist() {
		waitForAllElementsVisible(driver, UserProductDetailPageUI.Message_ADDED_TO_WISHLIST);
		return getElementText(driver, UserProductDetailPageUI.Message_ADDED_TO_WISHLIST);
	}

	public UserWishlistPageObject openWishlistPageAtMessage() {
		waitForAllElementsVisible(driver, UserProductDetailPageUI.WISHLIST_LINK_AT_MESSAGE);
		clickToElement(driver, UserProductDetailPageUI.WISHLIST_LINK_AT_MESSAGE);
		return PageGeneratorManager.getUserWishlistPage(driver);
	}

	public void selectDropDownByLabel(String string, String valueItem) {
		waitForElementClickable(driver, UserProductDetailPageUI.DROP_DOWN_BY_LABEL, string);
		selectItemInDefaultDropdown(driver, UserProductDetailPageUI.DROP_DOWN_BY_LABEL, valueItem, string);
	}

	public void selectRadioBtnAndChkboxBylabel(String string, String valueItem) {
		waitForElementClickable(driver, UserProductDetailPageUI.RADIO_BTN_AND_CHKBOX_BY_LABEL, string, valueItem);
		clickToElement(driver, UserProductDetailPageUI.RADIO_BTN_AND_CHKBOX_BY_LABEL, string, valueItem);
	}

	public String getTxtCurrentProductPrice() {
		waitForElementVisible(driver, UserProductDetailPageUI.CURRENT_RODUCT_PRICE);
		return getElementText(driver, UserProductDetailPageUI.CURRENT_RODUCT_PRICE);
	}

	public void inputToQuantityTxtbox(String string) {
		waitForElementVisible(driver, UserProductDetailPageUI.QTY_TXT_BOX);
		sendKeyToElement(driver, UserProductDetailPageUI.QTY_TXT_BOX, string);
	}

	public UserShoppingCartPageObject clickToAddToCartBtn() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_CART_BTN);
		clickToElement(driver, UserProductDetailPageUI.ADD_TO_CART_BTN);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public String getTxtMessageAddedToCart() {
		waitForElementVisible(driver, UserProductDetailPageUI.MESSAGE_ADDED_TO_CART);
		return getElementText(driver, UserProductDetailPageUI.MESSAGE_ADDED_TO_CART);
	}

	public UserShoppingCartPageObject openShoppingCartPageAtMessage() {
		waitForElementClickable(driver, UserProductDetailPageUI.SHOPPING_CART_LINK);
		clickToElement(driver, UserProductDetailPageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

}
