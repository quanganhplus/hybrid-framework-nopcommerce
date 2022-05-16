package javaBasic;

import java.util.Scanner;

public class Topic_01_Variable {
	static int studentNumber;
	static boolean statusValue;
	static final String browserName = "Chrome";
	
	static int studentPrice;
	
	String studentName = "quang anh";
	
	public static void main(String[] args) {		
		int studentPrice = 6;
		
		System.out.println(studentPrice);
		
		System.out.println(studentNumber);
		System.out.println(statusValue);
		
		Topic_01_Variable topic = new Topic_01_Variable();
		
		System.out.println(topic.studentName);
		
		try (Scanner scanner = new Scanner(System.in)) {
			String name = scanner.nextLine();
			System.out.println(name);
			System.out.println(name);
			System.out.print(name);
			System.out.print(name);
		}
	}
	
	//Getter: getCurentUrl/ getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/ get Position/ ...
	public String getStudentName() {
		return this.studentName;
	}
	
	//Setter: click/ sendkey/ clear/ select/ back/forward/ refresh/ get/...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
	
<<<<<<< HEAD
}
=======
}
>>>>>>> branch 'master' of https://github.com/quanganhplus/hybrid-framework-nopcommerce
