package javaAccessModifierFirst;

public class Laptop {
	public static void main(String[] args) {
		Computer comp = new Computer();
		// Property : thông qua biến
		comp.vgaSize = 8;
		System.out.println(comp.vgaSize);

		// Method : thông qua hàm
		comp.setVgaSize(16);
		System.out.println(comp.vgaSize);
	}
}
