package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

	public class Topic_08_For_foreach {
	WebDriver driver;
		
	@Test
	public void TC_01_For() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		
		//Array
		String[] cityName = {"Ho Chi Minh", "Ha Noi", "Da Nang", "Can Tho"};
		
		//for kết hợp if: thỏa mãn điều kiện mới action
		for (int i = 0; i < cityName.length; i++) {
			if (cityName[i].equals("Da Nang")) {
				//Action
				System.out.println("Do action !!!");
				//break: tìm thấy r thì dừng lại thoát vòng lặp
				break;
			}
		}
		
		//foreach: dùng để chạy qua tất cả các giá trị
		for (String city : cityName) {
			System.out.println(city);
		}
	}
	
	@Test
	public void TC_02_Foreach() {
		String[] cityName = {"Ho Chi Minh", "Ha Noi", "Da Nang", "Can Tho"};
		
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());
		
		cityAddress.add("Hai Phong");
		cityAddress.add("Quy Nhon");
		cityAddress.add("Khanh Hoa");
		System.out.println(cityAddress.size());
		
		for (String city : cityName) {
			cityAddress.add(city);
		}		
		System.out.println(cityAddress.size());
		
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
		
		//Java Generic
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		for (WebElement link : links) {
			//Chuyển page
			//Refesh DOM/HTML
			//Fail -> StaleElementException
			System.out.println(link);
		}
	}
}
