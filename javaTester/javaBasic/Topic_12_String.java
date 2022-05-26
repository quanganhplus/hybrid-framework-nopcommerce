package javaBasic;

public class Topic_12_String {

	public static void main(String[] args) {

		String schoolName = "Trường Hy Vọng FPT - ";
		String courseName = "TRƯỜNG HY VỌNG FPT - ";
		String schoolAddress = "Số 01, đường Trần Quốc Vượng, Hoà Hải, Ngũ Hành Sơn, Đà Nẵng";

		System.out.println("Độ dài chuỗi schoolName = " + schoolName.length());

		// Lấy ra 1 kí tự
		System.out.println("Lấy ra 1 kí tự đầu tiên = " + schoolAddress.charAt(0));
		System.out.println("Lấy ra 1 kí tự cuối cùng = " + schoolAddress.charAt(schoolAddress.length() - 1));

		// Nối chuỗi
		System.out.println("Nối 2 chuỗi : " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi : " + schoolName + schoolAddress);

		// Tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Trường Hy Vọng FPT - "));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(courseName));

		// Tương đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName.equalsIgnoreCase(courseName));

		// startsWith / endsWith / contains
		System.out.println("Có bắt đầu bằng 1 kí tự = " + schoolName.startsWith("T"));
		System.out.println("Có bắt đầu bằng 1 chuỗi kí tự = " + schoolName.startsWith("Trường"));
		System.out.println("Có chứa 1 chuỗi kí tự = " + schoolName.contains("FPT"));
		System.out.println("Kết thúc bằng 1 kí tự = " + schoolAddress.endsWith("g"));
		System.out.println("Kết thúc bằng 1 chuỗi kí tự = " + schoolAddress.endsWith("Nẵng"));

		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("FPT"));

		System.out.println("Tách 1 kí tự/ chuỗi kí tự = " + schoolName.substring(7));
		System.out.println("Tách 1 kí tự/ chuỗi kí tự = " + schoolName.substring(15, 18));

		// Split
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");

		for (String string : results) {
			System.out.println(string);
		}
		System.out.println(results[1]);

		// Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);

		// Sắp xếp nó : Sort Data (Asc/ Desc)
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);

		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice);
	}

}
