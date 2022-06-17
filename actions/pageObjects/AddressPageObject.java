package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;

public class AddressPageObject extends BasePage {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
}