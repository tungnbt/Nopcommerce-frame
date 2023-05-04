package pageUIs.nopCommerce.user;

public class UserCheckoutPageUI {

	public static final String TXT_INFO_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::tr//label[contains(text(),'%s')]/following-sibling::span";
	public static final String TXT_TOTAL_BY_LABEL_NAME = "//label[contains(text(),'%s')]/ancestor::tr//%s";
	public static final String TXT_SHIPPING_METHOD = "//label[contains(text(),'Shipping')]/following-sibling::span";
	public static final String TXT_ORDER_SUCCESSFULLY = "//div[contains(@class,'order-completed-page')]";
	public static final String CONTINUE_BTN_BY_STEP_NAME = "//button[contains(@class,'%s-continue-button')]";
	public static final String PAYMENT_METHOD_RADIO_BTN = "//label[text()='%s']/preceding-sibling::input";

}
