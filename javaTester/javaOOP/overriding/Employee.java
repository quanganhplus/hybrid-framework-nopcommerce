package javaOOP.overriding;

public class Employee extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("Suất ăn sáng 25k");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 8 tiếng/ ngày");

	}

	@Override
	public void workingTime() {
		System.out.println("Làm 8 tiếng/ ngày");
	}

}
