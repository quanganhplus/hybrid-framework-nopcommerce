package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_TITLE, postTitle);
	}

	public void enterToPostBody(String postBody) {
		// Click
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);

		// Sendkey
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX, postBody);
	}

	public void enterToEditBody(String editBody) {
		// Click
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX);

		// Sendkey
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX, editBody);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_MESSAGE, postPublishMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_MESSAGE, postPublishMessage);
	}

	public AdminPostSearchPO openSearchPosstPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
