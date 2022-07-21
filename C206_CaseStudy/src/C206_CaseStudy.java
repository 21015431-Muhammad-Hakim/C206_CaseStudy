import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	
	private ArrayList<Parent> parentList = new ArrayList<Parent>();
	private ArrayList<Parent> updatedParentList = new ArrayList<Parent>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static void menu() {
		
	}
		
	public void addParent(Student studentObject, String parentName, String parentEmail, String parentContact) {
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
	
	public void addParent(String studentID, String studentName, String grade, String classID, String teacherName, String parentName, String parentEmail, int parentContact) {
		if (parentList.add(new Parent(studentID, studentName, grade, classID, teacherName, parentName, parentEmail, parentContact))) {
			int ccaID = generateCCAID();
			
			for (int i=0;i<updatedParentList.size();i++) {
				if(updatedParentList.get(i).getCCAID() == ccaID) {//ensure no duplicated cca id
					ccaID = generateCCAID();
					i = 0;//restart to test if newly generated cca id is a duplicate
				}
			}
			updatedParentList.add(new Parent(parentList.get(parentList.size()-1), ccaID));
			
			System.out.println("CCA ID: " + ccaID);
			System.out.println("Successfully registered!");
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
