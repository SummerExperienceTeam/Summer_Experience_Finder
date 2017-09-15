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
 *
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
	
	public File openFileGUI(File myFile)
    {
        //JFileChooser fileGui = new JFileChooser();
		JFileChooser fileGui = new JFileChooser("C:\\Users\\pietr\\Desktop\\SW Final");
		fileGui.setDialogTitle("Please select a file to open: "); //Labelling the interface
        int result = fileGui.showOpenDialog(fileGui);
        if (result == JFileChooser.APPROVE_OPTION) 
        {            myFile = fileGui.getSelectedFile();
            System.out.println("File selected: " + myFile.getAbsolutePath());
        }
        
        return myFile;
    }
    //The method receive a file and the name that it should search for in the file, it on the use of newline characters.
    public void readFile(File myFile, String Name) throws FileNotFoundException, IOException
    {
        
        Scanner reader = new Scanner(myFile);
        reader.useDelimiter("\\n");
        boolean nameFound = false;
        while (reader.hasNext())
        {
            if(reader.nextLine().equals(Name))
            {
                System.out.println(Name + " has been found in the file");
                nameFound = true; 
            }    
        }
        
        if(nameFound == false)
        {
            System.out.println(Name + " has not been found in the file.");
            addName(myFile, Name);
        }    
    }
    
    //Method receives a file and a name as a parameter and adds any desired name to the file.
    public void addName(File myFile, String Name) throws FileNotFoundException, IOException
    {        
        try(FileWriter writer = new FileWriter(myFile, true); //Initiate filewriter with a boolean signaling appending mode
        BufferedWriter buffer = new BufferedWriter(writer); //Avoids the need to open and close a file
        PrintWriter output = new PrintWriter(buffer)) //Enables the use of println to append an extra line to the file.
        {
        output.println("\n" + Name); //Adds a new line character and the name.
        }
        System.out.println(Name + " has been added to the list");
        
    }
    
	public ArrayList<Experience> openFile(File myFile) {
		ArrayList<Experience> Experiences = new ArrayList<Experience>();
		try {
			Scanner input = new Scanner(new FileInputStream(myFile));
			while (input.hasNextLine()) {
				String line[] = input.nextLine().split(",");
				for(int i = 0; i < line.length; i++)
				{
					System.out.println("This is how our demo fields look like rn");
					System.out.println(line[i]);
				}
				/*
				String creditCardNumber = line[0];
				String accountHolderName = line[1];
				String type = line[2];
				float currentBalance = Float.parseFloat(line[3]);
				*/
				//CardGenerator.fileToCreditCard(cards, creditCardNumber, accountHolderName, type, currentBalance);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println(myFile + "does not exist");
		}
		return Experiences;
	}

}
