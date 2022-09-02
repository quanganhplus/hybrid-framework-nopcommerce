package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	// private String projectPath = System.getProperty("user.dir");

	protected final Log log;

	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
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

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.USER_PAGE_URL);
		// driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			// System.setProperty("webdriver.gecko.driver", projectPath + ".//browserDrivers//geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
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

			ChromeOptions options = new ChromeOptions();
			// fake ip bằng UltaSurf-VPN
			// options.addExtensions(new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\UltraSurf-VPN-v1.7.1.crx"));
			// fix accept SSL
			options.setAcceptInsecureCerts(true);
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

		} else if (browserList == BrowserList.COCCOC) {
			// Cốc cốc browser trừ đi 5-6 version ra chrome driver
			WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		// driver.get(getEnvironmentValue(appUrl));
		// driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl, String ipAddress, String port) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;

		if (browserList == BrowserList.FIREFOX) {
			// System.setProperty("webdriver.gecko.driver", projectPath + ".//browserDrivers//geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);

			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.merge(capability);

		} else if (browserList == BrowserList.HEADLESS_FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);

		} else if (browserList == BrowserList.CHROME) {
			// System.setProperty("webdriver.chrome.driver", projectPath + ".//browserDrivers//chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);

			ChromeOptions cOptions = new ChromeOptions();
			cOptions.merge(capability);

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

		} else if (browserList == BrowserList.COCCOC) {
			// Cốc cốc browser trừ đi 5-6 version ra chrome driver
			WebDriverManager.chromedriver().driverVersion("101.0.4951.41").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, port)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		// driver.get(getEnvironmentValue(appUrl));
		driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriverBrowserstack(String browserName, String appUrl, String osName, String osVersion) {

		// Configure capabilities theo link https://www.browserstack.com/automate/capabilities
		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", osName);
		browserstackOptions.put("osVersion", osVersion);
		browserstackOptions.put("resolution", "2560x1600");
		browserstackOptions.put("projectName", "Nopcommerce");
		browserstackOptions.put("local", "false");
		browserstackOptions.put("seleniumVersion", "3.141.59");
		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("name", "Run on " + osName + " | " + osVersion + " | " + browserName);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriverSaucelab(String browserName, String appUrl, String osName) {

		MutableCapabilities capabilities = new MutableCapabilities();
		// đang ko lấy đc osName lên sever run Test của Saucelab (vẫn run Test đc ra browserName & browserVersion)
		// capabilities.setCapability("platformName", osName);
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("os", osName);
		sauceOptions.put("resolution", "2560x1600");
		sauceOptions.put("local", "false");
		sauceOptions.put("seleniumVersion", "3.141.59");
		capabilities.setCapability("sauce:options", sauceOptions);
		capabilities.setCapability("name", "Run on " + osName + " | " + browserName);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriverLamdaTest(String browserName, String appUrl, String osName, String browserVersion) {

		// Configure capabilities theo link https://automation.lambdatest.com/configure
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("version", browserVersion);
		capabilities.setCapability("platform", osName);
		capabilities.setCapability("resolution", "2560x1440");
		capabilities.setCapability("build", "First Test");
		capabilities.setCapability("name", "Sample Test");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		return driver;
	}

	protected String getEnvironmentValue(String environmentName) {
		String envUrl = null;
		EnvironmentList environmentList = EnvironmentList.valueOf(environmentName.toUpperCase());
		if (environmentList == EnvironmentList.DEV) {
			envUrl = "https://demo.guru99.com/v1";
		} else if (environmentList == EnvironmentList.TESTING) {
			envUrl = "https://demo.guru99.com/v2";
		} else if (environmentList == EnvironmentList.STAGING) {
			envUrl = "https://demo.guru99.com/v3";
		} else if (environmentList == EnvironmentList.PRODUCTION) {
			envUrl = "https://demo.guru99.com/v4";
		}
		return envUrl;
	}

	protected String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = "https://dev.nopcommerce.com/";
		} else if (environment == EnvironmentList.STAGING) {
			envUrl = "https://demo.nopcommerce.com";
		} else if (environment == EnvironmentList.PRODUCTION) {
			envUrl = "https://nopcommerce.com";
		}
		return envUrl;
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	protected int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-results";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}

	protected void showBrowserConsoleLogs(WebDriver driver) {
		if (driver.toString().contains("chrome")) {
			LogEntries logs = driver.manage().logs().get("browser");
			List<LogEntry> logList = logs.getAll();
			for (LogEntry logging : logList) {
				log.info(" -------------- " + logging.getLevel().toString() + " -------------- \n" + logging.getMessage());
			}
		}
	}

}
