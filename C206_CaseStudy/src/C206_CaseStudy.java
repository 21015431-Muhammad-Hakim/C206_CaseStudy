import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {

	private ArrayList<Parent> parentList = new ArrayList<Parent>();
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Parent> updatedParentList = new ArrayList<Parent>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0;

		while (option != 3) {
			menu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {
				int option1 = Helper.readInt("Enter choice (1.Add Student/2.View Student/Delete Student > ");
				if(option1 == 1) {
					String studentID = Helper.readString("Enter in student ID");
					String studentName = Helper.readString("Enter in student Name");
					String grade = Helper.readString("Enter in student Grade");
					String classID = Helper.readString("Enter in student Class");
					String teacherName = Helper.readString("Enter in student's Teacher");
					addStudent(studentID, studentName, grade, classID, teacherName);
				}
				else if(option1 == 2) {
					viewStudent();
				}
				else if(option1 == 3) {
					String studentID = Helper.readString("Enter in studentID");
					deleteStudent(studentID);
				}
			} else if (option == 2) {
				int option2 = Helper.readInt("Enter choice > (1.Add Parent/2.View Parent/Delete Parent > ");
			} else if (option == 3) {
				int option3 = Helper.readInt("Enter choice > ");
			} else if (option == 4) {
				int option4 = Helper.readInt("Enter choice > ");
			} else if (option == 5) {
				int option5 = Helper.readInt("Enter choice > ");
			} else if (option == 6) {
				System.out.println("Thank You for using the CCA Registration App");
			}
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("CCA Registration App");
		System.out.println("1. Student");
		System.out.println("2. CCA");
		System.out.println("3. CCA Category");
		System.out.println("4. Parent");
		System.out.println("5. Registration System");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================= Student Part =================================\\

	public static void addStudent(String studentID, String studentName, String grade, String classID, String teacherName) {
		String output = "";
		if(studentList.add(new Student(studentID, studentName, grade, classID, teacherName))) {
			output = "Student has been added!";
		}
		System.out.println(output);
	}
	public static void viewStudent() {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name");
		for (Student s: studentList) {
			output += String.format("%-10s %-10s %-10s %-10s %-10s", s.getStudentID(), s.getStudentName(), s.getGrade(), s.getClassID(), s.getTeacherName());
		}
		System.out.println(output);
	}
	public static void deleteStudent(String studentID) {
		String output = "";
		for (int i=0;i<studentList.size();i++) {
			if (studentList.get(i).getStudentID().equals(studentID)){
				studentList.remove(i);
				output = "Student has been removed!";
			}
			System.out.println(output);
		}

	}

	//================================= Parent Part =================================\\

	public void addParent(Student studentObject, String parentName, String parentEmail, int parentContact) {
		if (parentList.add(new Parent(studentObject, parentName, parentEmail, parentContact))) {
			int ccaID = generateCCAID();

			for (int i=0;i<updatedParentList.size();i++) {
				if(updatedParentList.get(i).getCCAID() == ccaID) {//ensure no duplicated cca id
					ccaID = generateCCAID();
					i = 0;//restart to test if newly generated cca id is a duplicate
				}
			}
			updatedParentList.add(new Parent(parentList.get(parentList.size()-1), ccaID));

			System.out.println("Successfully registered!");
			System.out.println("CCA ID: " + ccaID);
		}
		else {
			System.out.println("Failed to register!");
		}
	}
	public void viewParent() {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		for (Parent p: parentList) {
			output += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10d", p.getStudentID(), p.getStudentName(), p.getGrade(), p.getClassID(), p.getTeacherName(), p.getParentName(), p.getParentEmail(), p.getParentContact());
		}
		System.out.println(output);
	}

	public void deleteParent(int ccaID, String studentID) {
		for (int i=0;i<updatedParentList.size();i++) {
			if (updatedParentList.get(i).getStudentID().equals(studentID) && updatedParentList.get(i).getCCAID() == ccaID){
				updatedParentList.remove(i);
			}
		}

		for (int i=0;i<parentList.size();i++) {
			if (parentList.get(i).getStudentID().equals(studentID) && parentList.get(i).getCCAID() == ccaID){
				parentList.remove(i);
			}
		}
	}

	public static int generateCCAID() {
		String ccaID = "";
		Random number = new Random();
		ccaID.concat(Integer.toString(number.nextInt(10)));

		while (ccaID.contains("0")) {//check if the cca id start with 0
			ccaID = "";
			ccaID.concat(Integer.toString(number.nextInt(10)));
		}

		for (int i=0;i<8;i++) {//create rest of the cca id
			ccaID.concat(Integer.toString(number.nextInt(10)));
		}

		return Integer.parseInt(ccaID);
	}
}
