package pageUIs.nopCommerce.user;

public class UserCompareProductListPageUI {

	public static final String PAGE_TITLE = "//div[@class='page-title']/h1";
	public static final String CLEAR_LIST_BTN = "//div[@class='page-body']/a[text()='Clear list']";
	public static final String REMOVE_BTN_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::tbody//button[contains(@class,'remove-button')]";
	public static final String LABEL_AT_COMPARE_PAGE = "//label[text()='%s']";
	public static final String INFO_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::tbody//td[text()='%s']";
	public static final String MESSAGE_CLEARED_LIST = "//div[@class='no-data']";
	
}
