package javaOOP;

public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentName;
	private float knowledgePoint;
	private float practicePoint;

	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private float getKnowledgePoint() {
		return knowledgePoint;
	}

	private void setKnowledgePoint(float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	private Float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float getAveragePoint() {
		return (this.knowledgePoint + this.practicePoint * 2) / 3;
	}

	private void showStudentInfo() {
		System.out.println("****************************************");
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student Name = " + getStudentName());
		System.out.println("Student Knowledge Point = " + getKnowledgePoint());
		System.out.println("Student Practice Point = " + getPracticePoint());
		System.out.println("Student Average Point = " + getAveragePoint());
		System.out.println("****************************************");
	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(2005206);
		firstStudent.setStudentName("quang anh");
		firstStudent.setKnowledgePoint(8.0f);
		firstStudent.setPracticePoint(9.5f);
		firstStudent.showStudentInfo();

	}
}
