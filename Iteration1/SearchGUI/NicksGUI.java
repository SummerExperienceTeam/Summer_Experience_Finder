
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//import javafx.scene.paint.Color;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;


public class NicksGUI extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;  
	private JTable table;
	private JLabel experiencesLabel;
	private JLabel searchCriteriaLabel;
	
	
	nickExperienceGUI testExperience = new nickExperienceGUI(true,true,"Greenpeace","California", "Monteray", 
			"Saving the whales", "It was fun", 30, nickExperienceGUI.StudentStanding.SENIOR, nickExperienceGUI.CompensationType.UNPAID,
			nickExperienceGUI.MainActivity.VOLUNTEERING);
	/*
	 * boolean international, boolean internship, String organization, String state, String city,
			String natureOfWork, String addtionalInformation, int hoursPerWeek, StudentStanding standing,
			CompensationType compensation, MainActivity activity
	 */

	public static void main(String[] args) {
		NicksGUI ourGUI = new NicksGUI();
	}

	
	public String getSearchCriteria(JComboBox state, JComboBox standing, JComboBox compensationList,JComboBox mainActivityList, JCheckBox internationalBox, JCheckBox internshipBox)
	{
		//NEED TO ATT STUFF FOR INTERNATIONAL AND INTERNSHIP BUTTONS.
		String criteriaToReturn = (String) state.getSelectedItem() +" " + (String) standing.getSelectedItem()  +" " + (String) compensationList.getSelectedItem() +" " + (String) mainActivityList.getSelectedItem();
		
		return criteriaToReturn;
	}
	
	
	
	public NicksGUI() {
		
		setTitle("Database Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 600, 1200, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.setLayout(new BorderLayout(0, 1));
		setContentPane(contentPane); 
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		getContentPane().setBackground(Color.lightGray);
		
		
		
			
//		JLabel enterQuery = new JLabel("Enter Query");
//		panel.add(enterQuery);
//		
//		lastNameTextField = new JTextField();
//		panel.add(lastNameTextField);
//		lastNameTextField.setColumns(10);
//		
//		btnSearch = new JButton("Search");
//		panel.add(btnSearch);
//		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		experiencesLabel = new JLabel(testExperience.toString());
		experiencesLabel.setLayout(new GridLayout());
		experiencesLabel.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(experiencesLabel, BorderLayout.CENTER);
		
		
		
		
	
	//Drop down menus/ 
		JButton searchButton = new JButton("Search");
		panel.add(searchButton);
		
		
		String[] StateFilter = { "Select State", "Alabama", "Alaska", "Arkansas", "California"};
		JComboBox stateList = new JComboBox(StateFilter);
		panel.add(stateList);
		
		String[] studentStandingFilter = { "Select Year" ,"Rising Sophmore", "Rising Junior", "Rising Senior"};
		JComboBox studentStandingList = new JComboBox(studentStandingFilter);
		panel.add(studentStandingList);
		
		String[] compensationFilter = { "Select Financial Compensation", "Unpaid", "Paid", "Stipend"};
		JComboBox compensationList = new JComboBox(compensationFilter);
		panel.add(compensationList);
		
		String[] mainActivityFilter = { "Select Main Activity", "Block at CC", "Music performance/study", "Time off traveling", "Study abroad"
				,"Summer Job", "Class at another institution", "Academic research position","Volunteer/service position" };
		JComboBox mainActivityList = new JComboBox(mainActivityFilter);
		panel.add(mainActivityList);
		
		JCheckBox internationalBox = new JCheckBox("International Students");
		internationalBox.setMnemonic(KeyEvent.VK_C); 
		internationalBox.setSelected(false);
		panel.add(internationalBox);
		

		JCheckBox internshipBox = new JCheckBox("Internship");
		internshipBox.setMnemonic(KeyEvent.VK_C); 
		internshipBox.setSelected(false);
		panel.add(internshipBox);
		panel.setBackground(Color.gray);
		

		
		searchButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String searchCriteria = getSearchCriteria(stateList, studentStandingList, compensationList, mainActivityList, internationalBox, internshipBox);
				searchCriteriaLabel = new JLabel(searchCriteria);
				searchCriteriaLabel.setLayout(new GridLayout());
				searchCriteriaLabel.setFont(new Font("Arial", Font.BOLD, 16));
				contentPane.add(searchCriteriaLabel, BorderLayout.CENTER);
				searchCriteriaLabel.setVisible(true);
				System.out.println(searchCriteria);
				
				contentPane.repaint();
			}	
		} );
		
		
		//internationalBox.addItemListener(this);
		setVisible(true);
		
		
	}

}

