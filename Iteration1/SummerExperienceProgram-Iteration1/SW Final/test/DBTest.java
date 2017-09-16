
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

	public static File myFile = null;
	public static FileHandler myFiles;
	public static ArrayList<Experience> experiences;
	
	
	@Before
	public void selectFilePath()
	{
		
	}
	
	@Test
	public void readsDB() //Makes sure that our demo database is read.
	{
		ArrayList<Experience> experiences = new ArrayList<>();
		FileHandler myFiles = new FileHandler();
		myFile = myFiles.openFileGUI(myFile);
		experiences = myFiles.openFile(myFile);
		assertFalse(experiences.isEmpty());
		
	}
	
	@Test
	public void completeDBTest() { //Ensures that we read all of the avialable files in the database.
		ArrayList<Experience> experiences = new ArrayList<>();
		FileHandler myFiles = new FileHandler();
		myFile = myFiles.openFileGUI(myFile);
		experiences = myFiles.openFile(myFile);
		assertTrue(10==experiences.size());
	}

}
