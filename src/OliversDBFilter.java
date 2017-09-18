import java.util.ArrayList;

public class OliversDBFilter {
	/*private String state = null;
	private String industry = null;
	private String year = null;
	private String hours = null;
	private String paid = null;
	private String visa = null;
	*/
	
	public ArrayList<Experience> filterDB(ArrayList<Experience> allExperiences, String state, String industry, String year, String hours, String paid, String visa) {
		ArrayList<Experience> matchingExperiences = cloneList(allExperiences);
		for(Experience e : matchingExperiences) {
			if( state != null && !state.equals(e.getState())) {
				matchingExperiences.remove(e);
			} 
			if( industry != null && !industry.equals(e.getIndusty())) {
				matchingExperiences.remove(e);
			} 
			if( year != null && !year.equals(e.getYear())) {
				matchingExperiences.remove(e);
			} 
			if( hours != null && !hours.equals(e.getHours())) {
				matchingExperiences.remove(e);
			} 
			if( paid != null && !paid.equals(e.getPaid())) {
				matchingExperiences.remove(e);
			} 
			if( visa != null && !visa.equals(e.getVisa())) {
				matchingExperiences.remove(e);
			} 
		}
		return matchingExperiences;
	}
	
	public ArrayList<Experience> cloneList(ArrayList<Experience> allExperiences) {
		ArrayList<Experience> matchingExperiences = new ArrayList<Experience>();
		for(Experience e : allExperiences) {
			matchingExperiences.add(e.clone());
		}
	}
	
}


