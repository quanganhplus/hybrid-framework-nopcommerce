package fpt.bankguru.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import environmentConfig.Environment;

public class Level_21_Multiple_Environment extends BaseTest {
	WebDriver driver;
	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "browserVersion", "ipAddress", "port", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("105") String browserVersion, @Optional("localhost") String ipAddress, @Optional("4444") String port, @Optional("Windows") String osName,
			@Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, browserVersion, ipAddress, port, osName, osVersion);

		ConfigFactory.setProperty("env", serverName);
		environment = ConfigFactory.create(Environment.class);

		System.out.println(environment.osName());
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
		// closeBrowserAndDriver();
	}
}
