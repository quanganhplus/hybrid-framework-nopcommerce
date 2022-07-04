package javaOOP.inheritance;

public class Test {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setAge(-15);
		System.out.println(dog.getAge());

		dog.setAge(15);
		System.out.println(dog.getAge());

		dog.setAge(0);
		System.out.println(dog.getAge());
	}

}
