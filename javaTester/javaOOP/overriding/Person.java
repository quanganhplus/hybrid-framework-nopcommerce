package javaOOP.overriding;

public abstract class Person {

	// Option
	public void eat() {
		System.out.println("Suất ăn sáng 35k");
	}

	// Must
	public abstract void sleep();

	public final void walk() {
		System.out.println("Đi bộ");
	}

	public static void run() {
		System.out.println("Đi bộ");
	}

	void dating() {
		System.out.println("Hẹn hò");
	}
}
