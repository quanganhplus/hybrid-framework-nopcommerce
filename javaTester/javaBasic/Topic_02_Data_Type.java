package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Global variable
	static int number;

	// Primitive type/ value type: Kiểu dữ liệu Nguyên thủy lưu trữ dl trong chính bản thân nó (vùng Stack)
	byte bNumber = 6;
	short sNumber = 1500;
	int iNumber = 68000;
	long lNumber = 68000;
	float fNumber = 16.68f;
	double dNumber = 16.68d;
	char cChar = '1';
	boolean bStatus = false;

	// Reference type: Kiểu dữ liệu Tham chiếu chỉ lưu trữ 1 giá trị là đ/c vùng nhớ mà nó tham chiếu đến (vùng Head)

	// String
	String address = "Ha Noi";

	// Array
	String[] studentAddress = { address, "Ha Noi", "Ho Chi Minh" };
	Integer[] studentNumber = { 15, 20, 68 };

	// Class
	Topic_02_Data_Type topic;

	// Interface
	WebDriver driver;

	// Object
	Object aObject;

	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> checkboxs = driver.findElements(By.xpath(""));

	Set<String> allWindows = driver.getWindowHandles();

	List<String> productName = new ArrayList<String>();

	public void clickToElement() {
		address.trim();
		studentAddress.clone();
		
		driver.getCurrentUrl();
		
		aObject.hashCode();
		
		checkboxs.size();
		
		Topic_02_Data_Type topic = new Topic_02_Data_Type();
		topic.address = "Ho Chi Minh";
	}

	public static void main(String[] args) {
		
	}

}
