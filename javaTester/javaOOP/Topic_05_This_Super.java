package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP {
	private WebDriver driver;

	// Global
	// private long shortTimeout = 15;
	private long longTimeout = 45;

	public Topic_05_This_Super() {
		super("Chrome");
		System.out.println("Contructor cuar Class con");
	}

	public void setImplicitWait() {
		long shortTimeout = 15;

		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(super.shortTimeout, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(this.longTimeout, TimeUnit.SECONDS);
	}

	public void clickToElement() {
		// ko dùng super sẽ gọi qua hàm ở Class con
		setImplicitWait();

		// Gọi qua hàm lớp cha
		super.setImplicitWait();
	}

	public static void main(String[] args) {
		// Topic_05_This_Super topic = new Topic_05_This_Super();
	}
}
