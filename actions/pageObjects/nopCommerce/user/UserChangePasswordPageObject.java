package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTxtbox(String password, String valueLocator) {
		waitForElementVisible(driver, UserChangePasswordPageUI.TXT_BOX_IN_CHANGE_PASSWORD_PAGE, valueLocator);
		sendKeyToElement(driver, UserChangePasswordPageUI.TXT_BOX_IN_CHANGE_PASSWORD_PAGE, password, valueLocator);
	}

	public void inputToNewPasswordTxtbox(String newPassword, String valueLocator) {
		waitForElementVisible(driver, UserChangePasswordPageUI.TXT_BOX_IN_CHANGE_PASSWORD_PAGE, valueLocator);
		sendKeyToElement(driver, UserChangePasswordPageUI.TXT_BOX_IN_CHANGE_PASSWORD_PAGE, newPassword, valueLocator);
	}

	public void inputToConfirmNewPasswordTxtbox(String confirmNewPassword, String valueLocator) {
		waitForElementVisible(driver, UserChangePasswordPageUI.TXT_BOX_IN_CHANGE_PASSWORD_PAGE, valueLocator);
		sendKeyToElement(driver, UserChangePasswordPageUI.TXT_BOX_IN_CHANGE_PASSWORD_PAGE, confirmNewPassword, valueLocator);
	}

	public void clickToChangePasswordBtn() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BTN);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BTN);
	}

	public boolean isMessageChangedPassSuccess() {
		waitForElementVisible(driver, UserChangePasswordPageUI.MESSAGE_CHANGE_PASSWORD_SUCCESS);
		return isElementDisplayed(driver, UserChangePasswordPageUI.MESSAGE_CHANGE_PASSWORD_SUCCESS);
	}
}
