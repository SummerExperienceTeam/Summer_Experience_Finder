import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;


public class DbQuery extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox filterList;
	

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
		
		
		//JLabel enterQuery = new JLabel("Enter Query");
		//panel.add(enterQuery);
		
		//lastNameTextField = new JTextField();
		//panel.add(lastNameTextField);
		//lastNameTextField.setColumns(10);
		
		//btnSearch = new JButton("Search");
		//panel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	
	
		
		String[] filterNames = { "Select State", "Alabama", "Alaska", "Arkansas", "California" };
		JComboBox filterList = new JComboBox(filterNames);
		panel.add(filterList);
		

		setVisible(true);
		
		
	}

}
