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
	private String category;
	private int classSize;
	private String ccaDay;
	private String ccaTime;
	private String ccaVenue;
	private String instructorInCharge;
	
	public Cca(String ccaTitle, String ccaDescription, String category, int classSize, String ccaDay, String ccaTime,String ccaVenue, String instructorInCharge) {
		
		this.ccaTitle = ccaTitle;
		this.ccaDescription = ccaDescription;
		this.category = category;
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

	public String getCategory() {
		return category;
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

	public void setCcaTitle(String ccaTitle) {
		this.ccaTitle = ccaTitle;
	}

	public void setCcaDescription(String ccaDescription) {
		this.ccaDescription = ccaDescription;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	public void setCcaDay(String ccaDay) {
		this.ccaDay = ccaDay;
	}

	public void setCcaTime(String ccaTime) {
		this.ccaTime = ccaTime;
	}

	public void setCcaVenue(String ccaVenue) {
		this.ccaVenue = ccaVenue;
	}

	public void setInstructorInCharge(String instructorInCharge) {
		this.instructorInCharge = instructorInCharge;
	}
	
	
	
}
