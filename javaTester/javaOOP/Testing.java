package javaOOP;

public class Testing extends Computer {

	public static void main(String[] args) {
		System.out.println(Topic_02_Variable_Property.studentAdress);

		Topic_02_Variable_Property.studentAdress = "London";
		System.out.println(Topic_02_Variable_Property.studentAdress);

		Topic_03_Method.showCarColor();

		// truy cập trực tiếp từ tên class
		// ko cần tạo instance/ object
		// ko nên lạm dụng các biến static
		System.out.println(Topic_04_Non_Acesss_Modifier.browserName);

		Topic_04_Non_Acesss_Modifier obj = new Topic_04_Non_Acesss_Modifier();
		System.out.println(obj.colorCar);

		Topic_04_Non_Acesss_Modifier.sendkeyToElement("Link");
	}

	@Override
	public void showComputerRam() {
		// TODO Auto-generated method stub

	}
}