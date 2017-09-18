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

//Redone GUI with GridBagLayout
public class NewGUI
{
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
    //Components as global variables. 
    private JPanel mainPane;
	private JScrollPane scrollPane;  
	private JTable table;
	private JLabel experiencesLabel;
	private JLabel searchCriteriaLabel;
	private JFrame masterFrame; 
	private JLabel searchCriteria;
	private JTextArea outputText;
	private String INTERNATIONAL_STRING = "International Student:Yes";
	private String INTERNSHIP_STRING = "Internship:Yes";
	
	
	//ColorScheme below
	private Color colorOne = convertFXColorToSwingColor(javafx.scene.paint.Color.BURLYWOOD); //Light Brown
	private Color colorTwo = convertFXColorToSwingColor(javafx.scene.paint.Color.ROSYBROWN); //...
	private Color colorThree = convertFXColorToSwingColor(javafx.scene.paint.Color.DARKBLUE);
	private Color colorFour = convertFXColorToSwingColor(javafx.scene.paint.Color.NAVY);
	
	private GuiFileIO guiIO = new GuiFileIO();
	
	
	Experience testExperience = new Experience(true,true,"Greenpeace","California", "Monteray", 
			"Saving the whales", "It was fun", "30", "Senior","Unpaid",
			"Volunteering");
	
	public NewGUI()
	{
		//... empty constructor. 
	}
	
	public String getSearchCriteria(JComboBox state, JComboBox standing, JComboBox compensationList,JComboBox mainActivityList, JCheckBox internationalBox, JCheckBox internshipBox)
	{
		//NEED TO ATT STUFF FOR INTERNATIONAL AND INTERNSHIP BUTTONS.
		String intl = "";
		String intern = "";
		if(internationalBox.isSelected())
		{
			intl = INTERNATIONAL_STRING + ", ";
		}
		if(internshipBox.isSelected())
		{
			intern = INTERNSHIP_STRING;
		}
		String criteriaToReturn = (String) state.getSelectedItem() +" " + (String) standing.getSelectedItem()  +" " 
		+ (String) compensationList.getSelectedItem() +" " + (String) mainActivityList.getSelectedItem() + " " + intl + intern;
		
		return criteriaToReturn;
	}
	
	public ArrayList<String> getCrieteriaList(JComboBox state, JComboBox standing, JComboBox compensationList,JComboBox mainActivityList, JCheckBox internationalBox, JCheckBox internshipBox)
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
		criteria.add((String) mainActivityList.getSelectedItem());
		
		return criteria;
	}
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
		mainPane.setBackground(Color.gray);
		
		
		//ADD Class Standing
		//Remove main activity
		//ADD hours per week
		//ADD Industry
		
		String[] StateFilter =  guiIO.getFileLinesAsStringArray("States.txt");
		JComboBox stateList = new JComboBox(StateFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		mainPane.add(stateList, c);
		
		String[] studentStandingFilter = { "Select Year" ,"Rising Sophmore", "Rising Junior", "Rising Senior"};
		JComboBox studentStandingList = new JComboBox(studentStandingFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		mainPane.add(studentStandingList, c);
		
		String[] compensationFilter = { "Select Financial Compensation", "Unpaid", "Paid", "Stipend"};
		JComboBox compensationList = new JComboBox(compensationFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		mainPane.add(compensationList, c);
		
		String[] industryFilter = { "Select Industry", "Arts, Media and Communications","Community Organizations/Non-Profits"
				,"Consulting, Management and Human Resources","Education", "Engineering and Technology","Environment and Sustainability"
				, "Finance, Real Estate and Insurance", "Healthcare","Public Policy, Government and Law","Scientific Research"
				,"Sports and Outdoor Recreation", "Other"};
		JComboBox industryList = new JComboBox(industryFilter);
		c.weightx = 0.5; 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		mainPane.add(industryList, c);
		
		String[] hoursFilter = {"Select Hours/Week",  "Under 15", "15-29", "30+"};
		JComboBox hoursList = new JComboBox(hoursFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		mainPane.add(hoursList, c);
		
		
		
		JCheckBox internationalBox = new JCheckBox("International Students");
		internationalBox.setMnemonic(KeyEvent.VK_C); 
		internationalBox.setSelected(false);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		mainPane.add(internationalBox, c);
		
		
		JCheckBox internshipBox = new JCheckBox("Internship");
		internshipBox.setMnemonic(KeyEvent.VK_C); 
		internshipBox.setSelected(false);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		mainPane.add(internshipBox, c);

		
		
		JButton searchButton = new JButton("Search");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		mainPane.add(searchButton, c);
		
		
		outputText = new JTextArea("");
		outputText.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		outputText.setBackground(Color.DARK_GRAY);
		outputText.setForeground(Color.WHITE);
		
		
		scrollPane = new JScrollPane(outputText);
		scrollPane.setBorder(BorderFactory.createBevelBorder(3,colorFour, colorThree));
		scrollPane.setBackground(Color.LIGHT_GRAY);
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
				
				String search = getSearchCriteria(stateList, studentStandingList, compensationList, industryList, internationalBox, internshipBox);
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
	
	
	public static void main(String[] args)
	{
	       NewGUI gui = new NewGUI();
	       gui.createGUI();
	       
	}
}
	

