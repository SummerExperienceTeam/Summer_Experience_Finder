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
		Experience ex = new Experience(false, false, null, null, null, null, null, 0, null, null, null);
		/**
		 * ARGS for experience are... 
		 * boolean international, boolean internship, String organization, String state, String city,
			String natureOfWork, String addtionalInformation, int hoursPerWeek, StudentStanding standing,
			CompensationType compensation, MainActivity activity
		 */
		return ex;
	}
	
	
	public ArrayList<Experience> generateExperienceList()
	{	
		ArrayList<Experience> experienceList = new ArrayList<Experience>();
		//Takes the FiloIOdata...
		//...
		// some loop maybe
		experienceList.add(generateExperience());
		
		return experienceList;
	}
	
}
