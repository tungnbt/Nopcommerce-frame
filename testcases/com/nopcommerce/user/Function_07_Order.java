package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNoteBooksPageObject;
import pageObjects.nopCommerce.user.UserOrderInformationPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserProductDetailPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;

public class Function_07_Order extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		lstName = "man";
		fstName = "iron";
		password = "123456";
		confirmPassword = "123456";
		existEmail = "ironman" + getRandomNumber() + "@gmail.com.vn";
		productTitle1 = "Build your own computer";
		productTitle2 = "Lenovo IdeaCentre 600 All-in-One PC";
		productTitle3 = "Apple MacBook Pro 13-inch";
		addFstName = "Tony";
		addLstName = "Cruise";
		addFullName = addFstName + " " + addLstName;
		addCompany = "Tony Company";
		addCountry = "Viet Nam";
		addCity = "Ha Noi";
		address1 = "123/34 Le Duan";
		address2 = "123/21 Le Van Luong";
		addZipcode = "1000";
		addPhonenumer = "123456789";
		addFaxNumber = "098765543";
		roAddFstName = "John";
		roAddLstName = "Weak";
		roFullName = roAddFstName + " " + roAddLstName;
		creditCardType = "Visa";
		cardholderName = "John Weak";
		cardNumber = "4024007188102718";
		expireMonth = "08";
		expireYear = "2027";
		cardCode = "699";
		System.out.println("Pre-condition: Login success + open any product");
		registerPageObject = userHomePage.openRegisterPage();
		registerPageObject.RegisterAsUser(fstName, lstName, existEmail, password, confirmPassword);
		loginPageObject = userHomePage.openUserLoginPage();
		loginPageObject.LoginAsUser(existEmail, password);
		System.out.println("Login success");
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Desktops");
		userDesktopsPage = PageGeneratorManager.getUserDesktopsPage(driver);
		sleepInSecond(2);
		userProductDetailPage = userDesktopsPage.clickToTitleProductLink(productTitle1);
		System.out.println("Open any product");
	}

	@Test
	public void TCS_01_Add_product_to_Cart() {
		System.out.println("TCS_01_Add_product_to_Cart");
		userProductDetailPage.selectDropDownByLabel("Processor", processor2dot2Dropdown);
		userProductDetailPage.selectDropDownByLabel("RAM", ram2Dropdown);
		userProductDetailPage.selectRadioBtnAndChkboxBylabel("HDD", hdd320RadioBtn);
		userProductDetailPage.selectRadioBtnAndChkboxBylabel("OS", osPremiumRadioBtn);
		userProductDetailPage.selectRadioBtnAndChkboxBylabel("Software", softwareAcrobatChkbox);
		verifyEquals(userProductDetailPage.getTxtCurrentProductPrice(), "$1,320.00");
		userProductDetailPage.clickToAddToCartBtn();
		verifyEquals(userProductDetailPage.getTxtMessageAddedToCart(),
				"The product has been added to your shopping cart");
		userShoppingCartPage = userProductDetailPage.openShoppingCartPageAtMessage();
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(productTitle1));
		verifyTrue(
				userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(processor2dot2Dropdown));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(ram2Dropdown));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(hdd320RadioBtn));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(osPremiumRadioBtn));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(softwareAcrobatChkbox));
		verifyTrue(
				userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(softwareMicrosoftChkbox));
	}

	@Test
	public void TCS_02_Edit_product_in_Shopping_Cart() {
		System.out.println("TCS_02_Edit_product_in_Shopping_Cart");
		userProductDetailPage = userShoppingCartPage.clickToEditBtnByProductName();
		userProductDetailPage.selectDropDownByLabel("Processor", processor2dot5Dropdown);
		userProductDetailPage.selectDropDownByLabel("Ram", ram4Dropdown);
		userProductDetailPage.selectRadioBtnAndChkboxBylabel("HDD", hdd400RadioBtn);
		userProductDetailPage.selectRadioBtnAndChkboxBylabel("OS", osHomeRadioBtn);
		userProductDetailPage.selectRadioBtnAndChkboxBylabel("Software", softwareTotalChkbox);
		userProductDetailPage.inputToQuantityTxtbox("2");
		verifyEquals(userProductDetailPage.getTxtCurrentProductPrice(), "$1,450.00");
		userProductDetailPage.clickToAddToCartBtn();
		verifyEquals(userProductDetailPage.getTxtMessageAddedToCart(),
				"The product has been added to your shopping cart");
		userShoppingCartPage = userProductDetailPage.openShoppingCartPageAtMessage();
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(productTitle1));
		verifyTrue(
				userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(processor2dot5Dropdown));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(ram4Dropdown));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(hdd400RadioBtn));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(osHomeRadioBtn));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(softwareAcrobatChkbox));
		verifyTrue(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(softwareTotalChkbox));
		verifyTrue(
				userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(softwareMicrosoftChkbox));
		verifyEquals(userShoppingCartPage.getTxtTotalPriceByProductName(), "$2,900.00");
	}

	@Test
	public void TCS_03_Remove_from_Cart() {
		System.out.println("TCS_03_Remove_from_Cart");
		userShoppingCartPage.clickToRemoveBtnByProductName(productTitle1);
		verifyTrue(userShoppingCartPage.getTxtEmptyAtShoppingCartPage().contains("\nYour Shopping Cart is empty!\n"));
		verifyFalse(userShoppingCartPage.getInfoProductNameByProductName(productTitle1).contains(productTitle1));
	}

	@Test
	public void TCS_04_Edit_product_in_Shopping_Cart() {
		System.out.println("TCS_02_Edit_product_in_Shopping_Cart");
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Desktops");
		userDesktopsPage = PageGeneratorManager.getUserDesktopsPage(driver);
		userProductDetailPage = userDesktopsPage.clickToTitleProductLink(productTitle2);
		userShoppingCartPage = userProductDetailPage.clickToAddToCartBtn();
		userShoppingCartPage.inputToQtyTxtboxByProductName("5");
		userShoppingCartPage.clickToUpdateShoppingCart();
		verifyEquals(userShoppingCartPage.getTxtTotalPriceByProductName(), "$2,500.00");
	}

	@Test
	public void TCS_05_Checkout_Order_Payment_method_by_Cheque() {
		System.out.println("TCS_05_Checkout_Order_Payment_method_by_Cheque");
		userShoppingCartPage.clickToRemoveBtnByProductName(productTitle2);
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userProductDetailPage = userNoteBooksPage.clickToTitleProductLink(productTitle3);
		userProductDetailPage.clickToAddToCartBtn();
		userShoppingCartPage = userProductDetailPage.openShoppingCartPageAtMessage();
		userShoppingCartPage.clickToChkboxTheTermOfService();
		userCheckoutPage = userShoppingCartPage.openUserCheckoutPage();
		userCheckoutPage.inputToTxtboxByLabel("First name", addFstName);
		userCheckoutPage.inputToTxtboxByLabel("Last name", addLstName);
		userCheckoutPage.inputToTxtboxByLabel("Email", addEmail);
		userCheckoutPage.inputToTxtboxByLabel("Company", addCompany);
		userCheckoutPage.selectToDropDownByLabel("Country", addCountry);
		userCheckoutPage.inputToTxtboxByLabel("City", addCity);
		userCheckoutPage.inputToTxtboxByLabel("Address 1", address1);
		userCheckoutPage.inputToTxtboxByLabel("Address 2", address2);
		userCheckoutPage.inputToTxtboxByLabel("Zip / postal code", addZipcode);
		userCheckoutPage.inputToTxtboxByLabel("Phone number", addPhonenumer);
		userCheckoutPage.inputToTxtboxByLabel("Fax number", addFaxNumber);
		userCheckoutPage.clickToContinueBtnByStepName("new-address");

		userCheckoutPage.clickToShippingMethodRadioBtn("Ground");
		userCheckoutPage.clickToContinueBtnByStepName("shipping-method");

		userCheckoutPage.clickToPaymentMethodRadioBtn("Check / Money Order");
		userCheckoutPage.clickToContinueBtnByStepName("payment-method");

		verifyTrue(userCheckoutPage.isPaymentInfoUndisplayed());
		userCheckoutPage.clickToContinueBtnByStepName("payment-info");

		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addFullName));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addEmail));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addPhonenumer));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(address1));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(address2));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addCountry));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addCity));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addZipcode));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addFaxNumber));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Payment").contains("Check / Money Order"));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addFullName));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addEmail));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addPhonenumer));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(address1));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(address2));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addCountry));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addCity));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addZipcode));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addFaxNumber));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping").contains("Ground"));
		verifyEquals(userCheckoutPage.getTxtProductNameByProductLabel(productTitle3), productTitle3);
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Price"), "$1,800.00");
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Qty"), "$1,800.00");
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Total"), "$3,600.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Sub-Total", "span"), "$3,600.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Shipping", "span"), "$0.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Tax", "span"), "$0.00");
		verifyEquals(userCheckoutPage.getTxtShippingMethod(), "Ground");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Total", "strong"), "$3,600.00");
		userCheckoutPage.clickToContinueBtnByStepName("confirm-order");

		verifyTrue(userCheckoutPage.getTxtOrderSuccessfully().contains("Thank you"));
		verifyTrue(userCheckoutPage.getTxtOrderSuccessfully().contains("Your order has been successfully processed!"));
		String orderNumber = userCheckoutPage.getTxtNumberOrder();
		userHomePage = userCheckoutPage.clickToContinueBtnByStepName("order-completed");
		sleepInSecond(2);
		userCustomerInforPage = userHomePage.clickToMyAccountLink();
		userCustomerInforPage.openPageAtMyAccountPageName(driver, "Orders");
		userOrdersPage = PageGeneratorManager.getUserOrdersPage(driver);
		verifyEquals(userOrdersPage.getTxtOrderNumber("orderNumber"), orderNumber);
	}

	@Test
	public void TCS_06_Checkout_Order_Payment_method_by_Card() {
		System.out.println("TCS_06_Checkout_Order_Payment_method_by_Card");
		userShoppingCartPage.clickToRemoveBtnByProductName(productTitle2);
		userHomePage.openSubMenuPageAtHeaderMenu("Computers", "Notebooks");
		userNoteBooksPage = PageGeneratorManager.getUserNoteBooksPage(driver);
		userProductDetailPage = userNoteBooksPage.clickToTitleProductLink(productTitle3);
		userProductDetailPage.clickToAddToCartBtn();
		userShoppingCartPage = userProductDetailPage.openShoppingCartPageAtMessage();
		userShoppingCartPage.clickToChkboxTheTermOfService();
		userCheckoutPage = userShoppingCartPage.openUserCheckoutPage();
		userCheckoutPage.inputToTxtboxByLabel("First name", addFstName);
		userCheckoutPage.inputToTxtboxByLabel("Last name", addLstName);
		userCheckoutPage.inputToTxtboxByLabel("Email", addEmail);
		userCheckoutPage.inputToTxtboxByLabel("Company", addCompany);
		userCheckoutPage.selectToDropDownByLabel("Country", addCountry);
		userCheckoutPage.inputToTxtboxByLabel("City", addCity);
		userCheckoutPage.inputToTxtboxByLabel("Address 1", address1);
		userCheckoutPage.inputToTxtboxByLabel("Address 2", address2);
		userCheckoutPage.inputToTxtboxByLabel("Zip / postal code", addZipcode);
		userCheckoutPage.inputToTxtboxByLabel("Phone number", addPhonenumer);
		userCheckoutPage.inputToTxtboxByLabel("Fax number", addFaxNumber);
		userCheckoutPage.clickToContinueBtnByStepName("new-address");

		userCheckoutPage.clickToShippingMethodRadioBtn("Next Day Air");
		userCheckoutPage.clickToContinueBtnByStepName("shipping-method");

		userCheckoutPage.clickToPaymentMethodRadioBtn("Credit Card");
		userCheckoutPage.clickToContinueBtnByStepName("payment-method");

		userCheckoutPage.selectDropdownByID("CreditCardType", creditCardType);
		userCheckoutPage.selectDropdownByID("ExpireMonth", expireMonth);
		userCheckoutPage.selectDropdownByID("ExpireYear", expireYear);
		userCheckoutPage.inputTxtboxByID("CardholderName", cardholderName);
		userCheckoutPage.inputTxtboxByID("CardCode", cardCode);
		userCheckoutPage.clickToContinueBtnByStepName("payment-info");

		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addFullName));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addEmail));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addPhonenumer));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(address1));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(address2));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addCountry));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addCity));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addZipcode));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addFaxNumber));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Payment").contains("Credit Card"));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addFullName));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addEmail));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addPhonenumer));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(address1));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(address2));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addCountry));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addCity));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addZipcode));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addFaxNumber));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping").contains("Next Day Air"));
		verifyEquals(userCheckoutPage.getTxtProductNameByProductLabel(productTitle3), productTitle3);
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Price"), "$1,800.00");
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Qty"), "$1,800.00");
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Total"), "$3,600.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Sub-Total", "span"), "$3,600.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Shipping", "span"), "$0.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Tax", "span"), "$0.00");
		verifyTrue(userCheckoutPage.getTxtShippingMethod().contains("Next Day Air"));
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Total", "strong"), "$3,600.00");
		userCheckoutPage.clickToContinueBtnByStepName("confirm-order");

		verifyTrue(userCheckoutPage.getTxtOrderSuccessfully().contains("Thank you"));
		verifyTrue(userCheckoutPage.getTxtOrderSuccessfully().contains("Your order has been successfully processed!"));
		String orderNumber2 = userCheckoutPage.getTxtNumberOrder();
		userHomePage = userCheckoutPage.clickToContinueBtnByStepName("order-completed");
		sleepInSecond(2);
		userCustomerInforPage = userHomePage.clickToMyAccountLink();
		userCustomerInforPage.openPageAtMyAccountPageName(driver, "Orders");
		userOrdersPage = PageGeneratorManager.getUserOrdersPage(driver);
		verifyEquals(userOrdersPage.getTxtOrderNumber("orderNumber"), orderNumber2);
		userOrderInformationPage = userOrdersPage.clickToDetailsBtnByOrderNumber(orderNumber2);
	}

	@Test
	public void TCS_07_Re_Order() {
		System.out.println("TCS_07_Re_Order");
		userShoppingCartPage = userOrderInformationPage.clickToReOrderBtn();
		userShoppingCartPage.inputToQtyTxtboxByProductName("10");
		userShoppingCartPage.clickToUpdateShoppingCartBtn();
		userShoppingCartPage.clickToChkboxTheTermOfService();
		userCheckoutPage = userShoppingCartPage.openUserCheckoutPage();
		userCheckoutPage.inputToTxtboxByLabel("First name", roAddFstName);
		userCheckoutPage.inputToTxtboxByLabel("Last name", roAddLstName);
		userCheckoutPage.inputToTxtboxByLabel("Email", addEmail);
		userCheckoutPage.inputToTxtboxByLabel("Company", addCompany);
		userCheckoutPage.selectToDropDownByLabel("Country", addCountry);
		userCheckoutPage.inputToTxtboxByLabel("City", addCity);
		userCheckoutPage.inputToTxtboxByLabel("Address 1", address1);
		userCheckoutPage.inputToTxtboxByLabel("Address 2", address2);
		userCheckoutPage.inputToTxtboxByLabel("Zip / postal code", addZipcode);
		userCheckoutPage.inputToTxtboxByLabel("Phone number", addPhonenumer);
		userCheckoutPage.inputToTxtboxByLabel("Fax number", addFaxNumber);
		userCheckoutPage.clickToContinueBtnByStepName("new-address");

		userCheckoutPage.clickToShippingMethodRadioBtn("Next Day Air");
		userCheckoutPage.clickToContinueBtnByStepName("shipping-method");

		userCheckoutPage.clickToPaymentMethodRadioBtn("Credit Card");
		userCheckoutPage.clickToContinueBtnByStepName("payment-method");

		userCheckoutPage.selectDropdownByID("CreditCardType", creditCardType);
		userCheckoutPage.selectDropdownByID("ExpireMonth", expireMonth);
		userCheckoutPage.selectDropdownByID("ExpireYear", expireYear);
		userCheckoutPage.inputTxtboxByID("CardholderName", cardholderName);
		userCheckoutPage.inputTxtboxByID("CardCode", cardCode);
		userCheckoutPage.clickToContinueBtnByStepName("payment-info");

		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(roFullName));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addEmail));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addPhonenumer));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(address1));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(address2));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addCountry));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addCity));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addZipcode));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Billing Address").contains(addFaxNumber));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Payment").contains("Credit Card"));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addFullName));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addEmail));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addPhonenumer));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(address1));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(address2));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addCountry));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addCity));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addZipcode));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping Address").contains(addFaxNumber));
		verifyTrue(userCheckoutPage.getTxtAddressConfirmOrder("Shipping").contains("Next Day Air"));
		verifyEquals(userCheckoutPage.getTxtProductNameByProductLabel(productTitle3), productTitle3);
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Price"), "$1,800.00");
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Qty"), "$1,800.00");
		verifyEquals(userCheckoutPage.getTxtInfoByProductName(productTitle3, "Total"), "$3,600.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Sub-Total", "span"), "$3,600.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Shipping", "span"), "$0.00");
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Tax", "span"), "$0.00");
		verifyTrue(userCheckoutPage.getTxtShippingMethod().contains("Next Day Air"));
		verifyEquals(userCheckoutPage.getTxtTotlaByLabelName("Total", "strong"), "$3,600.00");
		userCheckoutPage.clickToContinueBtnByStepName("confirm-order");

		verifyTrue(userCheckoutPage.getTxtOrderSuccessfully().contains("Thank you")); // div[contains(@class,'order-completed-page')]
		verifyTrue(userCheckoutPage.getTxtOrderSuccessfully().contains("Your order has been successfully processed!"));
		String orderNumber3 = userCheckoutPage.getTxtNumberOrder();
		userHomePage = userCheckoutPage.clickToContinueBtnByStepName("order-completed"); // button[contains(@class,'%s-continue-button')]
		sleepInSecond(2);
		userCustomerInforPage = userHomePage.clickToMyAccountLink();
		userCustomerInforPage.openPageAtMyAccountPageName(driver, "Orders");
		userOrdersPage = PageGeneratorManager.getUserOrdersPage(driver);
		verifyEquals(userOrdersPage.getTxtOrderNumber("orderNumber"), orderNumber3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private UserHomePageObject userHomePage;
	private UserLoginPageObject loginPageObject;
	private UserRegisterPageObject registerPageObject;
	private UserProductDetailPageObject userProductDetailPage;
	private UserNoteBooksPageObject userNoteBooksPage;
	private UserShoppingCartPageObject userShoppingCartPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private UserDesktopsPageObject userDesktopsPage;
	private UserCheckoutPageObject userCheckoutPage;
	private UserOrdersPageObject userOrdersPage;
	private UserOrderInformationPageObject userOrderInformationPage;

	private WebDriver driver;
	private String lstName, fstName, password, confirmPassword, existEmail;
	private String productTitle1, productTitle2, productTitle3, processor2dot2Dropdown, processor2dot5Dropdown,
			ram2Dropdown, ram4Dropdown, hdd320RadioBtn, hdd400RadioBtn, osHomeRadioBtn, osPremiumRadioBtn,
			softwareMicrosoftChkbox, softwareTotalChkbox, softwareAcrobatChkbox;
	private String addFstName, addLstName, addEmail, addCompany, addCountry, addCity, address1, address2, addZipcode,
			addPhonenumer, addFaxNumber, addFullName;
	private String creditCardType, cardholderName, cardNumber, expireMonth, expireYear, cardCode;
	private String roAddFstName, roAddLstName, roFullName;
}
