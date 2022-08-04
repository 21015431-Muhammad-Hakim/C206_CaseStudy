import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Student student = new Student ("", "", "", "", "", "");
	private Student student2  = new Student ("", "", "", "", "", "");
	
	private Cca cca1 = new Cca("", "", 0, "", "", "", "", "");
	private Cca cca2 = new Cca("", "", 0, "", "", "", "", "");
	
	private String ccaTitle = "";
	private String ccaDescription = "";
	private int classSize = 0;
	private String ccaDay = "";
	private String ccaTime = "";
	private String ccaVenue = "";
	private String instructorInCharge = "";
	
	private String studentID = "";
	private String studentName = "";
	private String studentGrade = "";
	private String studentClass = "";
	private String studentTeacher = "";
	private String studentCCA = "";
	
	private String studentID1 = "";
	private String studentName1 = "";
	private String studentGrade1 = "";
	private String studentClass1 = "";
	private String studentTeacher1 = "";
	private String studentCCA1 = "";
	
	private String parentName = "";
	private String parentName2 = "";
	private String parentEmail = "";
	private String parentEmail2 = "";
	
	private String category = "";
	private String category2 = "";
	
	private int contact = 0;
	private int contact2 = 0;
	private Parent parent = new Parent(student, "", "", 0);
	private Parent parent2 = new Parent(student, "", "", 0);
	private int ccaID = 0;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Parent> parentList = new ArrayList<Parent>();
	private ArrayList<Parent> updatedParentList = new ArrayList<Parent>();
	private static ArrayList<Cca> ccaList = new ArrayList<Cca>();
	
	@Before
	public void setUp() throws Exception {
		studentID = "A0000";
		studentName = "John";
		studentGrade = "P6";
		studentClass = "6A";
		studentTeacher = "Mary";
		studentCCA = "Basketball";
		
		studentID1 = "A1000";
		studentName1 = "Johns";
		studentGrade1 = "P5";
		studentClass1 = "5B";
		studentTeacher1 = "Marry";
		studentCCA1 = "Baseball";
		
		student = new Student(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA);
		student2 = new Student(studentID1, studentName1, studentGrade1, studentClass1, studentTeacher1, studentCCA1);
		
		parentName = "Jackson";
		parentName2 = "Jacksons";
		parentEmail = "Jackson@gmail.com";
		parentEmail2 = "Jacksons@gmail.com";
		
		contact = 12345678;
		contact2 = 12345679;
		
		parent = new Parent(student, parentName, parentEmail, contact);
		parent2 = new Parent(student2, parentName2, parentEmail2, contact2);
		ccaID = 12345678;		
		
		category = "Basketball";
		category2 = "Badminton";
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddStudent() {
		//test if the student is added into arraylist
		
		studentList.clear(); //start the test without external factor
		studentList.add(student);
		studentList.add(student2);
		
		//Check if new students can be detected
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, studentList);
		
		//Check the size of the arrayList
		assertEquals("Check that student arraylist size is 3", 3, studentList.size());
	}
	@Test
	public void testViewStudent() {
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, studentList);
		String output = C206_CaseStudy.viewStudent(studentList);
		String testOutput = String.format("%-12s %-15s %-5s %-10s %-10s %-10s", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Student CCA");
		testOutput += String.format("\n%-12s %-15s %-5s %-10s %-10s %-10s", studentList.get(0).getStudentID(), studentList.get(0).getStudentName(), studentList.get(0).getGrade(), studentList.get(0).getClassID(), studentList.get(0).getTeacherName(), studentList.get(0).getStudentCCA());
		
		assertEquals("Check that ViewAllStudentList", testOutput, output); //Check if the output is the same as testOutput
	}
	@Test
	public void testDeleteStudent() {
		studentList.clear();
		C206_CaseStudy.addStudent(studentID, studentName, studentGrade, studentClass, studentTeacher, studentCCA, studentList);
		C206_CaseStudy.deleteStudent(studentID, studentList);
		assertEquals(studentList.size(), 0); //Check the size of the arrayList
		
	}
	
	@Test
	public void testAddCca() {
		
		ccaList.clear();
		ccaList.add(cca1);
		
		//Check if new cca can be detected
		C206_CaseStudy.addCca(ccaTitle, ccaDescription, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, category, ccaList);
		assertEquals("Check that student arraylist size is 2", 2, ccaList.size()); //Check the size of the arrayList
	
	}
	
	@Test
	public void testViewAllCca() {
		ccaList.clear(); //start the test without external factor
		
		C206_CaseStudy.addCca(ccaTitle, ccaDescription, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, category, ccaList); //Add object into arrayList
		String output = C206_CaseStudy.viewAllCca(ccaList);
		String testOutput = String.format("%-10s %-15s %-15s %-15s %-15s %-10s %-10s", "Title", "Description", "Class Size", "Day of CCA", "Time of CCA", "Venue", "Instructor In Charge");
		testOutput += String.format("\n%-10s %-15s %-15d %-15s %-15s %-10s %-10s", ccaList.get(0).getCcaTitle(), ccaList.get(0).getCcaDescription(), ccaList.get(0).getClassSize(), ccaList.get(0).getCcaDay(), ccaList.get(0).getCcaTime(), ccaList.get(0).getCcaVenue(), ccaList.get(0).getInstructorInCharge());

		assertEquals("Check that ViewAllCcaList", testOutput, output); //Check if the output is the same as testOutput
		 
	}
	
	@Test
	public void testDeleteCca() {
		
		ccaList.clear();
		C206_CaseStudy.addCca(ccaTitle, ccaDescription, classSize, ccaDay, ccaTime, ccaVenue, instructorInCharge, category, ccaList);
		C206_CaseStudy.deleteCca(ccaTitle, ccaList);
		assertEquals(ccaList.size(), 0); //Check the size of the arrayList
	}
	
	
	@Test
	public void testAddParent() {
		//test if the parent is added into arraylist
		parentList.clear();
		parentList.add(parent);//0
		parentList.add(parent2);//1
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//2
		assertEquals(parentList.get(0).getStudentID(), parentList.get(2).getStudentID());
		assertEquals(parentList.get(0).getStudentName(), parentList.get(2).getStudentName());
		assertEquals(parentList.get(0).getGrade(), parentList.get(2).getGrade());
		assertEquals(parentList.get(0).getClassID(), parentList.get(2).getClassID());
		assertEquals(parentList.get(0).getTeacherName(), parentList.get(2).getTeacherName());
		assertEquals(parentList.get(0).getParentName(), parentList.get(2).getParentName());
		assertEquals(parentList.get(0).getParentEmail(), parentList.get(2).getParentEmail());
		assertEquals(parentList.get(0).getParentContact(), parentList.get(2).getParentContact());
	}
	
	@Test
	public void testViewParent() {
		//test if the output is printed correctly
		parentList.clear();
		C206_CaseStudy.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);
		String output = C206_CaseStudy.viewParent(parentList);
		String testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10d\n", parentList.get(0).getStudentObject().getStudentID(), parentList.get(0).getStudentObject().getStudentName(), parentList.get(0).getStudentObject().getGrade(), parentList.get(0).getStudentObject().getClassID(), parentList.get(0).getStudentObject().getTeacherName(), parentList.get(0).getParentName(), parentList.get(0).getParentEmail(), parentList.get(0).getParentContact());
		assertEquals(testOutput, output);
		
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

	@After
	public void tearDown() throws Exception {
	}
}
