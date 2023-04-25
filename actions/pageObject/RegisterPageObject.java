package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driverClassTest) {
		this.driver = driverClassTest;
	}

	public void clickToRegisterBtn() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BTN);
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}

	public String getErrorMessageFstName() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MASSAGE_FST_NAME);
		return getElementText(driver, RegisterPageUI.ERROR_MASSAGE_FST_NAME);
	}

	public String getErrorMessageLstName() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MASSAGE_LST_NAME);
		return getElementText(driver, RegisterPageUI.ERROR_MASSAGE_LST_NAME);
	}

	public String getErrorMessageEmail() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MASSAGE_EMAIL);
		return getElementText(driver, RegisterPageUI.ERROR_MASSAGE_EMAIL);
	}

	public String getErrorMessagePassword() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MASSAGE_PASSWORD);
		return getElementText(driver, RegisterPageUI.ERROR_MASSAGE_PASSWORD);
	}

	public String getErrorMessageConfirmPassword() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MASSAGE_CONFIRM_PASSWORD);
		return getElementText(driver, RegisterPageUI.ERROR_MASSAGE_CONFIRM_PASSWORD);
	}

	public void inputToFstNameTxtbox(String fstName) {
		waitForElementVisible(driver, RegisterPageUI.FST_NAME_TXT_BOX);
		senKeyToElement(driver, RegisterPageUI.FST_NAME_TXT_BOX, fstName);
	}

	public void inputToLstNameTxtbox(String lstName) {
		waitForElementVisible(driver, RegisterPageUI.LST_NAME_TXT_BOX);
		senKeyToElement(driver, RegisterPageUI.LST_NAME_TXT_BOX, lstName);
	}

	public void inputToEmailTxtbox(String string) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TXT_BOX);
		senKeyToElement(driver, RegisterPageUI.EMAIL_TXT_BOX, string);
	}

	public void inputToPasswordTxtbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TXT_BOX);
		senKeyToElement(driver, RegisterPageUI.PASSWORD_TXT_BOX, password);
	}

	public void inputToConfirmPasswordTxtbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TXT_BOX);
		senKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TXT_BOX, confirmPassword);
	}

	public String existMessageEmail() {
		waitForElementVisible(driver, RegisterPageUI.EXIST_MESSAGE_EMAIL);
		return getElementText(driver, RegisterPageUI.EXIST_MESSAGE_EMAIL);
	}
}
