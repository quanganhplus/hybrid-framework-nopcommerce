package javaAccessModifierFirst;

public class Computer {
	// Property
	private int ssdSize;

	String ramProductName;

	protected String cpuProductName;

	public int vgaSize;

	// Method
	private void setSsdSize(int ssdSize) {
		this.ssdSize = ssdSize;
	}

	void setRamProductName(String ramProduct) {
		ramProductName = ramProduct;
	}

	// Cách 1
	protected void setCpuProductName(String cpuProductName) {
		this.cpuProductName = cpuProductName;
	}

	// Cách 2
	protected void setCpuProductName2(String cpuProduct) {
		cpuProductName = cpuProduct;
	}

	public void setVgaSize(int vgaSize) {
		this.vgaSize = vgaSize;
	}

	public static void main(String[] args) {
		Computer comp = new Computer();

		// Private chỉ cho phép truy cập trong phạm vi class
		comp.ssdSize = 500;
		System.out.println(comp.ssdSize);

		comp.setSsdSize(600);
		System.out.println(comp.ssdSize);
		// -----------------------------------

		// Property : thông qua biến
		comp.vgaSize = 8;
		System.out.println(comp.vgaSize);

		// Method : thông qua hàm
		comp.setVgaSize(16);
		System.out.println(comp.vgaSize);

	}
}
