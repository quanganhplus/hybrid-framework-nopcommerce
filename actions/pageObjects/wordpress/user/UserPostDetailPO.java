package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserPostDetailPO extends BasePage {
	WebDriver driver;

	public UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}
}
