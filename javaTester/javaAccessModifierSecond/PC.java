package javaAccessModifierSecond;

import javaAccessModifierFirst.Computer;

public class PC extends Computer {

	public void showVgaSize() {
		vgaSize = 8;
		System.out.println(vgaSize);

		setVgaSize(16);
		System.out.println(vgaSize);
	}

}
