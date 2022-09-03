package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class LambdaTestFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String browserVersion;

	public LambdaTestFactory(String browserName, String osName, String browserVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.browserVersion = browserVersion;
	}

	public WebDriver createDriver() {
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

		return driver;
	}
}
