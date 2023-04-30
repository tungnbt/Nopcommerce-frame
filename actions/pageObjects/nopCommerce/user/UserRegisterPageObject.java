package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driverClassTest) {
		this.driver = driverClassTest;
	}

	public void clickToRegisterBtn() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BTN);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BTN);
	}

	public String getErrorMessageFstName() {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_FST_NAME);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_FST_NAME);
	}

	public String getErrorMessageLstName() {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_LST_NAME);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_LST_NAME);
	}

	public String getErrorMessageEmail() {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_EMAIL);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_EMAIL);
	}

	public String getErrorMessagePassword() {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_PASSWORD);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_PASSWORD);
	}

	public String getErrorMessageConfirmPassword() {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_CONFIRM_PASSWORD);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_CONFIRM_PASSWORD);
	}

	public void inputToFstNameTxtbox(String fstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FST_NAME_TXT_BOX);
		sendKeyToElement(driver, UserRegisterPageUI.FST_NAME_TXT_BOX, fstName);
	}

	public void inputToLstNameTxtbox(String lstName) {
		waitForElementVisible(driver, UserRegisterPageUI.LST_NAME_TXT_BOX);
		sendKeyToElement(driver, UserRegisterPageUI.LST_NAME_TXT_BOX, lstName);
	}

	public void inputToEmailTxtbox(String string) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TXT_BOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TXT_BOX, string);
	}

	public void inputToPasswordTxtbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TXT_BOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TXT_BOX, password);
	}

	public void inputToConfirmPasswordTxtbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TXT_BOX);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TXT_BOX, confirmPassword);
	}

	public String existMessageEmail() {
		waitForElementVisible(driver, UserRegisterPageUI.EXIST_MESSAGE_EMAIL);
		return getElementText(driver, UserRegisterPageUI.EXIST_MESSAGE_EMAIL);
	}
	
	public void RegisterAsUser(String fstName, String lstName, String existEmail, String password, String confirmPassword) {
		inputToFstNameTxtbox(fstName);
		inputToLstNameTxtbox(lstName);
		inputToEmailTxtbox(existEmail);
		inputToPasswordTxtbox(password);
		inputToConfirmPasswordTxtbox(confirmPassword);
		clickToRegisterBtn();
	}
}
