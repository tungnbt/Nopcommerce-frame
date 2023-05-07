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

	public void selectDropDownByLabel(String valueLocator, String valueItem) {
		waitForElementClickable(driver, UserProductDetailPageUI.DROP_DOWN_BY_LABEL, valueLocator);
		selectItemInDefaultDropdown(driver, UserProductDetailPageUI.DROP_DOWN_BY_LABEL, valueItem, valueLocator);
	}

	public void selectRadioBtnAndChkboxBylabel(String valueLocator, String valueItem) {
		waitForElementClickable(driver, UserProductDetailPageUI.RADIO_BTN_AND_CHKBOX_BY_LABEL, valueLocator, valueItem);
		clickToElement(driver, UserProductDetailPageUI.RADIO_BTN_AND_CHKBOX_BY_LABEL, valueLocator, valueItem);
	}

	public String getTxtCurrentProductPrice() {
		waitForElementVisible(driver, UserProductDetailPageUI.CURRENT_RODUCT_PRICE);
		return getElementText(driver, UserProductDetailPageUI.CURRENT_RODUCT_PRICE);
	}

	public void inputToQuantityTxtbox(String txtValue) {
		waitForElementVisible(driver, UserProductDetailPageUI.QTY_TXT_BOX);
		sendKeyToElement(driver, UserProductDetailPageUI.QTY_TXT_BOX, txtValue);
	}

	public void clickToAddToCartBtn() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_CART_BTN);
		clickToElement(driver, UserProductDetailPageUI.ADD_TO_CART_BTN);
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
