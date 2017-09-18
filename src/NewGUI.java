import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

//import javafx.scene.paint.Color;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneLayout;

/**
 * New and updated GUI with GridBagLayOut and up to date (09/17/2017) Experience class usage.
 * @author Nick
 *
 */
public class NewGUI
{
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
    //Components as global variables for easy identification.
    private JPanel mainPane;
	private JScrollPane scrollPane;  
	private JFrame masterFrame; 
	private JTextArea outputText;
	
	
	//Selection Tools
	private JComboBox stateList ;
	private JComboBox studentStandingList;
	private JComboBox compensationList;
	private JComboBox industryList;
	private JComboBox hoursList;
	private JCheckBox internationalBox; 
	private JCheckBox internshipBox ;
	private JButton searchButton;
	
	
	
	private String INTERNATIONAL_STRING = ", International Student:Yes";
	private String INTERNSHIP_STRING = ", Internship:Yes";
	//ColorScheme below
	private Color colorOne = convertFXColorToSwingColor(javafx.scene.paint.Color.BLACK); //Dark
	private Color colorTwo = convertFXColorToSwingColor(javafx.scene.paint.Color.GOLDENROD); //Light
	private Color colorThree = convertFXColorToSwingColor(javafx.scene.paint.Color.BEIGE);
	private Color colorFour = convertFXColorToSwingColor(javafx.scene.paint.Color.GOLD);
	//Instance of utility class
	private GuiFileIO guiIO = new GuiFileIO();
	
	//List of experiences that the GUI uses
	ArrayList<Experience> experiences = new ArrayList<Experience>();
	
	
	public NewGUI(ArrayList<Experience> experiences)
	{
		this.experiences = experiences;
	}
	
	/**
	 * This method gets the selected options of the GUI and returns them as a string.
	 * @param state
	 * @param standing
	 * @param compensationList
	 * @param industryList
	 * @param hoursList
	 * @param internationalBox
	 * @param internshipBox
	 * @return
	 */
	public String getSearchCriteria(JComboBox state, JComboBox standing, JComboBox compensationList,JComboBox industryList, JComboBox hoursList,  JCheckBox internationalBox, JCheckBox internshipBox)
	{
		//NEED TO ATT STUFF FOR INTERNATIONAL AND INTERNSHIP BUTTONS.
		String intl = "";
		String intern = "";
		if(internationalBox.isSelected())
		{
			intl = INTERNATIONAL_STRING + "";
		}
		if(internshipBox.isSelected())
		{
			intern = INTERNSHIP_STRING;
		}
		String criteriaToReturn = (String) state.getSelectedItem() +", " + (String) standing.getSelectedItem()  +", " 
		+ (String) compensationList.getSelectedItem() +", " + (String) industryList.getSelectedItem() +", "+ (String) hoursList.getSelectedItem()+ intl + intern;
		
		return criteriaToReturn;
	}
	
	public String experienceObjectListToString(ArrayList<Experience> experiences)
	{
		String experiencesString = "";
		for(Experience temp: experiences)
		{
			experiencesString = experiencesString + temp.toString() +"\n";
		}
		
		
		return experiencesString;
	}
	
	/**
	 * This method gets the selected options of the GUI and returns them as an ArrayList of Strings.
	 * @param state
	 * @param standing
	 * @param compensationList
	 * @param industryList
	 * @param hoursList
	 * @param internationalBox
	 * @param internshipBox
	 * @return
	 */
	public ArrayList<String> getCrieteriaList(JComboBox state, JComboBox standing, JComboBox compensationList,JComboBox industryList, JComboBox hoursList, JCheckBox internationalBox, JCheckBox internshipBox)
	{
		ArrayList<String> criteria = new ArrayList<String>();
		if(internationalBox.isSelected())
		{
			criteria.add(INTERNATIONAL_STRING);
		}
		if(internationalBox.isSelected())
		{
			criteria.add(INTERNSHIP_STRING);
		}
		
		criteria.add((String) state.getSelectedItem());
		criteria.add((String) standing.getSelectedItem());
		criteria.add((String) compensationList.getSelectedItem());
		criteria.add((String) industryList.getSelectedItem());
		criteria.add((String) hoursList.getSelectedItem());
		
		return criteria;
	}
	
	/**
	 * This method creates and formats the GUI.
	 */
	public void createGUI() 
	{
		
		masterFrame = new JFrame("Database Search");
		masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		masterFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		masterFrame.setBounds(0, 0, 1200, 600);
	
		mainPane = new JPanel();
		mainPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPane.setLayout(new GridBagLayout());
		masterFrame.setContentPane(mainPane);
		
		//From the GridBagLayoutDemo
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) 
		{
		c.fill = GridBagConstraints.HORIZONTAL;
		}
		c.insets = new Insets(2,2,2,2);
		mainPane.setBackground(colorTwo);
		
		
		//Below are all of the filters, checkBoxes, and Buttons.
		//__________________________________________________________________________________________________________
		String[] StateFilter =  guiIO.getFileLinesAsStringArray("States.txt");
		stateList = new JComboBox(StateFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		mainPane.add(stateList, c);
		
		String[] studentStandingFilter = { "Select Year" ,"Freshman", "Sophomore", "Junior"};
		studentStandingList = new JComboBox(studentStandingFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		mainPane.add(studentStandingList, c);
		
		String[] compensationFilter = { "Select Financial Compensation", "Unpaid", "Paid Hourly Wage", "Stipend"};
		compensationList = new JComboBox(compensationFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		mainPane.add(compensationList, c);
		
		String[] industryFilter = { "Select Industry", "Arts, Media and Communications","Community Organizations/Non-Profits"
				,"Consulting, Management and Human Resources","Education", "Engineering and Technology","Environment and Sustainability"
				, "Finance, Real Estate and Insurance", "Healthcare","Public Policy, Government and Law","Scientific Research"
				,"Sports and Outdoor Recreation", "Other"};
		industryList = new JComboBox(industryFilter);
		c.weightx = 0.5; 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		mainPane.add(industryList, c);
		
		String[] hoursFilter = {"Select Hours/Week",  "Under 15", "15-29", "30+"};
		hoursList = new JComboBox(hoursFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		mainPane.add(hoursList, c);
		
		internationalBox = new JCheckBox("International Students");
		internationalBox.setMnemonic(KeyEvent.VK_C); 
		internationalBox.setSelected(false);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		mainPane.add(internationalBox, c);
		
		internshipBox = new JCheckBox("Internships only");
		internshipBox.setMnemonic(KeyEvent.VK_C); 
		internshipBox.setSelected(false);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		mainPane.add(internshipBox, c);
	
		searchButton = new JButton("Search");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		mainPane.add(searchButton, c);
		
		//__________________________________________________________________________________________________________

		//Sets up the Text are where output will go.
		outputText = new JTextArea("");
		outputText.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		outputText.setBackground(colorOne);
		outputText.setForeground(Color.WHITE);
		
		//Setting up the scroll pane 
		scrollPane = new JScrollPane(outputText);
		scrollPane.setBorder(BorderFactory.createBevelBorder(3,colorFour, colorThree));
		scrollPane.setBackground(colorThree);
		scrollPane.setVisible(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 100;    
		c.ipadx = 100;
		c.weightx = 0.0;
		c.gridwidth = 10;
		c.gridheight = 10;
		c.gridx = 0;
		c.gridy = 2;
		mainPane.add(scrollPane, c);
		mainPane.revalidate();
		mainPane.setVisible(true);
		masterFrame.validate();
		searchButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Action Listener that updates the text.
				String search = getSearchCriteria(stateList, studentStandingList, compensationList, industryList, hoursList, internationalBox, internshipBox);
				outputText.setText(search);;
				mainPane.revalidate();
				mainPane.setVisible(true);
				masterFrame.validate();
				
			}
		} );
		
		masterFrame.setVisible(true);
	}
	
	
	/**
	 * converts javafx colors to colors usable by swing.
	 * @param fxColor
	 * @return
	 */
	public Color convertFXColorToSwingColor(javafx.scene.paint.Color fxColor)
	{
		

		java.awt.Color awtColor = new java.awt.Color((float) fxColor.getRed(),
		                                             (float) fxColor.getGreen(),
		                                             (float) fxColor.getBlue(),
		                                             (float) fxColor.getOpacity());
		return awtColor;
	}
	
	//For testing
//	public static void main(String[] args)
//	{
//	       NewGUI gui = new NewGUI();
//	       gui.createGUI();
//	       
//	}
}
	

