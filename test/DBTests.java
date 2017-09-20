import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DBTests {

	@Before
	public void setUpDB() {
		createDatabase dbCreator = new createDatabase();
		Connection conn = dbCreator.createDatabase();
		dbCreator.createTable();
		String filename = "Summer expereince survey 2016 for oliver.csv"; 
		dbCreator.importData(conn, filename);
	}
	
	@Test
	public void DBisValid() throws Exception {
		FilterDb DBFilter = new FilterDb();
		ArrayList<Experience> experiences = new ArrayList<Experience>();
		experiences = (ArrayList<Experience>) DBFilter.getAllExperiences();
		assertFalse(experiences.isEmpty());
	}
	
	@Test
	public void DBhasValidStandings() throws Exception {
		FilterDb DBFilter = new FilterDb();
		ArrayList<Experience> experiences = new ArrayList<Experience>();
		experiences = (ArrayList<Experience>) DBFilter.searchExperiences();
		experiences = (ArrayList<Experience>) DBFilter.getAllExperiences();
		assertTrue(experiences.get(4).getStanding().equals("Rising Junior"));
	}
	
	@Test
	public void DBHasValidOrg() throws Exception {
		FilterDb DBFilter = new FilterDb();
		ArrayList<Experience> experiences = new ArrayList<Experience>();
		experiences = (ArrayList<Experience>) DBFilter.searchExperiences();
		experiences = (ArrayList<Experience>) DBFilter.getAllExperiences();
		assertTrue(experiences.get(5).getOrganization().equals("Youcheng Foundation"));
	}
	
	@Test
	public void DBHasValidState() throws Exception {
		FilterDb DBFilter = new FilterDb();
		ArrayList<Experience> experiences = new ArrayList<Experience>();
		experiences = (ArrayList<Experience>) DBFilter.searchExperiences();
		experiences = (ArrayList<Experience>) DBFilter.getAllExperiences();
		assertTrue(experiences.get(10).getState().equals("North Carolina"));
	}
	
	@Test
	public void DBOutsideTheUS() throws Exception {
		FilterDb DBFilter = new FilterDb();
		ArrayList<Experience> experiences = new ArrayList<Experience>();
		experiences = (ArrayList<Experience>) DBFilter.searchExperiences();
		experiences = (ArrayList<Experience>) DBFilter.getAllExperiences();
		assertTrue(experiences.get(14).getState().equals("Outside the U.S."));
	}
	
	
}
