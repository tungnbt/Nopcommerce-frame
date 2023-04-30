package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage {
	WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddNewBtn() {
		waitForElementVisible(driver, UserAddressesPageUI.ADD_NEW_BTN);
		clickToElement(driver, UserAddressesPageUI.ADD_NEW_BTN);
	}

	public void inputToFstNameTxtBox(String addFstName, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addFstName, valueLocator);
	}

	public void inputToLstNameTxtBox(String addLstName, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addLstName, valueLocator);
	}

	public void inputToEmailTxtBox(String addEmail, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addEmail, valueLocator);
	}

	public void inputToCompanyTxtBox(String addCompany, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addCompany, valueLocator);
	}

	public void selectToCountryTxtBox(String addCountry) {
		waitForElementVisible(driver, UserAddressesPageUI.COUNTRY_SELECT_BOX);
		selectItemInDefaultDropdown(driver, UserAddressesPageUI.COUNTRY_SELECT_BOX, addCountry);
	}

	public void selectToCityTxtBox(String addCity, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addCity, valueLocator);
	}

	public void inputToAddress1TxtBox(String address1, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, address1, valueLocator);
	}

	public void inputToAddress2TxtBox(String address2, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, address2, valueLocator);
	}

	public void inputToZipCodeTxtBox(String addZipcode, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addZipcode, valueLocator);
	}

	public void inputToPhoneNumberTxtBox(String addPhonenumer, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addPhonenumer, valueLocator);
	}

	public void inputToFaxNumberTxtBox(String addFaxNumber, String valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, valueLocator);
		sendKeyToElement(driver, UserAddressesPageUI.TXT_BOX_IN_ADDRESSES_PAGE, addFaxNumber, valueLocator);
	}

	public void clickToSaveBtn() {
		waitForElementClickable(driver, UserAddressesPageUI.SAVE_BTN);
		clickToElement(driver, UserAddressesPageUI.SAVE_BTN);
	}

	public String getTxtFullName(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtEmail(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtCompany(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtCountry(String...valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver,UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS , valueLocator);
	}

	public String getTxtCity(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtAddress1(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtAddress2(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtZipcode(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtPhoneNumber(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}

	public String getTxtFaxNumber(String... valueLocator) {
		waitForElementVisible(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
		return getElementText(driver, UserAddressesPageUI.TXT_THAT_VERIFY_ADDRESS, valueLocator);
	}
}
