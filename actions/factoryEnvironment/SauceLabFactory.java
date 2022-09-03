package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class SauceLabFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;

	public SauceLabFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}

	public WebDriver createDriver() {
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

		return driver;
	}
}
