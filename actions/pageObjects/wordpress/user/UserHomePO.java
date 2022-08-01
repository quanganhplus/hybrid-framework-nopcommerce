package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInfoDisplayed(String postTitle) {

		return false;
	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {

		return null;
	}
}
