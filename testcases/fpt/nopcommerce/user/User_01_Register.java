package fpt.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".//browserDrivers//geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Emty_Data() {

	}

	@Test
	public void TC_02_Register_invalid_Email() {

	}

	@Test
	public void TC_03_Register_Success() {

	}

	@Test
	public void TC_04_Register_Existing_Email() {

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {

	}

	@AfterClass
	public void afterClass() {

	}

}
