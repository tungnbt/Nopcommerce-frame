package pageUIs.nopCommerce.user;

public class UserAddressesPageUI {
	public static final String ADD_NEW_BTN = "//button[text()='Add new']";
	public static final String TXT_BOX_IN_ADDRESSES_PAGE ="//input[@name='Address." + "%s']";
	public static final String TXT_THAT_VERIFY_ADDRESS = "//strong[text()='%s']/ancestor::div[@class='address-list']//li[@class='%s']";
	public static final String SAVE_BTN = "//button[text()='Save']";
	public static final String COUNTRY_SELECT_BOX = "//select[@name='Address.CountryId']";
}
