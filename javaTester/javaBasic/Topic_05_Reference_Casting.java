package javaBasic;

public class Topic_05_Reference_Casting {
	public String studentName;

    public String getStudentName() {
            return studentName;
    }

    public void setStudentName(String studentName) {
            this.studentName = studentName;
    }

    public void showStudentName() {
            System.out.println("Student name = " + studentName);
    }

    public static void main(String[] args) {
    		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
    		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();

    		firstStudent.setStudentName("Nguyen Van A");
    		secondStudent.setStudentName("Trinh Van B");

            firstStudent.showStudentName();
            secondStudent.showStudentName();

            // Ép kiểu
            secondStudent = firstStudent;

            firstStudent.showStudentName();
            secondStudent.showStudentName();

            secondStudent.setStudentName("Bui Van C");

            firstStudent.showStudentName();
            secondStudent.showStudentName();
    }

}
