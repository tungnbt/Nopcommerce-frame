package pageUIs.nopCommerce.user;

public class UserCheckoutPageUI {

	public static final String TXT_INFO_BY_PRODUCT_NAME = "//a[text()='%s']/ancestor::tr//label[contains(text(),'%s')]/following-sibling::span";
	public static final String TXT_TOTAL_BY_LABEL_NAME = "//label[contains(text(),'%s')]/ancestor::tr//%s";
	public static final String TXT_SHIPPING_METHOD = "//label[contains(text(),'Shipping')]/following-sibling::span";
	public static final String TXT_ORDER_SUCCESSFULLY = "//div[contains(@class,'order-completed-page')]";
	public static final String CONTINUE_BTN_BY_STEP_NAME = "//button[contains(@class,'%s-next-step-button')]";
	public static final String PAYMENT_METHOD_RADIO_BTN = "//label[text()='%s']/preceding-sibling::input";
	public static final String TXT_BOX_BY_LABEL = "//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DROP_DOWN_BY_LABEL = "//label[contains(text(),'%s')]/following-sibling::select";
	public static final String SHIPPING_METHOD_RADIO_BTN = "//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String SELECT_DROP_DOWN_BY_ID = "//div[@class='section payment-info']/div";
	public static final String ADDRESS_CONFIRM_ORDER = "//strong[text()='%s']/ancestor::div[@class='order-review-data']";
	public static final String TXT_PRODUCT_NAME_BY_PRODUCT_LABEL = "//td[@class='product']/a[text()='%s']";
	public static final String TXT_NUMBER_ORDER = "//div[@class='order-number']/strong";
	public static final String DROP_DOWN_BY_ID = "//select[@id='%s']";
	public static final String TXT_BOX_BY_ID = "//input[@id='%s']";
	public static final String CONTINUE_BTN_AT_CHECKOUT_COMPLETED = "//button[contains(@class,'order-completed-continue-button')]";

}
