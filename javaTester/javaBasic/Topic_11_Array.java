package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;

public class Topic_11_Array {

	public static void main(String[] args) {

		// Cố định
		String studentName[] = { "Nam", "Anh", "Long" };
		for (int i = 0; i < studentName.length; i++) {
			if (studentName[i].equals("Long")) {
				System.out.println("Click vào Long");
			}
		}

		// Động
		ArrayList<String> stdName = new ArrayList<String>();

		// khi chạy code mới add (Runtime)
		for (String std : studentName) {
			stdName.add(std);
		}

		String std_Name = Arrays.toString(studentName);
		System.out.println(std_Name);

		// [Nam, Anh, Long]
	}

}
