package fpt.liveguru.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_21_Multiple_Environment extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

	}

	@Test
	public void User_01_Register() {

	}

	@Test
	public void User_02_Register() {

	}

	@Test
	public void User_03_Register() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
