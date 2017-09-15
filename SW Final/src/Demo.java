import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Demo {
	public static File myFile = null;
	public static FileHandler myFiles;
	public static ArrayList<Experience> experiences;
	
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
                    myFile = myFiles.openFileGUI(myFile);
                    break;
                case 2:
                    if(myFile == null)
                        System.out.println("Please select a file first");
                    else
                    {
                        System.out.println("Reading DB Demo file");
                        experiences = myFiles.openFile(myFile);
                    }
                    break;
                case 3:
                    if (myFile == null) //Making sure a file is selected to read
                        System.out.println("Plea`se select a file first");
                    else
                    {
                        for (int i = 0; i < experiences.size(); i++)
                        {
                        	System.out.println(experiences.get(i));
                        }
                    }
                    break;
               
                case 4:
                    System.out.println("Exiting program...");
                    exit = true; 
                    break;
                default:
                    System.out.println("Error: Please input a valid number or 4 to exit.");
            }         
        }

	}

}
