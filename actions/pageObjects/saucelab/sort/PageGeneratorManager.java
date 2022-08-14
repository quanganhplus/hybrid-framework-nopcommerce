package pageObjects.saucelab.sort;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminProductsPO getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPO(driver);
	}

}
