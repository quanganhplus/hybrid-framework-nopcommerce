package javaOOP;

public class CarOOP {
	// thuộc tính
	private String carCompany;
	private String carType;
	private String fuelType;
	private Float mileAge;
	private Double carPrice;

	protected String getCarCompany() {
		return carCompany;
	}

	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected String getCarType() {
		return carType;
	}

	protected void setCarType(String carType) {
		this.carType = carType;
	}

	protected String getFuelType() {
		return fuelType;
	}

	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	protected Float getMileAge() {
		return mileAge;
	}

	protected void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	protected Double getCarPrice() {
		return carPrice;
	}

	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfo() {
		System.out.println("Car company = " + getCarCompany());
		System.out.println("Car type = " + getCarType());
		System.out.println("Car fuel Type = " + getFuelType());
		System.out.println("Car mile Age = " + getMileAge());
		System.out.println("Car price = " + getCarPrice());
	}

	public static void main(String[] args) {
		// Vinfast
		CarOOP vinfast = new CarOOP();
		vinfast.setCarCompany("VinGroup");
		vinfast.setCarType("LuxA");
		vinfast.setFuelType("Petrol");
		vinfast.setMileAge(150f);
		vinfast.setCarPrice(50000d);
		vinfast.showCarInfo();
	}

}
