package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class BrowserStackFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String osVersion;

	public BrowserStackFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}

	public WebDriver createDriver() {
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

		return driver;
	}
}
