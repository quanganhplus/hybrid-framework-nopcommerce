package javaBasic;

public class Topic_11_Array {

	public static void main(String[] args) {
		
		int[] student = {5, 18, 22, 8, 10};
		
		//Lấy ra phần tử đầu tiên
		System.out.println(student[0]);
		
		String studentName[] = {"Nam", "Anh", "Tuấn"};
		for (int i = 0; i < studentName.length; i++) {
			System.out.println(studentName[i]);
		}
		
		//foreach ko kết hợp vs điều kiện
		for (String std : studentName) {
			System.out.println(std);
		}
		
	}

}
