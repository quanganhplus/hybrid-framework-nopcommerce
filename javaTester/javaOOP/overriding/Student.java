package javaOOP.overriding;

public class Student extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("Suất ăn sáng 15k");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 12 tiếng/ ngày");

	}

	@Override
	public void workingTime() {
		System.out.println("Học 6 tiếng/ ngày");
	}

	public void run(String name) {
		System.out.println("Học 6 tiếng/ ngày");
	}

	@Override
	public void dating() {
		System.out.println("Hẹn hò 3 tiếng/ ngày");
	}
}
