package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInforPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderRadioBtn(String valueGender) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.CHOOSE_GENDER, valueGender);
		clickToElementByJS(driver, UserCustomerInfoPageUI.CHOOSE_GENDER, valueGender);
	}

	public void inputToFstNameTxtBox(String fstName, String valueLocator) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, valueLocator);
		sendKeyToElement(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, fstName, valueLocator);
	}

	public void inputToLstNameTxtBox(String lstName, String valueLocator) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, valueLocator);
		sendKeyToElement(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, lstName, valueLocator);
	}

	public void selectDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
		waitForElementClickable(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_IN_CUSTOMER_INFO_PAGE, "Day");
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_IN_CUSTOMER_INFO_PAGE, dayOfBirth,
				"Day");

		waitForElementClickable(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_IN_CUSTOMER_INFO_PAGE, "Month");
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_IN_CUSTOMER_INFO_PAGE, monthOfBirth,
				"Month");

		waitForElementClickable(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_IN_CUSTOMER_INFO_PAGE, "Year");
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_IN_CUSTOMER_INFO_PAGE, yearOfBirth,
				"Year");
	}

	public void inputToEmailTxtBox(String editedEmail, String valueLocator) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, valueLocator);
		sendKeyToElement(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, editedEmail, valueLocator);
	}

	public void inputToCompanyTxtBox(String companyName, String valueLocator) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, valueLocator);
		sendKeyToElement(driver, UserCustomerInfoPageUI.TXTBOX_IN_CUSTOMER_INFO_PAGE, companyName, valueLocator);
	}

	public UserCustomerInforPageObject clickToSaveBtn() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BTN);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BTN);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public String getTxtNotificationUpdatedSuccessfully() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.NOTIFICATION_UPDATED_SUCCESS);
		return getElementText(driver, UserCustomerInfoPageUI.NOTIFICATION_UPDATED_SUCCESS);
	}

	
}
