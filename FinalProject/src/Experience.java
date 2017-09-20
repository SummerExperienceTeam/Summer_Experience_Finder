
/**
 * Experience class has all of the different experiences and their attributes 
 * it mostly consists from getters and setters
 *
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
	
	private String year;
	private String international;
	private String internship;
	private String organization;
	private String state;
	private String city;
	private String industry;
	private String hoursPerWeek;
	private String compensation;
	
	public Experience(String year, String international, String internship, String organization, String state,
			String city,  String natureOfWork, String hoursPerWeek,
			String compensation) 
	{
		this.year = year;
		this.international = international;
		this.internship = internship;
		this.organization = organization;
		this.state = state;
		this.city = city;
		this.industry = natureOfWork;
		this.hoursPerWeek = hoursPerWeek;
		this.compensation = compensation;
	}

	public String getYear() {
		return year;
	}

	public String getInternational() {
		return international;
	}

	public String getInternship() {
		return internship;
	}

	public String getOrganization() {
		return organization;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getIndustry() {
		return industry;
	}

	public String getHoursPerWeek() {
		return hoursPerWeek;
	}

	public String getCompensation() {
		return compensation;
	}

}