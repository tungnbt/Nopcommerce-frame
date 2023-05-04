package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage{
	WebDriver driver;
	
	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTxtNameProductByWishlistTableTitle(String valueLocator) {
		waitForElementVisible(driver, UserWishlistPageUI.NAME_PRODUCT_BY_WISHLIST_TABLE_TITLE, valueLocator);
		return getElementText(driver, UserWishlistPageUI.NAME_PRODUCT_BY_WISHLIST_TABLE_TITLE, valueLocator);
	}

	public UserWishlistPageObject clickToYourWishlistURLForSharing() {
		waitForElementClickable(driver, UserWishlistPageUI.YOUR_WISHLIST_LINK);
		clickToElement(driver, UserWishlistPageUI.YOUR_WISHLIST_LINK);
		return PageGeneratorManager.getUserWishlistPage(driver);
	}

	public String getTxtWishlistPageTitle() {
		waitForElementVisible(driver,UserWishlistPageUI.WISHLIST_TITLE);
		return getElementText(driver, UserWishlistPageUI.WISHLIST_TITLE);
	}

	public void clickToCheckBoxByProductName(String valueLocator) {
		waitForElementClickable(driver, UserWishlistPageUI.CHECKBOX_BY_PRODUCT_NAME, valueLocator);
		clickToElement(driver, UserWishlistPageUI.CHECKBOX_BY_PRODUCT_NAME, valueLocator);
	}

	public UserShoppingCartPageObject clickToAddToCartBtn() {
		waitForElementClickable(driver, UserWishlistPageUI.ADD_TO_CART_BTN);
		clickToElementByJS(driver, UserWishlistPageUI.ADD_TO_CART_BTN);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public boolean isProductUndisplayed(String valueLocator) {
		return isElementUndisplayed(driver, UserWishlistPageUI.NAME_PRODUCT_BY_WISHLIST_TABLE_TITLE, valueLocator);
	}

	public void clickToRemoveProductByWishlistTableTitle(String valueLocator) {
		waitForElementClickable(driver, UserWishlistPageUI.REMOVE_BTN_BY_PRODUCT_NAME, valueLocator);
		clickToElementByJS(driver, UserWishlistPageUI.REMOVE_BTN_BY_PRODUCT_NAME, valueLocator);
	}

	public String getTxtMessageEmpty() {
		waitForElementVisible(driver, UserWishlistPageUI.MESSAGE_EMPTY);
		return getElementText(driver, UserWishlistPageUI.MESSAGE_EMPTY);
	}
}
