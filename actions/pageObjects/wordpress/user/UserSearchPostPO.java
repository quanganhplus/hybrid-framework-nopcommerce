package pageObjects.wordpress.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserSearchPostPO extends BasePage {
	WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
