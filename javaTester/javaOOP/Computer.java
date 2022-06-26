package javaOOP;

public abstract class Computer {

	// Normal Method
	public void showComputerPerformance() {
		System.out.println("Show computer performance");
	}

	// Abstract Method
	// ko có phần thân (body)
	// khung để cho các class con kế thừa nó phải override lại (implement lại)
	public abstract void showComputerRam();
}
