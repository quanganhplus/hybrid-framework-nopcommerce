package factoryEnvironment;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import commons.GlobalConstants;
import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
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
			options.addPreference("browser.download.dir", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
			options.addPreference("browser.download.useDownloadDir", true);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk",
					"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html, text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
			options.addPreference("pdfjs.disabled", true);

			// chạy ẩn danh
			// options.addArguments("-private");

			driver = new FirefoxDriver(options);

		} else if (browserList == BrowserList.HEADLESS_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		} else if (browserList == BrowserList.CHROME) {
			// System.setProperty("webdriver.chrome.driver", projectPath + ".//browserDrivers//chromedriver.exe");
			WebDriverManager.chromedriver().setup();

			// bỏ log console ở selenium khi chạy chrome
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");

			// Add extension to Chrome
			File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\extension_2_0_12_0.crx");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(file);

			// fake ip bằng UltaSurf-VPN
			// options.addExtensions(new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\UltraSurf-VPN-v1.7.1.crx"));
			// fix accept SSL
			options.setAcceptInsecureCerts(true);

			// Disable notifications popup
			options.addArguments("--disable-notifications");

			// Disable location popup
			options.addArguments("--disable-geolocation");

			// Set browser language = Vietnamese
			options.addArguments("--lang=vi");

			// Automation hide Info Bar
			// options.setExperimentalOption("useAutomationExtension", false);
			// options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

			// Setting có hỏi lưu password ko ?
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			// Lưu file vào folder downloadFiles
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", GlobalConstants.PROJECT_PATH + "\\downloadFiles");

			options.setExperimentalOption("prefs", prefs);

			// chạy ẩn danh
			// options.addArguments("--incognito");

			driver = new ChromeDriver(options);

		} else if (browserList == BrowserList.HEADLESS_CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browserList == BrowserList.EDGE) {
			// System.setProperty("webdriver.edge.driver", projectPath + ".//browserDrivers//msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserList == BrowserList.SAFARI) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		} else if (browserList == BrowserList.COCCOC) {
			// Cốc cốc browser trừ đi 5-6 version ra chrome driver
			WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup();
			ChromeOptions options = new ChromeOptions();

			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary("...");
			}

			driver = new ChromeDriver(options);
		} else {
			throw new BrowserNotSupport(browserName);
		}

		return driver;
	}
}
