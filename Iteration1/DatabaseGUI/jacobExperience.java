
/**
 * Experience class will be the search-able object for our database in order
 * to instance the building blocks of "Experience" we will be searching.
 * @author Nick
 *
 */
public class jacobExperience 
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
	private String addtionalInformation;
	private String hoursPerWeek;
	private String standing;
	private String compensation;
	private String activity;
	
	public jacobExperience(String international, String internship, String organization, String state, String city,
			String natureOfWork, String addtionalInformation, String hoursPerWeek, String standing,
			String compensation, String activity) 
	{
		this.international = international;
		this.internship = internship;
		this.organization = organization;
		this.state = state;
		this.city = city;
		this.natureOfWork = natureOfWork;
		this.addtionalInformation = addtionalInformation;
		this.hoursPerWeek = hoursPerWeek;
		this.standing = standing;
		this.compensation = compensation;
		this.activity = activity;
	}

	public String isInternational() {
		return international;
	}

	public String isInternship() {
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

	public String getAddtionalInformation() {
		return addtionalInformation;
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
	

}
