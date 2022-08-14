package pageObjects.saucelab.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.sort.AdminProductsPageUI;

public class AdminProductsPO extends BasePage {
	WebDriver driver;

	public AdminProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductsSortDropdown(String textItem) {
		waitForElementClickable(driver, AdminProductsPageUI.PRODUCTS_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminProductsPageUI.PRODUCTS_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductsNameSortByAscending() {
		// Khai báo ra 1 ArrayList để chứa các products name trên UI
		ArrayList<String> productsNameUIList = new ArrayList<String>();

		// Lấy ra tất cả các text products name
		List<WebElement> productsNametext = getListWebElement(driver, AdminProductsPageUI.PRODUCTS_NAME_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productsName : productsNametext) {
			productsNameUIList.add(productsName.getText());
			System.out.println("Products Name trên UI : " + productsName.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
		ArrayList<String> productsNameSortList = new ArrayList<String>();
		for (String products : productsNameUIList) {
			productsNameSortList.add(products);
		}

		// Sort cái productsNameSortList
		Collections.sort(productsNameSortList);

		for (String productsName : productsNameSortList) {
			System.out.println("Products Name sau khi sort Ascending : " + productsName);
		}

		System.out.println("------------------------------------------------------------------------------");

		// So sánh 2 List đã bằng nhau
		return productsNameSortList.equals(productsNameUIList);
	}

	public boolean isProductsNameSortByDescending() {
		// Khai báo ra 1 ArrayList để chứa các products name trên UI
		ArrayList<String> productsNameUIList = new ArrayList<String>();

		// Lấy ra tất cả các text products name
		List<WebElement> productsNametext = getListWebElement(driver, AdminProductsPageUI.PRODUCTS_NAME_TEXT);

		// Dùng vòng lặp để getText và add vào ArrayList trên
		for (WebElement productsName : productsNametext) {
			productsNameUIList.add(productsName.getText());
			System.out.println("Products Name trên UI : " + productsName.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
		ArrayList<String> productsNameSortList = new ArrayList<String>();
		for (String products : productsNameUIList) {
			productsNameSortList.add(products);
		}

		// Sort cái productsNameSortList
		Collections.sort(productsNameSortList);

		for (String productsName : productsNameSortList) {
			System.out.println("Products Name sau khi sort Ascending : " + productsName);
		}

		// Reverse cái productsNameSortList
		Collections.reverse(productsNameSortList);

		for (String productsName : productsNameSortList) {
			System.out.println("Products Name sau khi sort Decending : " + productsName);
		}

		System.out.println("------------------------------------------------------------------------------");

		// So sánh 2 List đã bằng nhau
		return productsNameSortList.equals(productsNameUIList);
	}

	public boolean isProductsPriceSortByAscending() {
		// Khai báo ra 1 ArrayList để chứa các products price trên UI
		ArrayList<Float> productsPriceUIList = new ArrayList<Float>();

		// Lấy ra tất cả các text products price
		List<WebElement> productsPricetext = getListWebElement(driver, AdminProductsPageUI.PRODUCTS_PRICE_TEXT);

		// Dùng vòng lặp để getText, xóa kí tự $, đổi kiểu Float và add vào ArrayList trên
		for (WebElement productsPrice : productsPricetext) {
			productsPriceUIList.add(Float.parseFloat(productsPrice.getText().replace("$", "")));
			System.out.println("Products Price trên UI : " + productsPrice.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
		ArrayList<Float> productsPriceSortList = new ArrayList<Float>();
		for (Float products : productsPriceUIList) {
			productsPriceSortList.add(products);
		}

		// Sort cái productsPriceSortList
		Collections.sort(productsPriceSortList);

		for (Float productsPrice : productsPriceSortList) {
			System.out.println("Products Price sau khi sort Ascending : " + productsPrice);
		}

		System.out.println("------------------------------------------------------------------------------");

		// So sánh 2 List đã bằng nhau
		return productsPriceSortList.equals(productsPriceUIList);
	}

	public boolean isProductsPriceSortByDescending() {
		// Khai báo ra 1 ArrayList để chứa các products price trên UI
		ArrayList<Float> productsPriceUIList = new ArrayList<Float>();

		// Lấy ra tất cả các text products price
		List<WebElement> productsPricetext = getListWebElement(driver, AdminProductsPageUI.PRODUCTS_PRICE_TEXT);

		// Dùng vòng lặp để getText, xóa kí tự $, đổi kiểu Float và add vào ArrayList trên
		for (WebElement productsPrice : productsPricetext) {
			productsPriceUIList.add(Float.parseFloat(productsPrice.getText().replace("$", "")));
			System.out.println("Products Price trên UI : " + productsPrice.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay ko
		ArrayList<Float> productsPriceSortList = new ArrayList<Float>();
		for (Float products : productsPriceUIList) {
			productsPriceSortList.add(products);
		}

		// Sort cái productsPriceSortList
		Collections.sort(productsPriceSortList);

		for (Float productsPrice : productsPriceSortList) {
			System.out.println("Products Price sau khi sort Ascending : " + productsPrice);
		}

		// Reverse cái productsPriceSortList
		Collections.reverse(productsPriceSortList);

		for (Float productsPrice : productsPriceSortList) {
			System.out.println("Products Price sau khi sort Decending : " + productsPrice);
		}

		System.out.println("------------------------------------------------------------------------------");

		// So sánh 2 List đã bằng nhau
		return productsPriceSortList.equals(productsPriceUIList);
	}
}
