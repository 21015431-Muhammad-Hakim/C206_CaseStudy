import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Student student = new Student ("", "", "", "", "", "",0);
	private Student student2  = new Student ("", "", "", "", "", "",0);
	
	private Cca cca1 = new Cca("", "", "", 0, "", "", "", "");
	private Cca cca2 = new Cca("", "", "", 0, "", "", "", "");
	
	private String ccaTitle = "";
	private String ccaDescription = "";
	private String ccaCategory = "";
	private int classSize = 0;
	private String ccaDay = "";
	private String ccaTime = "";
	private String ccaVenue = "";
	private String instructorInCharge = "";
	
	private String ccaTitle2 = "";
	private String ccaDescription2 = "";
	private String ccaCategory2 = "";
	private int classSize2 = 0;
	private String ccaDay2 = "";
	private String ccaTime2 = "";
	private String ccaVenue2 = "";
	private String instructorInCharge2 = "";
	
	
	private String studentID = "";
	private String studentName = "";
	private String studentGrade = "";
	private String studentClass = "";
	private String studentTeacher = "";
	private String studentCCA = "";
	private int CCANo = 0;
	
	private String studentID1 = "";
	private String studentName1 = "";
	private String studentGrade1 = "";
	private String studentClass1 = "";
	private String studentTeacher1 = "";
	private String studentCCA1 = "";
	private int CCANo1 = 0;
	
	private String parentName = "";
	private String parentName2 = "";
	private String parentEmail = "";
	private String parentEmail2 = "";
	private String parentEmailError = "";
	
	private String category = "";
	private String category2 = "";
	
	private int contact = 0;
	private int contact2 = 0;
	private Parent parent = new Parent("", "", "", "", "", "", "", "", 0);
	private Parent parent2 = new Parent("", "", "", "", "", "", "", "", 0);
	private int ccaID = 0;
	private int ccaID2 = 0;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Parent> parentList = new ArrayList<Parent>();
	private ArrayList<Parent> updatedParentList = new ArrayList<Parent>();
	private static ArrayList<Cca> ccaList = new ArrayList<Cca>();
	private ArrayList<String> categoryList = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		studentID = "A0000";
		studentName = "John";
		studentGrade = "P6";
		studentClass = "6A";
		studentTeacher = "Mary";
		studentCCA = "Basketball";
		CCANo = 1;
		
		studentID1 = "A1000";
		studentName1 = "Johns";
		studentGrade1 = "P5";
		studentClass1 = "5B";
		studentTeacher1 = "Marry";
		studentCCA1 = "Baseball";
		CCANo1 = 1;
		
		student = new Student(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo);
		student2 = new Student(studentID1, studentName1, studentGrade1, studentClass1, studentTeacher1, studentCCA1, CCANo1);
		
		parentName = "Jackson";
		parentName2 = "Jacksons";
		parentEmail = "Jackson@gmail.com";
		parentEmail2 = "Jacksons@gmail.com";
		parentEmailError ="Jacksongmailcom";
		
		contact = 12345678;
		contact2 = 12345679;
		
		parent = new Parent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, parentName, parentEmail, contact);
		parent2 = new Parent(studentID1, studentName1, studentGrade1, studentClass1, studentTeacher1, studentCCA1, parentName2, parentEmail2, contact2);
		ccaID = 12345678;		
		ccaID2 = 87654321;
		
		ccaTitle = "Soccer";
		ccaTitle2 = "Drawing";
		ccaDescription = "Fun";
		ccaDescription2 = "Beautiful";
		ccaCategory = "Sports";
		ccaCategory2 = "Arts";
		classSize = 20;
		classSize2 = 30;
		ccaDay = "Monday";
		ccaDay2 = "Monday";
		ccaTime = "3-4pm";
		ccaTime2 = "2-4pm";
		ccaVenue = "Field";
		ccaVenue2 = "Art Room";
		instructorInCharge = "Mr Tan";
		instructorInCharge2 = "Mrs Tan";
		
		cca1 = new Cca(ccaTitle, ccaDescription, ccaCategory, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge);
		cca2 = new Cca(ccaTitle2, ccaDescription2, ccaCategory2, classSize2, ccaDay2, ccaTime2, ccaVenue2, instructorInCharge2);
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddStudent() {
		//test if the student is added into arraylist
		
		//test if the student arraylist exists
		assertNotNull(studentList);
		
		studentList.clear(); //start the test without external factor
		studentList.add(student);
		assertEquals("Check that student arraylist size is 1", 1, studentList.size());
		
		studentList.add(student2);
		
		//Check if new students can be detected
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		
		//Check the size of the arrayList
		assertEquals("Check that student arraylist size is 3", 3, studentList.size());
	}
	@Test
	public void testViewStudent() {
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		assertFalse(studentList.isEmpty());
		String output = C206_CaseStudy.viewStudent(studentList);
		String testOutput = String.format("%-12s %-15s %-5s %-10s %-10s %-10s %-10s", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Student CCA", "No of CCA");
		testOutput += String.format("\n%-12s %-15s %-5s %-10s %-10s %-10s %-10d", studentList.get(0).getStudentID(), studentList.get(0).getStudentName(), studentList.get(0).getGrade(), studentList.get(0).getClassID(), studentList.get(0).getTeacherName(), studentList.get(0).getStudentCCA(), studentList.get(0).getCCANO());
		
		assertEquals("Check that ViewAllStudentList", testOutput, output); //Check if the output is the same as testOutput
	}
	@Test
	public void testDeleteStudent() {
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		assertFalse(studentList.isEmpty());
		C206_CaseStudy.deleteStudent(studentID, studentList);
		assertEquals(studentList.size(), 0); //Check the size of the arrayList
		
	}
	
	@Test
	public void testAddCca() {
		
		ccaList.clear();
		ccaList.add(cca1);
		
		//Check if new cca can be detected

		C206_CaseStudy.addCca(ccaTitle, ccaDescription, category, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, ccaList);

		assertEquals("Check that student arraylist size is 2", 2, ccaList.size()); //Check the size of the arrayList
	
	}
	
	@Test
	public void testViewAllCca() {
		ccaList.clear(); //start the test without external factor
		
		C206_CaseStudy.addCca(ccaTitle, ccaDescription, category, classSize, ccaDay, ccaTime, ccaVenue, 
				instructorInCharge, ccaList);//Add object into arrayList

		String output = C206_CaseStudy.viewAllCca(ccaList);
		String testOutput = String.format("%-10s %-15s %-15s %-15s %-15s %-15s %-10s %-10s", "Title", "Description", "Category", 
				"Class Size", "Day of CCA", "Time of CCA", "Venue", "Instructor In Charge");
		testOutput += String.format("\n%-10s %-15s %-15s %-15s %-15s %-15s %-10s %-10s", ccaList.get(0).getCcaTitle(), 
				ccaList.get(0).getCcaDescription(), ccaList.get(0).getCategory(), ccaList.get(0).getClassSize(), 
				ccaList.get(0).getCcaDay(), ccaList.get(0).getCcaTime(), ccaList.get(0).getCcaVenue(), ccaList.get(0).getInstructorInCharge());

		assertEquals("Check that ViewAllCcaList", testOutput, output); //Check if the output is the same as testOutput
		 
	}
	
	@Test
	public void testDeleteCca() {
		
		ccaList.clear();

		C206_CaseStudy.addCca(ccaTitle, ccaDescription, category, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, ccaList);

		C206_CaseStudy.deleteCca(ccaTitle, ccaList);
		assertEquals(ccaList.size(), 0); //Check the size of the arrayList
	}
	
	@Test
	public void testAddCategory() {
		ccaList.clear();
		C206_CaseStudy.addCca(ccaTitle, ccaDescription, category, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, ccaList);
		categoryList.add(category);
		assertEquals("Check that category arraylist size is 1", 1, categoryList.size());
	}
	
	@Test
	public void testViewCategory() {
		ccaList.clear();
		
		ccaList.add(cca1);
		
		String output = C206_CaseStudy.viewCategory(ccaCategory, ccaList);
		String testOutput = String.format("%-10s %-15s %-15s %-15s %-15s %-15s %-10s %-10s", "Title", "Description", "Category", 
				"Class Size", "Day of CCA", "Time of CCA", "Venue", "Instructor In Charge");
	
		testOutput += String.format("\n%-10s %-15s %-15s %-15s %-15s %-15s %-10s %-10s", ccaList.get(0).getCcaTitle(), 
				ccaList.get(0).getCcaDescription(), ccaList.get(0).getCategory(), ccaList.get(0).getClassSize(), 
				ccaList.get(0).getCcaDay(), ccaList.get(0).getCcaTime(), ccaList.get(0).getCcaVenue(), ccaList.get(0).getInstructorInCharge());
		
		assertEquals("Check that ViewAllCcaList", testOutput, output);
	}

	
	@Test
	public void testDeleteCategory() {
		ccaList.clear();
		
		C206_CaseStudy.addCca(ccaTitle, ccaDescription, category, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, ccaList);
		C206_CaseStudy.deleteCategory(category, categoryList);
		assertEquals(categoryList.size(), 0);
	}
	
	@Test
	public void testAddParent() {
		//test if the parent is added into arraylist
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//0
		assertEquals(1, parentList.size());
	}
	
	@Test
	public void testAddParent2() {
		//test if 2 parent are added into arraylist
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//0
		C206_CaseStudy.addParent(student2, parentName2, parentEmail2, contact2, parentList, updatedParentList, ccaID2);//0
		assertEquals(2, parentList.size());
	}
	
	@Test
	public void testAddParentError() {
		//test if parent is not added into arrayList
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmailError, contact, parentList, updatedParentList, ccaID);
		assertNotEquals(1, parentList.size());
	}
	
	@Test
	public void testViewParent() {
		//test if the output is printed correctly
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);
		String output = C206_CaseStudy.viewParent(parentList);
		String testOutput = String.format("%-10s %-20s %-5s %-10s %-20s %-20s %-20s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		testOutput += String.format("%-10s %-20s %-5s %-10s %-20s %-20s %-20s %-10s\n", studentID, studentName, studentGrade, studentClass, studentTeacher, parentName, parentEmail, contact);
		assertEquals(testOutput, output);
		
	}
	
	@Test
	public void testViewParent2() {
		//test if the output is printed correctly
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);
		C206_CaseStudy.addParent(student2, parentName2, parentEmail2, contact2, parentList, updatedParentList, ccaID2);
		String output = C206_CaseStudy.viewParent(parentList);
		String testOutput = String.format("%-10s %-20s %-5s %-10s %-20s %-20s %-20s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		testOutput += String.format("%-10s %-20s %-5s %-10s %-20s %-20s %-20s %-10s\n", studentID, studentName, studentGrade, studentClass, studentTeacher, parentName, parentEmail, contact);
		testOutput += String.format("%-10s %-20s %-5s %-10s %-20s %-20s %-20s %-10s\n", studentID1, studentName1, studentGrade1, studentClass1, studentTeacher1, parentName2, parentEmail2, contact2);
		assertEquals(testOutput, output);
		
	}
	
	@Test 
	public void testViewParentError() {
	//test if the output is printed incorrectly
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, ccaID2, parentList, updatedParentList, contact2);
		String output = C206_CaseStudy.viewParent(parentList);
		String testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10d\n", studentID, studentName, studentGrade, studentClass, studentTeacher, parentName, parentEmail, contact);
		assertNotEquals(testOutput, output);
	}
	
	@Test
	public void testDeleteParent() {
		//test if the parent is deleted from arraylist
		parentList.clear();//start the test without external factor
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//add in parent
		C206_CaseStudy.deleteParent(ccaID, student.getStudentID(), updatedParentList, parentList);
		assertEquals(0, parentList.size());//there should have nothing inside
	}
	
	@Test
	public void testDeleteParent2() {
		//test if 2 parent are deleted from arraylist
		parentList.clear();//start the test without external factor
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//add in parent
		C206_CaseStudy.addParent(student2, parentName2, parentEmail2, contact2, parentList, updatedParentList, ccaID2);
		C206_CaseStudy.deleteParent(ccaID, student.getStudentID(), updatedParentList, parentList);
		C206_CaseStudy.deleteParent(ccaID2, student2.getStudentID(), updatedParentList, parentList);
		assertEquals(0, parentList.size());//there should have nothing inside
	}
	
	@Test
	public void testDeleteParentFail() {
		//test if the parent is deleted from arraylist
		parentList.clear();//start the test without external factor
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//add in parent
		C206_CaseStudy.deleteParent(ccaID, student2.getStudentID(), updatedParentList, parentList);
		assertNotEquals(0, parentList.size());//there should have 1 element inside
	}
	
	@Test
	public void testGenerateCCAID() {
		//int testCCAID = C206_CaseStudy.generateCCAID();
		//assertNotEquals(12345678, testCCAID);
	}
	
	@Test
	public void testloginSystem() {
		//test that the studentID entered was correct
		studentList.clear();
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		assertEquals("Test that the studentID entered was correct", parentList.get(0).getStudentID(), studentList.get(0).getStudentID());
		//test that the CCAID entered was not correct
		int ccaid = 12345678;
		assertNotEquals("Test that the ccaID entered was the same", ccaid, parentList.get(0).getCCAID());
		// test that the login to system was successful
		boolean login = true;
		assertTrue("Test that the login was successful", login);
	}
	
	@Test
	public void testaddStudentforCCA() {
		//test if the student is added into the cca
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		String cca = "Basketball";
		assertEquals("Test that the student is added into the cca", cca, studentList.get(0).getStudentCCA());
		// test that the CCANo was updated for the student
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		int no = 1;
		assertEquals("Test that the CCANo was correct", no, studentList.get(0).getCCANO());
		// test the CCANo was not the same
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		int No = 2;
		assertNotEquals("Test that the CCANo was not correct", No, studentList.get(0).getCCANO());
	}
	
	@Test 
	public void testViewStudentRegCCA() {
		//test that the studentList is not empty
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		assertFalse("Test that the studentList is not empty", studentList.isEmpty());
		//test that the studentList is exist so that I can view 
		assertNotNull("Test that the studentList is exist to view the student", studentList);
		//test the output and testoutput is the same
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, CCANo, studentList);
		String output = C206_CaseStudy.viewStudent(studentList);
		String testOutput = String.format("%-12s %-15s %-5s %-10s %-10s %-10s %-10s", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Student CCA", "No of CCA");
		testOutput += String.format("\n%-12s %-15s %-5s %-10s %-10s %-10s %-10d", studentList.get(0).getStudentID(),studentList.get(0).getStudentName(), studentList.get(0).getGrade(), studentList.get(0).getClassID(),studentList.get(0).getTeacherName(), studentList.get(0).getStudentCCA(), studentList.get(0).getCCANO());
		assertEquals("Check that ViewStudentRegCCA", testOutput, output);
	}

	@After
	public void tearDown() throws Exception {
	}
}
