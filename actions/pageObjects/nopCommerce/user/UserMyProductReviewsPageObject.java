package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserMyProductReviewsPageUI;

public class UserMyProductReviewsPageObject extends BasePage{
	WebDriver driver;
	
	public UserMyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTxtReviewTitle() {
		waitForAllElementsVisible(driver, UserMyProductReviewsPageUI.TITLE_REVIEW_TXT);
		return getElementText(driver, UserMyProductReviewsPageUI.TITLE_REVIEW_TXT);
	}

	public String getTxtReview() {
		waitForAllElementsVisible(driver, UserMyProductReviewsPageUI.REVIEW_TXT);
		return getElementText(driver, UserMyProductReviewsPageUI.REVIEW_TXT);
	}
	
	public String getTxtNameProductReview() {
		waitForAllElementsVisible(driver, UserMyProductReviewsPageUI.NAME_PRODUCT_REVIEWED);
		return getElementText(driver, UserMyProductReviewsPageUI.NAME_PRODUCT_REVIEWED);
	}

}
