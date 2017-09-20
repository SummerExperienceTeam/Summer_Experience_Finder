import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ExperienceFilterTest {

	@Before
	public void setUpDB() throws SQLException {
		createSingletonDatabase.getInstance();
	}
	
	@Test
	public void DBisCreated() throws Exception {
		DatabaseConverter converter = new DatabaseConverter();
		ArrayList<Experience> experiences = (ArrayList<Experience>) converter.getAllExperiences();
		assertFalse(experiences.isEmpty());
	}
	
	@Test
	public void filteredListIsNotEmpty() throws Exception {
		DatabaseConverter converter = new DatabaseConverter();
		ArrayList<Experience> experiences = (ArrayList<Experience>) converter.getAllExperiences();
		ExperienceFilter filter = new ExperienceFilter(experiences);
		Criteria criteria = new Criteria("Select State", "Select Industry", "Select Year", "Select Hours/Week", "Select Financial Compensation", "Not Selected", "Not Selected");
		ArrayList<Experience> filteredExperiences = filter.filterDB(criteria);
		assertFalse(filteredExperiences.isEmpty());
	}
	
	@Test
	public void filtersToPaidOnly() throws Exception {
		DatabaseConverter converter = new DatabaseConverter();
		ArrayList<Experience> experiences = (ArrayList<Experience>) converter.getAllExperiences();
		ExperienceFilter filter = new ExperienceFilter(experiences);
		Criteria criteria = new Criteria("Select State", "Select Industry", "Select Year", "Paid hourly wage", "Select Financial Compensation", "Not Selected", "Not Selected");
		
		
		ArrayList<Experience> filteredExperiences = filter.filterDB(criteria);
		assertFalse(filteredExperiences.isEmpty());
	}
	
	

}
