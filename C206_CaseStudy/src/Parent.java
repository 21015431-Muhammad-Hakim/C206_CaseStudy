
public class Parent {

	private String studentID;
	private String studentName;
	private String grade;
	private String classID;
	private String teacherName;
	private String studentCCA;
	private String parentName;
	private String parentEmail;
	
	private int parentContact;
	private int ccaID;
	
	public Parent(String studentID, String studentName, String grade, String classID, String teacherName, String studentCCA, String parentName, String parentEmail, int parentContact) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.classID = classID;
		this.teacherName = teacherName;
		this.studentCCA = studentCCA;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
	}
	
	
	public Parent(String studentID, String studentName, String grade, String classID, String teacherName, String studentCCA, String parentName, String parentEmail, int parentContact, int ccaID) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.classID = classID;
		this.teacherName = teacherName;
		this.studentCCA = studentCCA;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
		this.ccaID = ccaID;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getGrade() {
		return grade;
	}

	public String getClassID() {
		return classID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getParentName() {
		return parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public int getParentContact() {
		return parentContact;
	}
	
	public int getCCAID() {
		return ccaID;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public void setParentContact(int parentContact) {
		this.parentContact = parentContact;
	}

	public String getStudentCCA() {
		return studentCCA;
	}	
	
	
}
