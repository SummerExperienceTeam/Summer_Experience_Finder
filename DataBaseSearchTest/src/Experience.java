
/**
 * Experience class has all of the different experiences and their attributes 
 * it mostly consists from getters and setters
 * @author Jacob and Pietro
 */
public class Experience 
{
	public enum StudentStanding
	{
		SOPHMORE, JUNIOR, SENIOR
	}
	public enum CompensationType
	{
		UNPAID,HOURLY,STIPEND
	}
	public enum MainActivity
	{
		CCBLOCK, MUSIC, TIMEOFFTRAVELING, STUDYABROAD, SUMMERJOB, 
		CLASSOTHERINSTITUTION, RESEARCH, VOLUNTEERING
		
	}
	private String classStanding;
	private String isInternational;
	private String isInternship;
	private String Organization;
	private String state;
	private String city;
	private String natureOfWork;
	private String hoursPerWeek;
	private String compensation;

	public Experience(String classStanding, String isInternational, String isInternship, String Organization, String state,
			String city, String natureOfWork, String hoursPerWeek, String compensation) 
	{
		this.classStanding = classStanding;
		this.isInternational = isInternational;
		this.isInternship = isInternship;
		this.state = state;
		this.city = city;
		this.natureOfWork = natureOfWork;
		this.hoursPerWeek = hoursPerWeek;
		this.compensation = compensation;
		this.compensation = compensation;
		
	}

	public String getClassStanding() {
		return classStanding;
	}

	public void setClassStanding(String classStanding) {
		this.classStanding = classStanding;
	}

	public String getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(String isInternational) {
		this.isInternational = isInternational;
	}

	public String getIsInternship() {
		return isInternship;
	}

	public void setIsInternship(String isInternship) {
		this.isInternship = isInternship;
	}

	public String getOrganization() {
		return Organization;
	}

	public void setOrganization(String organization) {
		Organization = organization;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNatureOfWork() {
		return natureOfWork;
	}

	public void setNatureOfWork(String natureOfWork) {
		this.natureOfWork = natureOfWork;
	}

	public String getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(String hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public String getCompensation() {
		return compensation;
	}

	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	
		

}
