/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * USER, 31 Jul 2022 12:15:52 pm
 */

/**
 * @author USER
 *
 */


public class Cca {

	private String ccaTitle;
	private String ccaDescription;
	private int classSize;
	private String ccaDay;
	private String ccaTime;
	private String ccaVenue;
	private String instructorInCharge;
	private String category;
	
	public Cca(String ccaTitle, String ccaDescription, int classSize, String ccaDay, String ccaTime, String ccaVenue, String instructorInCharge, String category) {
		
		this.ccaTitle = ccaTitle;
		this.ccaDescription = ccaDescription;
		this.classSize = classSize;
		this.ccaDay = ccaDay;
		this.ccaTime = ccaTime;
		this.ccaVenue = ccaVenue;
		this.instructorInCharge = instructorInCharge;
		this.category = category;
	}

	public String getCcaTitle() {
		return ccaTitle;
	}

	public String getCcaDescription() {
		return ccaDescription;
	}

	public int getClassSize() {
		return classSize;
	}

	public String getCcaDay() {
		return ccaDay;
	}

	public String getCcaTime() {
		return ccaTime;
	}

	public String getCcaVenue() {
		return ccaVenue;
	}

	public String getInstructorInCharge() {
		return instructorInCharge;
	}
	
	public String getCategory() {
		return category;
	}
	
	
 
}
