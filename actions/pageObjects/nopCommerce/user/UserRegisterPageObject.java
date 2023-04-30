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

	public String getErrorMessageFstName(String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
	}

	public String getErrorMessageLstName(String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
	}

	public String getErrorMessageEmail(String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
	}

	public String getErrorMessagePassword(String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
	}

	public String getErrorMessageConfirmPassword(String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
		return getElementText(driver, UserRegisterPageUI.ERROR_MASSAGE_AT_REGISTER, valueLocator);
	}

	public void inputToFstNameTxtbox(String fstName, String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, valueLocator);
		sendKeyToElement(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, fstName, valueLocator);
	}

	public void inputToLstNameTxtbox(String lstName,String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, valueLocator);
		sendKeyToElement(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, lstName, valueLocator);
	}

	public void inputToEmailTxtbox(String emailAdd, String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, valueLocator);
		sendKeyToElement(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, emailAdd, valueLocator);
	}

	public void inputToPasswordTxtbox(String password,String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, valueLocator);
		sendKeyToElement(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, password, valueLocator);
	}

	public void inputToConfirmPasswordTxtbox(String confirmPassword,String valueLocator) {
		waitForElementVisible(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, valueLocator);
		sendKeyToElement(driver, UserRegisterPageUI.TXT_BOX_AT_REGISTER, confirmPassword, valueLocator);
	}

	public String existMessageEmail() {
		waitForElementVisible(driver, UserRegisterPageUI.EXIST_MESSAGE_EMAIL);
		return getElementText(driver, UserRegisterPageUI.EXIST_MESSAGE_EMAIL);
	}

	public void RegisterAsUser(String fstName, String lstName, String existEmail, String password,
			String confirmPassword) {
		inputToFstNameTxtbox(fstName,"FirstName");
		inputToLstNameTxtbox(lstName,"LastName");
		inputToEmailTxtbox(existEmail,"Email");
		inputToPasswordTxtbox(password,"Password");
		inputToConfirmPasswordTxtbox(confirmPassword,"ConfirmPassword");
		clickToRegisterBtn();
	}
}
