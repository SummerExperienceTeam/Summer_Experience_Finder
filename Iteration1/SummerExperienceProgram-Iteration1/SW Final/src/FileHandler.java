import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *The following class handles the CSV files that would scale to our big MYSQL database in future iterations
 * @author Pietro
 */
public class FileHandler 
{
    
	public static ArrayList<Experience> experienceList = new ArrayList<Experience>();
	public static final int International = 0;
	public static final int Internship = 1;
	public static final int Organization = 2;
	public static final int State = 3;
	public static final int City = 4;
	public static final int natureOfWork = 5;
	public static final int additionalInformation = 6;
	public static final int hoursPerWeek = 7;
	public static final int Standing = 8;
	public static final int Compensation = 9;
	public static final int MainActivity = 10;
	
	/**
	 * This method ensures that there is machine universality and thus
	 * utilizes a GUI to locate the Demo File, however in the future,
	 * allows the user to simply get new databases to pass through the program.
	 * @param myFile
	 * @return
	 */
	public File openFileGUI(File myFile)
    {
        JFileChooser fileGui = new JFileChooser();
		//fileGui/JFileChooser fileGui = new JFileChooser("C:\\Users\\pietr\\Desktop\\SW Final");
		fileGui.setDialogTitle("Please select a file to open: "); //Labelling the interface
        int result = fileGui.showOpenDialog(fileGui);
        if (result == JFileChooser.APPROVE_OPTION) 
        {            myFile = fileGui.getSelectedFile();
            System.out.println("File selected: " + myFile.getAbsolutePath());
        }
        
        return myFile;
    }
    
	/**This method opens the file and initializes the Experience data objects that
	 * will be re-factored so that these are fed to a factory strategy in a future
	 * @param String with fileName
	 * @return
	 */
	static public ArrayList<Experience> fileToExperiences(String fileName) {
		ArrayList<Experience> Experiences = new ArrayList<Experience>();
		try {
			Scanner input = new Scanner(new FileInputStream(fileName));
			while (input.hasNextLine()) {
				String line[] = input.nextLine().split(",");
					String studentStanding = line[0];
					String International = line[1];
					boolean isInternational = false; 
					if  (International.equals("No"))
							isInternational = false;
					String internship = line[2];
					boolean didInternship = false;
					String organization = line[3];
					String location = line[4];
					String city = line[5];
					String natureOfWork = line[6];
					String hours = line[7];
					String compensationType = line[8];
					String mainActivity = line[9];
					String additionalInfo = line[10];
					Experiences.add(new Experience(isInternational, didInternship, organization, city, location, natureOfWork, hours, studentStanding, compensationType, mainActivity));
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "is not in the folder/doesn't exist");
		}
		return Experiences;
	}
}