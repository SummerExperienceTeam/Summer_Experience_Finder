
/**
 * Experience class will be the search-able object for our 
 * @author Nick
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
	private String addtionalInformation;
	private String hoursPerWeek;
	private String standing;
	private String compensation;
	private String activity;
	
	public Experience(String international, String internship, String organization, String state, String city,
			String natureOfWork, String addtionalInformation, String hoursPerWeek, String standing,
			String compensation, String activity) {
		super();
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
		return standing;
	}
	
	public String getCompensationString()
	{
		return compensation;
	}
	
	public String getActivityString()
	{
		return activity;
	}
	
	public boolean isInternational() 
	{
		if(international.equals("No"))
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	public boolean isInternship() 
	{
		if(internship.equals("No"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public String getOrganization()
	{
		return organization;
	}

	public String getState()
	{
		return state;
	}
	
	public String getCity()
	{
		return city;
	}

	public String getNatureOfWork() 
	{
		return natureOfWork;
	}

	public String getAddtionalInformation() 
	{
		return addtionalInformation;
	}

	public String getHoursPerWeek()
	{
		return hoursPerWeek;
	}

		public String toString()
	{
		String intl = "";
		String intern = "";
		if(international.equals("No"))
		{
			intl = "International, ";
		}
		if(internship.equals("Yes"))
		{
			intl = "Internship, ";
		}

			
		String configuredData = intl+intern+ organization+ ", "+ getActivityString() +", " + state + ", " + city + ", " 
		+ natureOfWork + ", " + "Comments:"+ addtionalInformation + ", " + getStandingString() + ", " + getCompensationString();
		
		
		return configuredData;
		
	}
}
