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



public class FilterDb {

public static final String PORT_NUMBER = "8889";

/**
 * Gets all of the experiences from the database so we can display them in our gui
 *
 */
public static List<Experience> getAllExperiences() throws Exception {
	
	List<Experience> list = new ArrayList<>();
	
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
				"jdbc:mysql://localhost:" + PORT_NUMBER + "/Experiences?user=root&password=root"); // MySQL

		// Step 2: Allocate a "Statement" object in the Connection
		stmt = conn.createStatement();
		myResults = stmt.executeQuery("select * from T1");
		
		while (myResults.next()) {
			Experience tempExperience = convertRowToExperience(myResults);
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
 * Gets all of the experiences from our database and allows us to search them 
 * 
 *
 */
public static List<Experience> searchExperiences() throws Exception {
	List<Experience> list = new ArrayList<>();

	PreparedStatement myStmt = null;
	ResultSet myResults = null;

	try {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + "/Experiences?user=root&password=root"); // MySQL

		//lastName += "%";
		myStmt = conn.prepareStatement("select * from T1");
		
		myResults = myStmt.executeQuery();
		
		while (myResults.next()) {
			Experience tempExperience = convertRowToExperience(myResults);
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
 * Converts experiences so that they are read as a row that will can contain the differnt attributes of experiences 
 *
 */
public static Experience convertRowToExperience(ResultSet myResults) throws SQLException {
	
	
	String participate = myResults.getString("Question4"); // leave questoin 4 = org 
	String decision = myResults.getString("Question3"); //leave = did u intership  
	String org = myResults.getString("Question5"); //leave = state internship
	String state = myResults.getString("Question6"); // leave = city of internship
	String city = myResults.getString("Question7"); // leave = nature of work
	String natureOfWork = myResults.getString("Question8"); // leave = hrs per week
	String hoursPerWeek = myResults.getString("Question9"); // leave  = compensation
	String classStanding = myResults.getString("Question1"); 
	String compensation = myResults.getString("Question2"); // 22 , 11 , 12 , 21 
	
	Experience tempExperience = new Experience(decision, participate, org, state, city, natureOfWork, hoursPerWeek, classStanding, compensation );	
	return tempExperience;
}

}