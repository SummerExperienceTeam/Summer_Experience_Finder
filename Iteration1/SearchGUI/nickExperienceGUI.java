

/**
 * Experience class will be the search-able object for our 
 * @author Nick
 *
 */
public class nickExperienceGUI 
{
	/**
	 * This class is just a different version of our usual experience class.
	 * to avoid compatibility issues, this one is instanciated for Nick's GUI.
	 * @author Nick
	 *
	 */
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
	private boolean international;
	private boolean internship;
	private String organization;
	private String state;
	private String city;
	private String natureOfWork;
	private String addtionalInformation;
	private int hoursPerWeek;
	private StudentStanding standing;
	private CompensationType compensation;
	private MainActivity activity;
	
	public nickExperienceGUI(boolean international, boolean internship, String organization, String state, String city,
			String natureOfWork, String addtionalInformation, int hoursPerWeek, StudentStanding standing,
			CompensationType compensation, MainActivity activity) {

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

	public String getStandingString()
	{
		return this.standing.name();
	}
	
	public String getCompensationString()
	{
		return this.compensation.name();
	}
	
	public String getActivityString()
	{
		return this.activity.name();
	}
	
	public boolean isInternational() {
		return international;
	}

	public boolean isInternship() {
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

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public StudentStanding getStanding() {
		return standing;
	}

	public CompensationType getCompensation() {
		return compensation;
	}

	public MainActivity getActivity() {
		return activity;
	}
	
	public String toString()
	{
		String intl = "";
		String intern = "";
		if(international == true)
		{
			intl = "International, ";
		}
		if(internship == true)
		{
			intl = "Internship, ";
		}

			
		String configuredData = intl+intern+ organization+ ", "+ getActivityString() +", " + state + ", " + city + ", " 
		+ natureOfWork + ", " + "Comments:"+ addtionalInformation + ", " + getStandingString() + ", " + getCompensationString();
		
		
		return configuredData;
		
	}
}
