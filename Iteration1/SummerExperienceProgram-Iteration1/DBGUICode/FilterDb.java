import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Jacob
 * Filter DB conncets to an existing database set up through the instructions attached
 * and fetches the database and instanciates experience objects.
 *
 */

public class FilterDb {

public static final String PORT_NUMBER = "8889";

// javadocs comments and importation of excel  file into our database
/**
 * Get all experiences  returns all of the database information
 * in the form of an Experience type List.
 * @return List of all experience objects.
 * @throws Exception
 */
public static List<jacobExperience> getAllExperiences() throws Exception {
	
	List<jacobExperience> list = new ArrayList<>();
	
	Statement stmt = null;
	ResultSet myResults = null;
	
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} 
	catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} 
	try {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + "/Experience?user=root&password=root"); // MySQL

		// Step 2: Allocate a "Statement" object in the Connection
		stmt = conn.createStatement();
		myResults = stmt.executeQuery("select * from T1");
		
		while (myResults.next()) {
			jacobExperience tempExperience = convertRowToExperience(myResults);
			list.add(tempExperience);  
		}
		

		return list;		
	}
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		 stmt.close();
	}
	return list;
}

/**
 * searchExperience searches for the information in each row and calls
 * convertRowToExperience as a helper method to obtain the information from each
 * row in the DataBase
 * @return listExperience
 * @throws Exception
 */
public static List<jacobExperience> searchExperiences() throws Exception {
	List<jacobExperience> list = new ArrayList<>();

	PreparedStatement myStmt = null;
	ResultSet myResults = null;

	try {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + "/Experience?user=root&password=root"); // MySQL

		//lastName += "%";
		myStmt = conn.prepareStatement("select * from T1");
		
		myResults = myStmt.executeQuery();
		
		while (myResults.next()) {
			jacobExperience tempExperience = convertRowToExperience(myResults);
			list.add(tempExperience);
		}
		
		return list;
	}
	finally {
		myStmt.close();
		myResults.close();
	}
}

/**
 * Helper method that will utilize the a resultSet in order to obtain 
 * all of the fields from a given column and instance an Experience 
 * object with such fields. 
 * @param myResults
 * @return Experience type object.
 * @throws SQLException
 */
public static jacobExperience convertRowToExperience(ResultSet myResults) throws SQLException {
	
	
	String participate = myResults.getString("Q4");
	String decision = myResults.getString("Q3");
	String org = myResults.getString("Q5");
	String state = myResults.getString("Q7");
	String city = myResults.getString("Q8");
	String natureOfWork = myResults.getString("Q9");
	String additionalInformation = myResults.getString("Q13");
	String hoursPerWeek = myResults.getString("Q10");
	String classStanding = myResults.getString("Q2");
	String compensation = myResults.getString("Q11");
	String activity = myResults.getString("Q12");
	
	jacobExperience tempExperience = new jacobExperience(decision, participate, org, state, city, natureOfWork, additionalInformation, hoursPerWeek, classStanding, compensation, activity);	
	return tempExperience;
}

}