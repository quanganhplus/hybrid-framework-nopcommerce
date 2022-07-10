package fpt.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

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

	// @Test
	public void Table_03_Enter_To_Header() {
		// Đọc dữ liệu của file country.txt
		// Lưu vào 1 List<String> = Expected Value = expectedAllCountryValues

		// Actual value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();

		// Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}

	@Test
	public void Table_04_Action_At_Any_Row() {
		homePage.clickDemoLoadData();
		homePage.sleepInSecond(2);

		// Value để nhập liệu
		// Cloum name: Album/ Artis/ Year
		// Row number : tại row nào
		// Ex: Nhập vào textbox tại dòng số 3 / 5 / 2
		homePage.enterToTextBoxByColumnNameAtRowNumber("Album", "1", "Michael 97");

		homePage.enterToTextBoxByColumnNameAtRowNumber("Artist", "1", "Michael Jackson");

		homePage.enterToTextBoxByColumnNameAtRowNumber("Year", "1", "1997");

		homePage.enterToTextBoxByColumnNameAtRowNumber("Price", "1", "200");

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "US");

		// BlackPink
		homePage.enterToTextBoxByColumnNameAtRowNumber("Album", "5", "Boombayah");

		homePage.enterToTextBoxByColumnNameAtRowNumber("Artist", "5", "BlackPink");

		homePage.enterToTextBoxByColumnNameAtRowNumber("Year", "5", "2022");

		homePage.enterToTextBoxByColumnNameAtRowNumber("Price", "5", "350");

		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "5", "Korea");

		// Checkbox or unCheckbox
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");

		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");

		// Remove button or Insert button or Up/Down button
		homePage.clickToButtonByRowNumber("1", "Remove Current Row");

		homePage.clickToButtonByRowNumber("1", "Insert Row Above");

		homePage.clickToButtonByRowNumber("1", "Move Up");

		homePage.clickToButtonByRowNumber("5", "Remove Current Row");
		homePage.clickToButtonByRowNumber("4", "Remove Current Row");
		homePage.clickToButtonByRowNumber("3", "Remove Current Row");
		homePage.clickToButtonByRowNumber("2", "Remove Current Row");
		homePage.clickToButtonByRowNumber("1", "Remove Current Row");

		homePage.sleepInSecond(3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}