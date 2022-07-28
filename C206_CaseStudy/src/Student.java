
public class Student {

	private String studentID;
	private String studentName;
	private String grade;
	private String classID;
	private String teacherName;
	
	public Student(String studentID, String studentName, String grade, String classID, String teacherName) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.classID = classID;
		this.teacherName = teacherName;
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

}
