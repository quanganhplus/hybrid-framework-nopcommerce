package javaOOP;

public interface IComputer {

	// Nếu ko gán từ khóa là abstract cho hàm thì tự hiểu đây vẫn là 1 hàm abstract
	public void showComputerPerformance();

	// Abstract Method
	public abstract void showComputerRam();
}
