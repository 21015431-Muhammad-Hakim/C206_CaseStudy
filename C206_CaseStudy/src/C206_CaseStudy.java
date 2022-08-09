import java.util.ArrayList;
import java.util.Random;


public class C206_CaseStudy {

	private static final int OPTION_ADDSTUDENT_FORCCA = 1;
	private static final int OPTION_VIEW_REGISTRATION = 2;
	private static final int OPTION_QUIT_REGISTRATION = 3;
	private static final int OPTION_UPDATE_PARENT = 4;
	private static final int OPTION_DELETE_PARENT = 3;
	private static final int OPTION_VIEW_PARENT = 2;
	private static final int OPTION_ADD_PARENT = 1;
	private static final int OPTION_QUIT_PARENT = 5;
	private static final int OPTION_QUIT_CCA_CATEGORY = 4;
	private static final int OPTION_QUIT_STUDENT = 5;
	private static final int OPTION_QUIT_CCA = 5;
	private static final int OPTION_PARENT = 4;
	private static final int OPTION_DELETE_CATEGORY = 3;
	private static final int OPTION_VIEW_CATEGORY = 2;
	private static final int OPTION_ADD_CATEGORY = 1;
	private static final int OPTION_CCA_CATEGORY = 3;
	private static final int OPTION_UPDATE_CCA = 4;
	private static final int OPTION_DELETE_CCA = 3;
	private static final int OPTION_VIEW_CCA = 2;
	private static final int OPTION_ADD_CCA = 1;
	private static final int OPTION_CCA = 2;
	private static final int OPTION_UPDATE_STUDENT = 4;
	private static final int OPTION_DELETE_STUDENT = 3;
	private static final int OPTION_VIEW_STUDENT = 2;
	private static final int OPTION_ADD_STUDENT = 1;
	private static final int OPTION_STUDENT = 1;
	private static final int OPTION_QUIT = 6;

	private static ArrayList<Parent> parentList = new ArrayList<Parent>();
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static ArrayList<Parent> updatedParentList = new ArrayList<Parent>();
	private static ArrayList<Cca> ccaList = new ArrayList<Cca>();
	private static ArrayList<String> categoryList = new ArrayList<String>();
	private static ArrayList<String> dayList = new ArrayList<String>();


	private static int ccaID;

	private static final String NRIC_CHECK = "[A-Z][0-9]{4}";
	private static final String GRADE_CHECK = "[P][1-6]";
	private static final String CLASS_CHECK = "[1-6][A-Z]";



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dayList.add("Monday");
		dayList.add("Tuesday");
		dayList.add("Wednesday");
		dayList.add("Thursday");
		dayList.add("Friday");

		studentList.add(new Student("A0000","John","P6","6A","Mary","Basketball", 1));
		parentList.add(new Parent("A0000","John","P6","6A","Mary","Basketball","1","@",1));
		updatedParentList.add(new Parent("A0000","John","P6","6A","Mary","Basketball","1","@",1,1));

		for (Cca i: ccaList) {
			categoryList.add(i.getCategory());
		}

		int option = 0;

		while (option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter choice > ");

			if (option == OPTION_STUDENT) {//student
				studentMenu();
				int option1 = Helper.readInt("Enter choice > ");
				while(option1 != 5) {
					if(option1 == OPTION_ADD_STUDENT) {
						String studentID = Helper.readStringRegEx("Enter in student ID > ", NRIC_CHECK);
						for(Student S :studentList) {
							if(!studentID.equalsIgnoreCase(S.getStudentID())) {
								String studentName = Helper.readString("Enter in student Name > ");
								if(studentName.isBlank() == false) {
									String grade = Helper.readStringRegEx("Enter in student Grade (P1/P2/P3/P4/P5/P6) > ",GRADE_CHECK);
									if(grade.isBlank() == false) {
										String classID = Helper.readStringRegEx("Enter in student Class > ",CLASS_CHECK);
										if(classID.isBlank() == false) {
											String[] result1 = grade.split("");
											String[] result2 = classID.split("");
											if(result1[1].contains(result2[0])) {
												String teacherName = Helper.readString("Enter in student's Teacher's Name > ");
												String studentCCA = Helper.readString("Enter in student's CCA(If no CCA enter N/A)> ");
												int CCANo = Helper.readInt("Enter the No of CCA that student have (0-3) >");
												addStudent(studentID, studentName, grade, classID, teacherName, studentCCA, CCANo, studentList);
												break;
											}
											else {
												System.out.println("Grade year and Class year do not match!");
											}
										}else {
											System.out.println("Please enter student class!");
										}
									}else {
										System.out.println("Please enter student's grade!");
									}
								}else {
									System.out.println("Please enter student's name!");
								}
							}
							else {
								System.out.println("Student already found!");
							}

						}
					}
					else if(option1 == OPTION_VIEW_STUDENT) {
						viewStudent(studentList);
					}
					else if(option1 == OPTION_DELETE_STUDENT) {
						String studentID = Helper.readString("Enter in studentID > ");
						deleteStudent(studentID, studentList);
					}
					else if(option1 == OPTION_UPDATE_STUDENT) {
						String studentID = Helper.readString("Enter in studentID > ");
						updateStudent(studentID);
					}
					else if (option1 == OPTION_QUIT_STUDENT) {

					}else {
						System.out.println("Invalid option");
					}


				}
			}

			else if (option == OPTION_CCA) {//cca

				CCAMenu();
				int option2 = Helper.readInt("Enter choice > ");
				while(option2 != 5) {
					if(option2 == OPTION_ADD_CCA) {
						String ccaTitle = Helper.readString("Enter CCA title > "); //Name of CCA
						String ccaDescription = Helper.readString("Enter CCA description > ");
						String category = Helper.readString("Enter category > ");
						int classSize = Helper.readInt("Enter class size > ");

						if(classSize <= 50) {   //To make sure class size enter is not more then 50
							String ccaDay = Helper.readString("Enter day of CCA > ");

							if(dayList.contains(ccaDay)) {  //To check if day enter is a valid day
								String ccaTime = Helper.readString("Enter time of CCA > ");

								String ccaVenue = Helper.readString("Enter venue of CCA > ");
								String instructorInCharge = Helper.readString("Enter instructor in charge > ");

								addCca(ccaTitle, ccaDescription, category, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, ccaList);

								CCAMenu();
								option2 = Helper.readInt("Enter choice > ");
								}
								

							else {
								System.out.println("Please enter a valid day.");
							}

						}
						else {
							System.out.println("Class size is too big. Please enter a smaller class size.");
						}
		
					}
					

					else if(option2 == OPTION_VIEW_CCA) {
						viewAllCca(ccaList);
					}
					else if(option2 == OPTION_DELETE_CCA) {
						String ccaTitle = Helper.readString("Enter CCA title > ");
						deleteCca(ccaTitle, ccaList);
						break;
					}
					else if(option2 == OPTION_UPDATE_CCA) {
						String ccaTitle = Helper.readString("Enter CCA title > ");
						updateCca(ccaTitle);
						break;
					}
					else if (option2 == OPTION_QUIT_CCA) {

					}
					else {
						System.out.println("Invalid option");
					}

				}
			}


			else if (option == OPTION_CCA_CATEGORY) {//cca category

				int option4 = 0;
				while (option4 != 4) {
					categoryMenu();
					option4 = Helper.readInt("Enter choice > ");
					if (option4 == OPTION_ADD_CATEGORY) {
						addCategory(categoryList);
					}

					else if (option4 == OPTION_VIEW_CATEGORY) {
						viewCategory(ccaList);
					}

					else if (option4 == OPTION_DELETE_CATEGORY) {
						deleteCategory(categoryList);
					}
					else if (option4 == OPTION_QUIT_CCA_CATEGORY) {

					}
					else {
						System.out.println("Invalid option");
					}
				}
			} 

			else if (option == OPTION_PARENT) {//parent(assume the student is registered first)
				int option3 = 0;
				while (option3 !=5) {
					parentMenu();
					option3 = Helper.readInt("Enter choice > ");

					if (option3 == OPTION_ADD_PARENT) {
						String studentID = Helper.readString("Enter in student ID");
						String parentName = Helper.readString("Enter in parent's name");
						String parentEmail = Helper.readString("Enter in parent's email");
						int parentContact = Helper.readInt("Enter in parent's contact");

						Student studentObject = null;

						for (Student s: studentList) {
							if (s.getStudentID().equals(studentID)) {
								studentObject = s;
								addParent(studentObject, parentName, parentEmail, parentContact, parentList, updatedParentList, ccaID);
							}
							else {
								System.out.println("Register failed!");
							}
						}
						
					}

					else if (option3 == OPTION_VIEW_PARENT) {
						System.out.println(viewParent(parentList));//do not show cca ID
					}

					else if (option3 == OPTION_DELETE_PARENT) {
						String studentID = Helper.readString("Enter in student ID");
						ccaID = Helper.readInt("Enter in CCA ID");

						deleteParent(ccaID, studentID, updatedParentList, parentList);
					}

					else if (option3 == OPTION_UPDATE_PARENT) {
						ccaID = Helper.readInt("Enter in CCA ID");
						String parentName = Helper.readString("Enter parent name to update(Enter same name if do not want to update) > ");
						String parentEmail = Helper.readString("Enter parent email to update (Enter same email if do not want to update) > ");
						int parentContact = Helper.readInt("Enter parent contact to update (Enter same contact if do not want to update) > ");
						updateParent(ccaID, parentName, parentEmail, parentContact, parentList, updatedParentList);
					}

					else if (option3 == OPTION_QUIT_PARENT) {


					}else {
						System.out.println("Invalid option");
					}
				}
			} 

			else if (option == 5) {//registration system
				loginsystem();
				loginMenu();
				int option5 = Helper.readInt("Enter the choice >");
				while (option5 != 3) {
					if (option5 == OPTION_ADDSTUDENT_FORCCA) {
						addStudentforCCA();
					} 
					else if (option5 == OPTION_VIEW_REGISTRATION) {
						viewStudentRegCCA();
					} 
					else if (option5 == OPTION_QUIT_REGISTRATION) {
						System.out.println("You will be log out of the system.");
					}else {
						System.out.println("Invalid option");
					}
				}
			} 

			else if (option == OPTION_QUIT) {//quit
				System.out.println("Thank You for using the CCA Registration App");
			}
		}
	}

	//================================= Menu Codes =================================\\

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
	public static void studentMenu() {
		C206_CaseStudy.setHeader("Student");
		System.out.println("1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Update Student");
		System.out.println("5. Quit");

	}
	public static void CCAMenu() {
		C206_CaseStudy.setHeader("CCA");
		System.out.println("1. Add CCA");
		System.out.println("2. View CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Update CCA");
		System.out.println("4. Quit");

	}

	public static void categoryMenu() {
		C206_CaseStudy.setHeader("CCA Category");
		System.out.println("1. Add Category");
		System.out.println("2. View Category");
		System.out.println("3. Delete Category");
		System.out.println("4. Quit");

	}

	public static void parentMenu() {
		C206_CaseStudy.setHeader("Parent");
		System.out.println("1. Add parent");
		System.out.println("2. View parent");
		System.out.println("3. Delete parent");
		System.out.println("4. Update parent");
		System.out.println("5. Quit");
	}

	public static void loginMenu() {
		C206_CaseStudy.setHeader("Registration System");
		System.out.println("1. Add Student for CCA");
		System.out.println("2. View Student Registered for a CCA");
		System.out.println("3. Log out");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================= Student Part =================================\\

	public static void addStudent(String studentID, String studentName, String grade, String classID, String teacherName, String studentCCA, int CCANo, ArrayList<Student> studentList) {
		String output = "";
		if(studentList.add(new Student(studentID, studentName, grade, classID, teacherName, studentCCA, CCANo))) {
			output = "Student has been added!";
		}else {
			output = "Failed to add Student!";
		}
		System.out.println(output);
	}
	public static String viewStudent(ArrayList<Student> studentList) {
		String output = String.format("%-12s %-15s %-5s %-10s %-10s %-10s %-10s", "Student ID", "Student Name", "Grade", 
				"Class ID", "Teacher name", "Student CCA", "No of CCA");
		for (Student s: studentList) {
			output += String.format("\n%-12s %-15s %-5s %-10s %-10s %-10s %-10d", s.getStudentID(), s.getStudentName(), 
					s.getGrade(), s.getClassID(), s.getTeacherName(), s.getStudentCCA(), s.getCCANO());
		}
		System.out.println(output);
		return output;
	}
	public static void deleteStudent(String studentID, ArrayList<Student> studentList) {
		String output = "";
		for (int i=0;i<studentList.size();i++) {
			if (studentList.get(i).getStudentID().equals(studentID)){
				studentList.remove(i);
				output = "Student has been removed!";
			}else {
				output = "Student not found!";
			}
			System.out.println(output);

		}
	}
	public static void updateStudent(String studentID) {
		for (int i=0;i<studentList.size();i++) {
			if (studentList.get(i).getStudentID().equals(studentID)){
				String grade = Helper.readStringRegEx("Enter in student's new Grade (P1/P2/P3/P4/P5/P6) > ",GRADE_CHECK);
				String classID = Helper.readStringRegEx("Enter in student's new Class > ",CLASS_CHECK);
				String[] result1 = grade.split("");
				String[] result2 = classID.split("");
				if(result1[1].contains(result2[0])) {
					studentList.get(i).setGrade(grade);
					studentList.get(i).setClassID(classID);
					String teacherName = Helper.readString("Enter in student's new Teacher's Name > ");
					studentList.get(i).setTeacherName(teacherName);
					String studentCCA = Helper.readString("Enter in student's new CCA> ");
					studentList.get(i).setStudentCCA(studentCCA);
				}else {
					System.out.println("Grade year and Class year do not match!");
				}

			}else {
				System.out.println("Student not found!");
			}
		}
	}

	//================================= CCA Part =================================\\

	public static void addCca(String ccaTitle, String ccaDescription, String category, 
			int classSize, String ccaDay, String ccaTime, String ccaVenue, String instructorInCharge, ArrayList<Cca> ccaList) {

		String output = "";
		if(ccaList.add(new Cca(ccaTitle, ccaDescription, category, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge))) {
			output = "CCA has been added!";
		}
		else {
			output = "Failed to add CCA.";
		}
		System.out.println(output);
	}

	public static String viewAllCca(ArrayList<Cca> ccaList) {
		String output = String.format("%-10s %-15s %-15s %-15s %-15s %-15s %-10s %-10s", "Title", "Description", "Category", 
				"Class Size", "Day of CCA", "Time of CCA", "Venue", "Instructor In Charge");
		for(Cca c : ccaList) {
			output += String.format("\n%-10s %-15s %-15s %-15d %-15s %-15s %-10s %-10s", c.getCcaTitle(), c.getCcaDescription(), 
					c.getCategory(), c.getClassSize(), c.getCcaDay(), c.getCcaTime(), c.getCcaVenue(), c.getInstructorInCharge());

		}
		System.out.println(output);
		return output;
	}

	public static void deleteCca(String ccaTitle, ArrayList<Cca> ccaList) {

		String output = "";
		for (int i = 0; i < ccaList.size(); i++) {
			if (ccaList.get(i).getCcaTitle().equalsIgnoreCase(ccaTitle)){
				ccaList.remove(i);
				output = "CCA has been removed!";
			}
			else {
				output = "CCA not found!";
			}
			System.out.println(output);
		}
	}

	public static void updateCca(String ccaTitle) {

		for (int i=0;i<ccaList.size();i++) {
			if (ccaList.get(i).getCcaTitle().equals(ccaTitle)){

				String ccaDescription = Helper.readString("Enter CCA description > ");
				String category = Helper.readString("Enter category > ");
				
				int classSize = Helper.readInt("Enter class size > ");

				if(classSize <= 50) {  //Checking class size to make sure it is not larger than 50
					ccaList.get(i).setClassSize(classSize);

					String ccaDay = Helper.readString("Enter day of CCA > ");
					
					if(dayList.contains(ccaDay)) {
						ccaList.get(i).setCcaDay(ccaDay);

						String ccaTime = Helper.readString("Enter time of CCA > ");
						ccaList.get(i).setCcaTime(ccaTime);

						String ccaVenue = Helper.readString("Enter venue of CCA > ");
						ccaList.get(i).setCcaVenue(ccaVenue);

						String instructorInCharge = Helper.readString("Enter instructor in charge > ");
						ccaList.get(i).setInstructorInCharge(instructorInCharge);

						System.out.println("CCA details updated!");

					}
					else {
						System.out.println("Please enter a valid day.");
					}

				}
				else {
					System.out.println("Class size is too big. Please enter a smaller class size.");
				}

			}else {
				System.out.println("CCA not found!");
			}
		}
	}

	public static void checkCcaPolicies(String studentid) {
		int numOfCcaPerWk = Helper.readInt("Enter total number of CCA(s) per week > ");

		if(numOfCcaPerWk > 0 && numOfCcaPerWk <= 3) {  //Max number of CCA should be 3

			int numOfCcaPerDay = Helper.readInt("Enter number of CCA(s) per day > ");

			if(numOfCcaPerDay == 2) {  //If CCA per day is 2

				char ccaLunchBreak = Helper.readChar("One CCA during lunch break? (Y/N) > "); 
				char ccaAfterSchool = Helper.readChar("One CCA after class? (Y/N) > ");

				if(ccaLunchBreak == 'Y' && ccaAfterSchool == 'Y') {
					System.out.println("Number of CCA per day is acceptable.");
				}
				else if(ccaLunchBreak == 'Y' && ccaAfterSchool == 'N') {
					System.out.println("Please make sure one CCA is after school.");
				}
				else if(ccaLunchBreak == 'N' && ccaAfterSchool == 'Y') {
					System.out.println("Please make sure one CCA is during lunch break.");
				}
				else {
					System.out.println("Please make sure that one CCA is during lunch break and one is after class.");
				}
			}
			else {      //CCA per day is 1
				System.out.println("Number of CCA per day is acceptable.");
			}

		}
		else {
			System.out.println("Only 3 CCAs is allowed per student.");
		}
	}


	//================================= Category Part ====================================\\

	public static void addCategory(ArrayList<String> categoryList) {
		String category = Helper.readString("Enter new category > ");
		categoryList.add(category);
	}

	public static String viewCategory(ArrayList<Cca> ccaList) {
		String category = Helper.readString("Enter category to view > ");
		String output = String.format("%-10s %-15s %-15s %-15s %-15s %-10s %-10s %-10s", "Title", "Description", "Class Size", "Day of CCA", "Time of CCA", "Venue", "Instructor In Charge", "Category");
		for (Cca i:ccaList) {
			if (i.getCategory().equalsIgnoreCase(category)) {
				output += String.format("\n%-10s %-15s %-15d %-15s %-15s %-10s %-10s %-10s", i.getCcaTitle(), i.getCcaDescription(), i.getClassSize(), i.getCcaDay(), i.getCcaTime(), i.getCcaVenue(), i.getInstructorInCharge(), i.getCategory());
			}
		}
		System.out.println(output);
		return output;
	}

	public static void deleteCategory(ArrayList<String> categoryList) {
		String category = Helper.readString("Enter category to delete");
		for (String i:categoryList) {
			if (i.equalsIgnoreCase(category)) {
				categoryList.remove(i);
			}
		}
	}

	//================================= Parent Part =================================\\

	public static void addParent(Student studentObject, String parentName, String parentEmail, int parentContact, ArrayList<Parent> parentList, ArrayList<Parent> updatedParentList, int ccaID) {
		int size = parentList.size();
		
		if (isValidEmail(parentEmail)) {//check the parentEmail
			parentList.add(new Parent(studentObject.getStudentID(), studentObject.getStudentName(), studentObject.getGrade(), studentObject.getClassID(), studentObject.getTeacherName(), studentObject.getStudentCCA(), parentName, parentEmail, parentContact));
			if (parentList.size() == size+1) {
				ccaID = generateCCAID(updatedParentList);

				updatedParentList.add(new Parent(studentObject.getStudentID(), studentObject.getStudentName(), studentObject.getGrade(), studentObject.getClassID(), studentObject.getTeacherName(), studentObject.getStudentCCA(), parentName, parentEmail, parentContact, ccaID));
				System.out.println(updatedParentList.get(0).getCCAID());
				System.out.println(updatedParentList.get(0));
				System.out.println("Successfully registered!");
				System.out.println("CCA ID: " + ccaID);
			}
			else {
				System.out.println("Failed to register!");
			}
		}
		else {
			System.out.println("Failed to register!");
		}
	}

	public static String viewParent(ArrayList<Parent> parentList) {
		String output = String.format("%-10s %-20s %-5s %-10s %-20s %-20s %-20s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		for (Parent p: parentList) {
			output += String.format("%-10s %-20s %-5s %-10s %-20s %-20s %-20s %-10d\n", p.getStudentID(), p.getStudentName(), p.getGrade(), p.getClassID(), p.getTeacherName(), p.getParentName(), p.getParentEmail(), p.getParentContact());
		}
		return output;
	}

	public static void deleteParent(int ccaID, String studentID, ArrayList<Parent> updatedParentList, ArrayList<Parent> parentList) {
		for (int i=0;i<updatedParentList.size();i++) {//updatedParentList has elements inside
			if (updatedParentList.get(i).getStudentID().equals(studentID) && updatedParentList.get(i).getCCAID() == ccaID){
				updatedParentList.remove(i);
			}
		}

		for (int i=0;i<parentList.size();i++) {
			if (parentList.get(i).getStudentID().equals(studentID)){
				parentList.remove(i);
			}
		}
	}

	public static void updateParent(int ccaID, String parentName, String parentEmail, int parentContact, ArrayList<Parent> parentList, ArrayList<Parent> updatedParentList) {		
		int counter = 0;
		for (int i=0;i<updatedParentList.size();i++) {
			if (updatedParentList.get(i).getCCAID() == ccaID) {
				updatedParentList.get(i).setParentContact(parentContact);
				updatedParentList.get(i).setParentEmail(parentEmail);
				updatedParentList.get(i).setParentName(parentName);
				counter = i;
			}
		}

		parentList.get(counter).setParentContact(parentContact);
		parentList.get(counter).setParentEmail(parentEmail);
		parentList.get(counter).setParentName(parentName);
		
		System.out.println("Successfully updated");
	}

	public static boolean isValidEmail(String parentEmail) {
		if (parentEmail.contains("@")) {
			return true;
		}
		else {
			return false;
		}
	}

	public static int generateCCAID(ArrayList<Parent> updatedParentList) {
		String ccaID = "";
		Random number = new Random();
		boolean again = true;

		ccaID += Integer.toString(number.nextInt(10));
		while (ccaID.contains("0")) {//check if the cca id start with 0
			ccaID = "";
			ccaID += Integer.toString(number.nextInt(10));
		}

		for (int i=0;i<8;i++) {//create rest of the cca id
			ccaID += Integer.toString(number.nextInt(10));
		}

		while (again != false) {
			again = false;
			for (Parent i:updatedParentList) {
				if (i.getCCAID() != Integer.parseInt(ccaID)) {

				}
				else {
					ccaID = "";
					ccaID += Integer.toString(number.nextInt(10));
					while (ccaID.contains("0")) {//check if the cca id start with 0
						ccaID = "";
						ccaID += Integer.toString(number.nextInt(10));
					}

					for (int j=0;j<8;j++) {//create rest of the cca id
						ccaID += Integer.toString(number.nextInt(10));
					}
					again = true;
				}
			}
		}

		return Integer.parseInt(ccaID);
	}

	//================================= Login Part =================================\\
	public static boolean loginsystem() {
		Boolean login = true;
		String studentid = Helper.readString("Enter the student ID >");
		int ccaid = Helper.readInt("Enter the CCA Registration ID > ");
		for (int i=0; i<parentList.size(); i++) {
			if (studentid.equalsIgnoreCase(parentList.get(i).getStudentID())) {
				if (ccaid == ccaID) {
					System.out.println("Successfully Login!");
				} else {
					System.out.println("Invalid CCA Registration ID!");
					login = false;
				}
			} else {
				System.out.println("Invalid Student ID entered!");
				login = false;
			}
		}
		return login;
	}
	public static void addStudentforCCA() {
		String studentid = Helper.readString("Enter the student ID >");
		checkCcaPolicies(studentid);
		String studentCCA = Helper.readString("Enter in CCA choice> ");
		for (int i=0; i<studentList.size(); i++) {
			for (int x =0; x<parentList.size(); x++) {
				if (studentid.equalsIgnoreCase(parentList.get(x).getStudentID())) {
					if (parentList.get(x).getStudentID().equalsIgnoreCase(studentList.get(i).getStudentID())) {
						studentList.get(i).setStudentCCA(studentCCA);
						int output = studentList.get(i).getCCANO();
						String[] ccano  = studentCCA.split(",");
						output = output + ccano.length;
						studentList.get(i).setCCANO(output);
						System.out.println(output);
					}
				}
			}
			
		}
	}
	public static void viewStudentRegCCA() {
		String output = String.format("%-12s %-15s %-5s %-10s %-10s %-10s %-10s", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Student CCA", "No of CCA");
		for (int i=0; i<studentList.size(); i++) {
			if(!studentList.get(i).getStudentCCA().equalsIgnoreCase("N/A")) {
				output += String.format("\n%-12s %-15s %-5s %-10s %-10s %-10s %-10d", studentList.get(i).getStudentID(), studentList.get(i).getStudentName(), studentList.get(i).getGrade(), studentList.get(i).getClassID(), 
						studentList.get(i).getTeacherName(), studentList.get(i).getStudentCCA(), studentList.get(i).getCCANO());
			}
			System.out.println(output);
		}
	}
}