package pageUIs.nopCommerce.user;

public class UserShoppingCartPageUI {

	public static final String INFO_PRODUCT_NAME = "//a[text()='%s']/parent::td";
	public static final String TOTAL_PRICE_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::tr//span[@class='product-subtotal']";
	public static final String REMOVE_BTN_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::tr//button[@class='remove-btn']";
	public static final String TXT_EMPTY_AT_SHOPPING_CART_PAGE = "//div[@class='no-data']";
	public static final String QTY_TXT_BOX_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::tr//input[@class='qty-input']";
	public static final String UPDATE_SHOPPING_CART_BTN = "//button[contains(@class,'update-cart-button')]";
	public static final String CHKBOX_THE_TERM_OF_SERVICE = "//div[@class='terms-of-service']/input";
	public static final String CHECK_OUT_BTN = "//button[contains(@class,'checkout-button')]";
	public static final String EDIT_BTN_BY_PRODUCT_NAME = "//a[text()='%s']/following-sibling::div[@class='edit-item']/a";

}
