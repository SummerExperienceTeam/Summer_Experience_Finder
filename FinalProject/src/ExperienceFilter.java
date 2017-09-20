import java.util.ArrayList;

public class ExperienceFilter {
	private static final String STATE_NOT_SELECTED = "Select State"; 
	private static final String INDUSTRY_NOT_SELECTED = "Select Industry"; 
	private static final String YEAR_NOT_SELECTED = "Select Year"; 
	private static final String HOURS_NOT_SELECTED = "Select Hours/Week"; 
	private static final String COMPENSATION_NOT_SELECTED = "Select Financial Compensation"; 
	private static final String INTERNATIONAL_NOT_SELECTED = "Not Selected"; 
	private static final String INTERNSHIP_NOT_SELECTED = "Not Selected";
	private String state;
	private String industry;
	private String year;
	private String hours;
	private String compensation;
	private String international;
	private String internship;
	
	ArrayList<Experience> allExperiences;
	
	public ExperienceFilter(ArrayList<Experience> allExperiences) {
		this.allExperiences = allExperiences;
	}
	
	public ArrayList<Experience> filterDB(Criteria criteria) {
		ArrayList<Experience> matchingExperiences = new ArrayList<Experience>();
		matchingExperiences.addAll(allExperiences);
		ArrayList<Experience> experiencesToRemove = new ArrayList<Experience>();
		state = criteria.getState();
		industry = criteria.getIndustry();
		year = criteria.getYear();
		hours = criteria.getHours();
		compensation = criteria.getCompensation();
		international = criteria.getInternational();
		internship = criteria.getInternship();
		int count = 0;
		for(Experience e : matchingExperiences) {
			if( !state.equals(STATE_NOT_SELECTED) && !state.equals(e.getState())) {
				count++;
				experiencesToRemove.add(e);
			} 
			else if( !industry.equals(INDUSTRY_NOT_SELECTED) && !industry.equals(e.getIndustry())) {
				experiencesToRemove.add(e);
			} 
			else if( !year.equals(YEAR_NOT_SELECTED) && !year.equals(e.getYear())) {
				experiencesToRemove.add(e);
			} 
			else if( !hours.equals(HOURS_NOT_SELECTED) && !hours.equals(e.getHoursPerWeek())) {
				experiencesToRemove.add(e);
			} 
			else if( !compensation.equals(COMPENSATION_NOT_SELECTED) && !compensation.equals(e.getCompensation())) {
				experiencesToRemove.add(e);
			} 
			else if( !international.equals(INTERNATIONAL_NOT_SELECTED) && !international.equals(e.getInternational())) {
				experiencesToRemove.add(e);
			} 
			else if( !internship.equals(INTERNSHIP_NOT_SELECTED) && !internship.equals(e.getInternship())) {
				experiencesToRemove.add(e);
			}
		}
		matchingExperiences.removeAll(experiencesToRemove);
		return matchingExperiences;
	}
	
}


