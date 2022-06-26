package javaOOP;

public class Topic_02_Variable_Property {
	static int studentNumber;
	static String studentCountry;
	static boolean studentStatus;

	// Acess Modifer
	// Data type
	// Variable name
	// Variable value
	private String studentName = "quang anh"; // Biến toàn cục variable (Global variable)

	// Static variable : dùng và gán lại đc
	public static String studentAdress = "Ha Noi";

	// Dùng trong phạm vi class (cho tất cả instance/ object dùng)
	private static String studentPhone = "0123456789";

	// Final variable : Ko cho phép gán lại / Override lại
	final String country = "Viet Nam";

	// Static final variable : hằng số
	// Nó ko đc ghi đè
	// Có thể truy cập rộng rãi cho tất cả instance / thread
	static final float PI_NUMBER = 3.14567879f;

	// Acess Modifer: Default
	int studentID = 25062022;

	// Hàm (Method) - Static
	public static void main(String[] args) {
		// Local variable - biến cục bộ: hàm
		String studentName = "quang anh";

		if (studentName.startsWith("anh")) {
			// Local variable - biến cục bộ: block code
			// int number = 100;
		}

		studentAdress = "NewYork";

		System.out.println(studentNumber);
		System.out.println(studentCountry);
		System.out.println(studentStatus);
	}

	// Contructor : hàm khởi tạo của 1 class
	public Topic_02_Variable_Property() {
		// Local variable - biến cục bộ: Contructor
		String studentName = "quang anh";
		if (studentName.startsWith("anh")) {

		}
		this.studentName.startsWith("anh");
		System.out.println(Topic_02_Variable_Property.studentPhone);
	}

	// Hàm (Method) - non static
	public void display() {
		// Local variable - biến cục bộ: hàm
		// String studentName = "quang anh";

	}
}
