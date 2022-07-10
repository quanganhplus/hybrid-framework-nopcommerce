package fpt.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;

	HomePageObject homePage;

	// Image Name: Verify
	String seleniumImage = "Selenium.jpg";
	String appiumImage = "Appium.png";
	String apiImage = "API.jpg";
	String bitcoinImage = "Bitcoin.jpg";

	String[] multipleFileNames = { seleniumImage, appiumImage, apiImage, bitcoinImage };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 01: Load single file
		homePage.uploadMultipleFiles(driver, seleniumImage);

		// Step 02: Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(seleniumImage));

		// Step 03: Click Start button
		homePage.clickToStartButton();

		// Step 04: Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(seleniumImage));

		// Step 05: Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(seleniumImage));
	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);

		// Step 01: Load multiple file
		homePage.uploadMultipleFiles(driver, multipleFileNames);

		// Step 02: Verify multiple file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(seleniumImage));
		Assert.assertTrue(homePage.isFileLoadedByName(appiumImage));
		Assert.assertTrue(homePage.isFileLoadedByName(apiImage));
		Assert.assertTrue(homePage.isFileLoadedByName(bitcoinImage));

		// Step 03: Click Start button
		homePage.clickToStartButton();

		// Step 04: Verify multiple file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(seleniumImage));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(appiumImage));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(apiImage));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(bitcoinImage));

		// Step 05: Verify multiple file image uploaded success
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(seleniumImage));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(appiumImage));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(apiImage));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(bitcoinImage));
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}