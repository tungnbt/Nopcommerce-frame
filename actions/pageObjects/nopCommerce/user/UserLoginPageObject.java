package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driverClassTest) {
		this.driver = driverClassTest;
	}

	public void inputToEmailTxtbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TXT_BOX);
		sendKeyToElement(driver,UserLoginPageUI.EMAIL_TXT_BOX ,email);
	}

	public void inputToPasswordTxtbox(String confirmPassword) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TXT_BOX);
		sendKeyToElement(driver,UserLoginPageUI.PASSWORD_TXT_BOX ,confirmPassword);
	}		

	public void clickToLoginBtn() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BTN);
		clickToElement(driver, UserLoginPageUI.LOGIN_BTN);
	}

	public String unsuccessfulMessage() {
		waitForElementVisible(driver, UserLoginPageUI.UNSUCESSFUL_MESSAGE);
		return getElementText(driver, UserLoginPageUI.UNSUCESSFUL_MESSAGE);
	}

	public String getErrorMessageEmail() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(driver, UserLoginPageUI.ERROR_MESSAGE_EMAIL);
	}

	public UserHomePageObject LoginAsUser(String email, String password) {
		inputToEmailTxtbox(email);
		inputToPasswordTxtbox(password);
		clickToLoginBtn();
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
}
