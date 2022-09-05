package factoryBrowser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		// System.setProperty("webdriver.chrome.driver", projectPath + ".//browserDrivers//chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		// bỏ log console ở selenium khi chạy chrome
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		// Add extension to Chrome
		// Lưu ý nếu chạy wordpress dưới local, qua xampp thì khi chạy comment lại đoạn code Add extension vào để chạy ko lỗi (web chưa public k add đc extentions)
		File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\extension_2_0_12_0.crx");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(file);

		// fake ip bằng UltaSurf-VPN
		// options.addExtensions(new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\UltraSurf-VPN-v1.7.1.crx"));

		// fix accept SSL
		options.setAcceptInsecureCerts(true);

		// Automation hide Info Bar
		// options.setExperimentalOption("useAutomationExtension", false);
		// options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		// Disable notifications popup
		options.addArguments("--disable-notifications");

		// Disable location popup
		options.addArguments("--disable-geolocation");

		// Set browser language = Vietnamese
		options.addArguments("--lang=vi");

		// Setting có hỏi lưu password ko ?
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		// Lưu file vào folder downloadFiles
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE);

		options.setExperimentalOption("prefs", prefs);

		// chạy ẩn danh
		// options.addArguments("--incognito");

		return new ChromeDriver(options);
	}

}
