package fpt.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
	//Toàn cục
	String homePageUrl = "";
	
	 @BeforeClass
	  public void beforeClass() {
		  
	 }

	 @Test
	 public void TC_01() {
		 //Cục bộ: Sử dụng trong phạm vi của testcase/ hàm
		 String homePageUrl = ""; 
		 
		 System.out.println(homePageUrl);
		 
		 //Block code
		 if(3<5) {
			 //Cục bộ
			 String homePageTitle = "";
			 System.out.println(homePageTitle);
		 }
	 }
	 
	 @Test
	 public void TC_02() {
		 System.out.println(homePageUrl);
	 }
  
 
	 @AfterClass
	 public void afterClass() {
	  
	 }

}
