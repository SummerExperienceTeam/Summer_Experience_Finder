import java.util.Scanner;
/**
 * @author Pietro
 */
public class Menu_Interface 
{
    public int chooseMenu()
    {
        System.out.println(
"1.     Load a text file (using a GUI).\n" +
"2.     Search Name in File. \n" +
"3.     Defrag the experience file:\n" +
"4.     Exit.\n" +
        "Please input a number corresponding to your desired option");
        Scanner numbIn = new Scanner(System.in);
        int choice = numbIn.nextInt();
        return choice; 
    }
}
