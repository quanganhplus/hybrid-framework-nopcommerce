package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
}