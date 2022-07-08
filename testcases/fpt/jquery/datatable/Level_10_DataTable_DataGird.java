package fpt.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGird extends BaseTest {
	private WebDriver driver;

	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("13");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("13"));

		homePage.openPagingByPageNumber("6");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("6"));

		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("8"));

		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextBoxLabel("Country", "Argentina");
		homePage.enterToHeaderTextBoxLabel("Females", "338282");
		homePage.enterToHeaderTextBoxLabel("Males", "349238");
		homePage.enterToHeaderTextBoxLabel("Total", "687522");
		homePage.sleepInSecond(2);

		homePage.enterToHeaderTextBoxLabel("Country", "Angola");
		homePage.enterToHeaderTextBoxLabel("Females", "276880");
		homePage.enterToHeaderTextBoxLabel("Males", "276472");
		homePage.enterToHeaderTextBoxLabel("Total", "553353");
		homePage.sleepInSecond(2);
	}

	@Test
	public void Table_03_Enter_To_Header() {
		// Đọc dữ liệu của file country.txt
		// Lưu vào 1 List<String> = Expected Value = expectedAllCountryValues

		// Actual value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();

		// Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}