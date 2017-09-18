import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//import javafx.scene.paint.Color;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
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
		if(internationalBox.isSelected())
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
		masterFrame.setBounds(600, 600, 1200, 1200);
	
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		mainPane.setLayout(new GridBagLayout());
		masterFrame.setContentPane(mainPane);
		
		//From the GridBagLayoutDemo
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) 
		{
		c.fill = GridBagConstraints.HORIZONTAL;
		}
		mainPane.setBackground(Color.gray);
		
		String[] StateFilter = { "Select State", "Alabama", "Alaska", "Arkansas", "California"};
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
		mainPane.add(stateList, c);
		
		String[] compensationFilter = { "Select Financial Compensation", "Unpaid", "Paid", "Stipend"};
		JComboBox compensationList = new JComboBox(compensationFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		mainPane.add(compensationList, c);
		
		String[] mainActivityFilter = { "Select Main Activity", "Block at CC", "Music performance/study", "Time off traveling", "Study abroad"
				,"Summer Job", "Class at another institution", "Academic research position","Volunteer/service position" };
		JComboBox mainActivityList = new JComboBox(mainActivityFilter);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		mainPane.add(mainActivityList, c);
		
		JCheckBox internationalBox = new JCheckBox("International Students");
		internationalBox.setMnemonic(KeyEvent.VK_C); 
		internationalBox.setSelected(false);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		mainPane.add(internationalBox, c);
		
		
		JCheckBox internshipBox = new JCheckBox("Internship");
		internshipBox.setMnemonic(KeyEvent.VK_C); 
		internshipBox.setSelected(false);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		mainPane.add(internshipBox, c);

		
		
		JButton searchButton = new JButton("Search");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 0;
		mainPane.add(searchButton, c);
		
		JPanel blankPanel = new JPanel();
		blankPanel.setLayout(new FlowLayout());
		blankPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
		//blankPanel.setLayout(new BorderLayout(0, 1));
		blankPanel.setVisible(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 100;    
		c.ipadx = 100;
		c.weightx = 0.0;
		c.gridwidth = 10;
		c.gridheight = 10;
		c.gridx = 0;
		c.gridy = 2;
		mainPane.add(blankPanel, c);
		JPanel blank1Panel = new JPanel();
		blank1Panel.setLayout(new FlowLayout());
		blank1Panel.setBorder(new EmptyBorder(50, 50, 50, 50));
		//blankPanel.setLayout(new BorderLayout(0, 1));
		blank1Panel.setVisible(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 100;    
		c.ipadx = 100;
		c.weightx = 0.0;
		c.gridwidth = 10;
		c.gridheight = 10;
		c.gridx = 0;
		c.gridy = 3;
		mainPane.add(blank1Panel, c);
	
		
		
		
		
	
		
		
		searchButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String search = getSearchCriteria(stateList, studentStandingList, compensationList, mainActivityList, internationalBox, internshipBox);
				outputText = new JTextArea("TOP \n"+search+"\n BOTTOM \n");
				scrollPane = new JScrollPane(outputText);
				scrollPane.setBorder(new EmptyBorder(50, 50, 100, 100));
				scrollPane.setBackground(Color.DARK_GRAY);
				//scrollPane.setBounds(500, 500, 1100, 1100);
				//scrollPane.setLayout(new ScrollPaneLayout());
				scrollPane.setVisible(true);
				c.fill = GridBagConstraints.HORIZONTAL;
				c.ipady = 100;    
				c.ipadx = 100;
				c.weightx = 0.0;
				c.gridwidth = 10;
				c.gridheight = 10;
				c.gridx = 0;
				c.gridy = 0;
				mainPane.add(scrollPane, c);
				mainPane.revalidate();
				mainPane.setVisible(true);

				
			}	
		} );
				
		mainPane.setVisible(true);	
		masterFrame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
	       NewGUI gui = new NewGUI();
	       gui.createGUI();
	       
	}
}
	

