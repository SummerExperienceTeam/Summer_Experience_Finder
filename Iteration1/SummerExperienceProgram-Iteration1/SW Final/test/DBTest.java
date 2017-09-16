
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * The following tests the interaction with our demo database of 10 entries for the first iteration
 * of our summer experience project
 * @author Pietro
 *
 */
public class DBTest {
	
	@Test
	public void readsDB() //Makes sure that our demo database is read.
	{
		String demoFile = "Demo File.csv";
		ArrayList<Experience> experiences = new ArrayList<>();
		FileHandler myFiles = new FileHandler();
		experiences = myFiles.fileToExperiences(demoFile);
		assertFalse(experiences.isEmpty());
		
	}
	
	@Test
	public void completeDBTest() { //Ensures that we read all of the avialable files in the database.
		String demoFile = "Demo File.csv";
		ArrayList<Experience> experiences = new ArrayList<>();
		FileHandler myFiles = new FileHandler();
		experiences =  myFiles.fileToExperiences(demoFile);
		assertTrue(10==experiences.size());
	}

}
