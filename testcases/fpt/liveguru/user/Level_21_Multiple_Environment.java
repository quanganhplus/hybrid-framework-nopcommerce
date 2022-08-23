package fpt.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_21_Multiple_Environment extends BaseTest {
	WebDriver driver;

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		System.out.println(driver.getCurrentUrl());
	}

	@Test
	public void Employee_01_Add_New_Employee() {

	}

	@Test
	public void Employee_02_Upload_New_Avatar() {

	}

	@Test
	public void Employee_03_Personal_Details() {

	}

	@Test
	public void Employee_04_Contact_Details() {

	}

	@Test
	public void Employee_05_Emergency_Details() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
