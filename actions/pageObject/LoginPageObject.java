package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driverClassTest) {
		this.driver = driverClassTest;
	}

	public void inputToEmailTxtbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TXT_BOX);
		senKeyToElement(driver,LoginPageUI.EMAIL_TXT_BOX ,email);
	}

	public void inputToPasswordTxtbox(String confirmPassword) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT_BOX);
		senKeyToElement(driver,LoginPageUI.PASSWORD_TXT_BOX ,confirmPassword);
	}		

	public void clickToLoginBtn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}

	public String unsuccessfulMessage() {
		waitForElementVisible(driver, LoginPageUI.UNSUCESSFUL_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCESSFUL_MESSAGE);
	}

	public String getErrorMessageEmail() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_EMAIL);
	}

}
