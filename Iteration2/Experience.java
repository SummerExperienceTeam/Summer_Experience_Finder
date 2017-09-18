
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
	private String international;
	private String internship;
	private String organization;
	private String state;
	private String city;
	private String natureOfWork;
	private String hoursPerWeek;
	private String standing;
	private String compensation;
	private String activity;
	
	public Experience(String standing, String isInternational, String isInternship, String organization, String state, String natureOfWork, String hoursPerWeek, String compensation, String activity) 
	{
		this.international = isInternational;
		this.internship = isInternship;
		this.organization = organization;
		this.state = state;
		this.natureOfWork = natureOfWork;
		this.hoursPerWeek = hoursPerWeek;
		this.standing = standing;
		this.compensation = compensation;
		this.activity = activity;
	}

	public String getIsInternational() {
		return international;
	}

	public String getIsInternship() {
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

	public String getNatureOfWork() {
		return natureOfWork;
	}

	public String getHoursPerWeek() {
		return hoursPerWeek;
	}

	public String getStanding() {
		return standing;
	}

	public String getCompensation() {
		return compensation;
	}

	public String getActivity() {
		return activity;
	}
	
	public String toString()
	{
		String intl = "";
		String intern = "";
		if(international.equals("Yes"))
		{
			intl = "International, ";
		}
		if(internship.equals("Yes"))
		{
			intl = "Internship, ";
		}

			
		String configuredData = intl+intern+ organization+ ", "+ activity +", " + state + ", " + city + ", " 
		+ natureOfWork + ", " + "Comments:" + ", " + standing + ", " + compensation;
		
		
		return configuredData;
		
	}

}
