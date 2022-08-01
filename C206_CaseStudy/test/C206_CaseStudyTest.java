import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Student student;
	private Student student2;
	private String parentName;
	private String parentName2;
	private String parentEmail;
	private String parentEmail2;
	private int contact = 0;
	private int contact2 = 0;
	private Parent parent;
	private Parent parent2;
	private int ccaID = 0;
	private C206_CaseStudy object = new C206_CaseStudy();
	private ArrayList<Parent> parentList = new ArrayList<Parent>();
	private ArrayList<Parent> updatedParentList = new ArrayList<Parent>();
	
	@Before
	public void setUp() throws Exception {
		student = new Student("S1", "John", "A1", "W2-E", "Mary");
		student2 = new Student("S2", "Johns", "A2", "W2_A", "Marry");
		parentName = "Jackson";
		parentName2 = "Jacksons";
		parentEmail = "Jackson@gmail.com";
		parentEmail = "Jacksons@gmail.com";
		contact = 12345678;
		contact2 = 12345679;
		parent = new Parent(student, parentName, parentEmail, contact);
		parent2 = new Parent(student2, parentName2, parentEmail2, contact2);
		ccaID = 12345678;

		
		
	}



	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddParent() {
		//test if the parent is added into arraylist
		parentList.clear();
		parentList.add(parent);//0
		parentList.add(parent2);//1
		object.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//2
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
		parentList.add(parent);//0
		parentList.add(parent2);//1
		object.addParent(student, parentName, parentEmail, contact, parentList, updatedParentList, ccaID);//2
		String output = object.viewParent();
		String testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "Student ID", "Student Name", "Grade", "Class ID", "Teacher name", "Parent Name", "Parent Email", "Parent contact");
		testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10d\n", parentList.get(2).getStudentID(), parentList.get(2).getStudentName(), parentList.get(2).getGrade(), parentList.get(2).getClassID(), parentList.get(2).getTeacherName(), parentList.get(2).getParentName(), parentList.get(2).getParentEmail(), parentList.get(2).getParentContact());
		assertEquals(testOutput, output);
		
	}

	@After
	public void tearDown() throws Exception {
	}
}
