package factoryBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		// System.setProperty("webdriver.gecko.driver", projectPath + ".//browserDrivers//geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();

		// bỏ log console ở selenium khi chạy firefox
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "\\browserLogs\\FirefoxLog.log");

		// Add extension to Firefox
		// Lưu ý nếu chạy wordpress dưới local, qua xampp thì khi chạy comment lại đoạn code Add extension vào để chạy ko lỗi (web chưa public k add đc extentions)
		FirefoxProfile profile = new FirefoxProfile();
		File translate = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\to_google_translate-4.2.0.xpi");
		profile.addExtension(translate);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);

		// Disable notifications popup
		options.addArguments("--disable-notifications");

		// Disable location popup
		options.addArguments("--disable-geolocation");

		// Lưu file vào folder downloadFiles
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_FILE);
		options.addPreference("browser.download.useDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html, text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
		options.addPreference("pdfjs.disabled", true);

		// chạy ẩn danh
		// options.addArguments("-private");

		return new FirefoxDriver(options);
	}

}
