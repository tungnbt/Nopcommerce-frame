package pageUIs.nopCommerce.user;

public class UserSearchPageUI {

	public static final String SEARCH_BTN = "//button[contains(@class,'search-button')]";
	public static final String ERROR_MESSAGE_PRODUCT_SEACHED_NOT_FOUND = "//div[@class='search-results']//div[@class='%s']";
	public static final String SEARCH_TXT_BOX = "//input[@class='search-text']";
	public static final String PRODUCT_TITLE = "//div[@class='item-box']//h2[@class='product-title']/a";
	public static final String ADVANCED_SEARCH_CHECK_BOX = "//label[text()='%s']/preceding-sibling::input";
	public static final String ADVANCED_SEARCH_DROP_DOWN = "//label[contains(text(),'%s')]/parent::div//select";
}