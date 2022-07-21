
public class Parent {

	private String studentID;
	private String studentName;
	private String grade;
	private String classID;
	private String teacherName;
	private String parentName;
	private String parentEmail;
	private String parentContact;
	private Student studentObject;
	
	public Parent(Student studentObject, String parentName, String parentEmail, String parentContact) {
		this.studentObject = studentObject;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
	}
	
	public Parent(String studentID, String studentName, String grade, String classID, String teacherName, String parentName, String parentEmail, String parentContact) {
		this.studentObject = new Student(studentID, studentName, grade, classID, teacherName);
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
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

	public String getParentContact() {
		return parentContact;
	}

	public Student getStudentObject() {
		return studentObject;
	}
	
	
}
