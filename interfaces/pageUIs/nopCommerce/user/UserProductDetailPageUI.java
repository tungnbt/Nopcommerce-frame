package pageUIs.nopCommerce.user;

public class UserProductDetailPageUI {

	public static final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";
	public static final String OVERVIEW_BTN = "//div[@class='overview-buttons']//button[text()='%s']";
	public static final String Message_ADDED_TO_WISHLIST = "//div[@class='bar-notification success']/p";
	public static final String WISHLIST_LINK_AT_MESSAGE = "//div[@class='bar-notification success']/p/a";
	public static final String DROP_DOWN_BY_LABEL = "//label[contains(text(),'%s')]/parent::dt/following-sibling::dd[1]/select";
	public static final String RADIO_BTN_AND_CHKBOX_BY_LABEL = "//label[contains(text(),'%s')]/ancestor::div//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String CURRENT_RODUCT_PRICE = "//div[@class='product-price']/span";
	public static final String QTY_TXT_BOX = "//input[contains(@class,'qty-input')]";
	public static final String ADD_TO_CART_BTN = "//button[contains(@class,'add-to-cart-button')]";
	public static final String MESSAGE_ADDED_TO_CART = "//div[@class='bar-notification success']/p";
	public static final String SHOPPING_CART_LINK = "//div[@class='bar-notification success']//a";
	
}
