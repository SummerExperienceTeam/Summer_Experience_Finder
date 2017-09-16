import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Demo {
	public static String myFile = "Demo File.csv";
	public static FileHandler myFiles;
	public static ArrayList<Experience> experiences;
	
	/**
	 * This demo just interacts with the menu and our experience object
	 * to show their initial basic functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		myFiles = new FileHandler();
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (exit == false)
        {
            Menu_Interface myMenu = new Menu_Interface();
            
            int option = myMenu.chooseMenu();
            switch(option)
            {
                case 1:
                    experiences = myFiles.fileToExperiences(myFile);
                    break;
                case 2:
                    if (experiences == null) //Making sure a file is selected to read
                        System.out.println("Please load the database first");
                    else
                    {
                        for (int i = 0; i < experiences.size(); i++)
                        {
                        	System.out.println(experiences.get(i));
                        }
                    }
                    break;
               
                case 3:
                    System.out.println("Exiting program...");
                    exit = true; 
                    break;
                default:
                    System.out.println("Error: Please input a valid number or 4 to exit.");
            }         
        }

	}

}