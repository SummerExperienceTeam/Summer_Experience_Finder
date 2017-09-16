import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;

/**
 * @author Jacob
 * DbQuery is a temporary GUI that is meant to showcase the FilterDB code
 * which interacts with a database previously set as defined by the instructions.
 */

public class DbQuery extends JFrame {

	private JPanel contentPane;
	private JTextField databaseTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;    
	private JTable table;
	private JComboBox filterList;
	List<jacobExperience> experiences = null;
	FilterDb dbFilter = new FilterDb();
	

	public static void main(String[] args) {
		
	       
	        DbQuery ourGUI = new DbQuery();  
	    }


	
	public DbQuery() {
		
		setTitle("Database Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); 
		
		
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		databaseTextField = new JTextField();
		panel.add(databaseTextField);
		databaseTextField.setColumns(10);
		
		//btnSearch = new JButton("Search");
		//panel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	
	
		
		String[] filterNames = { "Select State ", "Alabama", "Alaska", "Arkansas", "California" };
		JComboBox filterList = new JComboBox(filterNames);
		panel.add(filterList );
		

		
		
		btnSearch = new JButton("Search");  
		panel.add(btnSearch) ;
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get data from the text field

				
				
				try {
					String searchQuery = databaseTextField.getText();
					
					experiences = null;

					if (searchQuery != null && searchQuery.trim().length() > 0) {
						experiences = FilterDb.searchExperiences();
					} else {
						experiences = FilterDb.getAllExperiences();
					}
					
					ExperienceTableModel model = new ExperienceTableModel(experiences);
					table.setModel(model);
					
					experiences = FilterDb.getAllExperiences();
					for (jacobExperience temp : experiences) {
						System.out.println(temp);
					}
					
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(DbQuery.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
				}
			});
		//panel.add(btnSearch);
		setVisible(true);

}}