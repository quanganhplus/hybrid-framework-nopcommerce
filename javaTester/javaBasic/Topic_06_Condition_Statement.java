package javaBasic;

public class Topic_06_Condition_Statement {

	public static void main(String[] args) {
		boolean status = 5 > 3;
		System.out.println(status);
		
		// Hàm if sẽ nhận vào 1 điều kiện đúng
		// Kiểm tra duy nhất 1 điều kiện
		// Nếu điều kiện đúng thì sẽ action trong phần thân
		if (status) {
			//Đúng thì vào phần thân của if
			//Sai thì bỏ qua
			System.out.println("Go to if");
		}

	}

}
