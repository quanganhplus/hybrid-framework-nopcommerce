package javaOOP;

public class Topic_06_Getter_Setter {
	public String personName;
	public int personAge;
	public int personPhone;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalAccessError("Tên nhập vào ko hợp lệ!");
		} else {
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if (personAge > 15 && personAge < 60) {
			throw new IllegalAccessError("Tuổi nhập vào ko hợp lệ!");
		} else {
			this.personAge = personAge;
		}
	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalAccessError("Số phone nhập vào bắt đầu bằng: 09 - 03 - 0123 - 016 - 018 - 019");
		} else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalAccessError("Số phone nhập vào phải từ 10-11 số.");
		} else {
			this.personPhone = personPhone;
		}
	}

}
