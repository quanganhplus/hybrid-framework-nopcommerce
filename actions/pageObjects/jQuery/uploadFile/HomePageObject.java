package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUpLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public void clickToStartButton() {
		// Uploading
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement start : startButtons) {
			start.click();
			sleepInSecond(2);
		}

	}

	public boolean isFileImageUpLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

}
