import java.util.ArrayList;

/**
 * This class will take in some form of data from the File IO class and 
 * call the constructor and make experience objects. An ArrayList of Experience 
 * objects will be an important output from one of this classes methods. 
 * @author Nick
 *
 */
public class ExperienceListCreator
{

	
	public Experience generateExperience()
	{
		Experience ex = new Experience(args);
		/**
		 * ARGS for experience are... 
		 * boolean international, boolean internship, String organization, String state, String city,
			String natureOfWork, String addtionalInformation, int hoursPerWeek, StudentStanding standing,
			CompensationType compensation, MainActivity activity
		 */
		//args will come in from whatever the FileIO spits out
		
		return ex;
	}
	
	
	public ArrayList<Experience> generateExperienceList(DATA)
	{	
		ArrayList<Experience> experienceList = new ArrayList<Experience>();
		//Takes the FiloIOdata...
		//...
		// some loop maybe
		experienceList.add(generateExperience(DATA));
		
		return experienceList;
	}
	
}
