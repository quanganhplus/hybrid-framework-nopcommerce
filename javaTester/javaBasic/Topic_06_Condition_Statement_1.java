package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_06_Condition_Statement_1 {

	public static void main(String[] args) {
		boolean status = 5 > 3;
		System.out.println(status);
		
		//Gán (assign)
		int studentNumber = 10;
		
		//== So sánh
		status = (studentNumber != 10);
		System.out.println(status);
		
		// Hàm if sẽ nhận vào 1 điều kiện đúng
		// Kiểm tra duy nhất 1 điều kiện
		// Nếu điều kiện đúng thì sẽ action trong phần thân
		if (status) {
			//Đúng thì vào phần thân của if
			//Sai thì bỏ qua
			System.out.println("Go to if");
		}
		
		WebDriver driver = new FirefoxDriver();
		
		//Element luôn luôn có trong DOM dù popup hiển thị hay ko
		WebElement salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			
		}

		//Element ko có trong DOM khi popup ko hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		//Check Element ko hiển thị
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
			
		}
		
		//Uncheck to checkbox
		WebElement languagesCheckbox = driver.findElement(By.id(""));
		if (languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
		
		//Check to checkbox
		if (!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}		
	}

}
