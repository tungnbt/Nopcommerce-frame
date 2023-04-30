package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserInputeReviewProductPageUI;

public class UserInputeReviewProductPageObject extends BasePage {
	WebDriver driver;

	public UserInputeReviewProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToReviewTitle(String reviewTitle) {
		waitForElementVisible(driver, UserInputeReviewProductPageUI.REVIEW_TITLE_TXT_BOX);
		sendKeyToElement(driver, UserInputeReviewProductPageUI.REVIEW_TITLE_TXT_BOX, reviewTitle);
	}

	public void inputToReviewTxt(String reviewTxt) {
		waitForElementVisible(driver, UserInputeReviewProductPageUI.REVIEW_TXT_BOX);
		sendKeyToElement(driver, UserInputeReviewProductPageUI.REVIEW_TXT_BOX, reviewTxt);
	}

	public void clickToSubmitReviewBtn() {
		waitForElementClickable(driver, UserInputeReviewProductPageUI.SUBMIT_REVIEW_BTN);
		clickToElement(driver, UserInputeReviewProductPageUI.SUBMIT_REVIEW_BTN);
	}
}
