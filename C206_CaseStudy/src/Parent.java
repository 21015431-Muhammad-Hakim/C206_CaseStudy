
public class Parent {

	private String studentID;
	private String studentName;
	private String grade;
	private String classID;
	private String teacherName;
	private String parentName;
	private String parentEmail;
	
	private int parentContact;
	private int ccaID;
	
	private Student studentObject;
	private Parent parentObject;
	
	public Parent(Student studentObject, String parentName, String parentEmail, int parentContact) {
		this.studentObject = studentObject;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
	}
	
	public Parent(String studentID, String studentName, String grade, String classID, String teacherName, String parentName, String parentEmail, int parentContact) {
		this.studentObject = new Student(studentID, studentName, grade, classID, teacherName);
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
	}
	
	public Parent(Parent parentObject, int ccaID) {
		this.parentObject = parentObject;
		this.ccaID = ccaID;
	}
	
	public Parent(String studentID, String studentName, String grade, String classID, String teacherName, String parentName, String parentEmail, int parentContact, int ccaID) {
		this.parentObject = new Parent(studentID, studentName, grade, classID, teacherName, parentName, parentEmail, parentContact);
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

	public Student getStudentObject() {
		return studentObject;
	}
	
	public Parent getParentObject() {
		return parentObject;
	}
	
	public int getCCAID() {
		return ccaID;
	}	
}
