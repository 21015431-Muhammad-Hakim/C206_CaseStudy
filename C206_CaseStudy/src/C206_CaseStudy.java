import java.util.ArrayList;
import java.util.Random;

	
public class C206_CaseStudy {

	private static ArrayList<Parent> parentList = new ArrayList<Parent>();
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static ArrayList<Parent> updatedParentList = new ArrayList<Parent>();
	private static ArrayList<Cca> ccaList = new ArrayList<Cca>();
	private static int ccaID;

	private static final String NRIC_CHECK = "[TGF][0-9]{7}[A-Z]";
	private static final String GRADE_CHECK = "[P][1-6]";
	private static final String CLASS_CHECK = "[1-6][A-Z]";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0;

		while (option != 6) {
			menu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {//student
				int option1 = Helper.readInt("Enter choice (1.Add Student/2.View Student/Delete Student > ");
				if(option1 == 1) {
					String studentID = Helper.readStringRegEx("Enter in student ID > ", NRIC_CHECK);
					if(!studentList.contains(studentID)) {
						String studentName = Helper.readString("Enter in student Name > ");
						String grade = Helper.readStringRegEx("Enter in student Grade (P1/P2/P3/P4/P5/P6) > ",GRADE_CHECK);
						String classID = Helper.readStringRegEx("Enter in student Class > ",CLASS_CHECK);
						String[] result1 = grade.split("");
						String[] result2 = classID.split("");
						if(result1[1].contains(result2[0])) {
							String teacherName = Helper.readString("Enter in student's Teacher's Name > ");
							addStudent(studentID, studentName, grade, classID, teacherName);
						}else {
							System.out.println("Grade year and Class year do not match!");
						}
					}else {
						System.out.println("Student already found!");
			
					}
				}
				else if(option1 == 2) {
					viewStudent();
				}
				else if(option1 == 3) {
					String studentID = Helper.readString("Enter in studentID");
					deleteStudent(studentID);
				}
			} 
			else if (option == 2) {//cca

				int option2 = Helper.readInt("Enter choice (1.Add CCA details/2.View CCA/3.Delete a CCA) > ");

				if(option2 == 1) {
					String ccaTitle = Helper.readString("Enter CCA title > "); //Name of CCA
					String ccaDescription = Helper.readString("Enter CCA description > ");
					int classSize = Helper.readInt("Enter class size > ");
					String ccaDay = Helper.readString("Enter day of CCA > ");

					String ccaTime = Helper.readString("Enter time of CCA > ");


					String ccaVenue = Helper.readString("Enter venue of CCA > ");
					String instructorInCharge = Helper.readString("Enter instructor in charge > ");
					addCca(ccaTitle, ccaDescription, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge);

				}
				else if(option2 == 2) {
					viewAllCca();
				}
				else if(option2 == 3) {
					String ccaTitle = Helper.readString("Enter CCA title > ");
					deleteCca(ccaTitle);
				}

			} 

			else if (option == 3) {//cca category
				int option4 = Helper.readInt("Enter choice > ");
			} 

			else if (option == 4) {//parent(assume the student is registered first)
				int option3 = 0;
				while (option3 !=4) {
					parentMenu();
					option3 = Helper.readInt("Enter choice > ");

					if (option3 == 1) {
						String studentID = Helper.readString("Enter in student ID");
						String parentName = Helper.readString("Enter in parent's name");
						String parentEmail = Helper.readString("Enter in parent's email");
						int parentContact = Helper.readInt("Enter in parent's contact");

						Student studentObject = null;

						for (Student s: studentList) {
							if (s.getStudentID().equals(studentID)) {
								studentObject = s;
							}
						}
						addParent(studentObject, parentName, parentEmail, parentContact, parentList, updatedParentList, ccaID);
					}

					else if (option3 == 2) {
						System.out.println(viewParent(parentList));//do not show cca ID
					}

					else if (option3 == 3) {
						String studentID = Helper.readString("Enter in student ID");
						ccaID = Helper.readInt("Enter in CCA ID");

						deleteParent(ccaID, studentID, updatedParentList, parentList);
					}

					else if (option3 == 4) {

					}

					else {
						System.out.println("No such option");
					}
				}
			} 

			else if (option == 5) {//registration system
				int option5 = Helper.readInt("Enter choice > ");
			} 

			else if (option == 6) {//quit
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

	public static void parentMenu() {
		C206_CaseStudy.setHeader("Parent");
		System.out.println("1. Add parent");
		System.out.println("2. View parent");
		System.out.println("3. Delete parent");
		System.out.println("4. Quit");
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
		String output = String.format("%-15s %-15s %-5s %-10s %-10s", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name");
		for (Student s: studentList) {
			output += String.format("%-15s %-15s %-5s %-10s %-10s", s.getStudentID(), s.getStudentName(), s.getGrade(), s.getClassID(), s.getTeacherName());
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

	//================================= CCA Part =================================\\

	public static void addCca(String ccaTitle, String ccaDescription, int classSize, String ccaDay, String ccaTime, String ccaVenue, String instructorInCharge) {

		String output = "";
		if(ccaList.add(new Cca(ccaTitle, ccaDescription, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge))) {
			output = "CCA has been added!";
		}
		else {
			output = "Failed to add CCA.";
		}
		System.out.println(output);
	}

	public static void viewAllCca() {
		String output = String.format("%-10s %-15s %-15s %-15s %-15s %-10s %-10s", "Title", "Description", "Class Size", "Day of CCA", "Time of CCA", "Venue", "Instructor In Charge");
		for(Cca c : ccaList) {
			output += String.format("\n%-10s %-15s %-15d %-15s %-15s %-10s %-10s", c.getCcaTitle(), c.getCcaDescription(), c.getClassSize(), c.getCcaDay(), c.getCcaTime(), c.getCcaVenue(), c.getInstructorInCharge());

		}
		System.out.println(output);
	}

	public static void deleteCca(String ccaTitle) {

		String output = "";
		for (int i = 0; i < ccaList.size(); i++) {
			if (ccaList.get(i).getCcaTitle().equalsIgnoreCase(ccaTitle)){
				ccaList.remove(i);
				output = "CCA has been removed!";
			}
			else {
				output = "CCA remove failed.";
			}
			System.out.println(output);
		}
	}

	//================================= Parent Part =================================\\

	public static void addParent(Student studentObject, String parentName, String parentEmail, int parentContact, ArrayList<Parent> parentList, ArrayList<Parent> updatedParentList, int ccaID) {
		int size = parentList.size();
		parentList.add(new Parent(studentObject, parentName, parentEmail, parentContact));
		if (parentList.size() == size+1) {
			ccaID = generateCCAID();

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
	public static String viewParent(ArrayList<Parent> parentList) {
		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		for (Parent p: parentList) {
			output += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10d\n", p.getStudentObject().getStudentID(), p.getStudentObject().getStudentName(), p.getStudentObject().getGrade(), p.getStudentObject().getClassID(), p.getStudentObject().getTeacherName(), p.getParentName(), p.getParentEmail(), p.getParentContact());
		}
		return output;
	}

	public static void deleteParent(int ccaID, String studentID, ArrayList<Parent> updatedParentList, ArrayList<Parent> parentList) {
		for (int i=0;i<updatedParentList.size();i++) {//updatedParentList has elements inside
			if (updatedParentList.get(i).getParentObject().getStudentObject().getStudentID().equals(studentID) && updatedParentList.get(i).getParentObject().getCCAID() == ccaID){
				updatedParentList.remove(i);
			}
		}

		for (int i=0;i<parentList.size();i++) {
			if (parentList.get(i).getStudentObject().getStudentID().equals(studentID)){
				parentList.remove(i);
			}
		}
	}

	public static int generateCCAID() {
		String ccaID = "";
		Random number = new Random();

		ccaID += Integer.toString(number.nextInt(10));
		while (ccaID.contains("0")) {//check if the cca id start with 0
			ccaID = "";
			ccaID += Integer.toString(number.nextInt(10));
		}

		for (int i=0;i<8;i++) {//create rest of the cca id
			ccaID += Integer.toString(number.nextInt(10));
		}

		return Integer.parseInt(ccaID);
	}
}
