
public class Student {

	private String studentID;
	private String studentName;
	private String grade;
	private String classID;
	private String teacherName;
	private String studentCCA;
	private int CCANo;
	
	public Student(String studentID, String studentName, String grade, String classID, String teacherName, String studentCCA, int CCANo) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.classID = classID;
		this.teacherName = teacherName;
		this.studentCCA = studentCCA;
		this.CCANo = CCANo;
	}
	public String getStudentID() {
		return studentID;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getStudentCCA() {
		return studentCCA;
	}
	
	public void setStudentCCA(String studentCCA) {
		this.studentCCA = studentCCA;
	}
	public int getCCANO() {
		return CCANo;
	}
	public void setCCANO(int CCANo) {
		this.CCANo = CCANo;
	}

}
