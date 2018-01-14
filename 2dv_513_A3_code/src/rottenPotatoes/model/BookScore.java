package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookScore {
	
	private Connection c;

	public BookScore(Connection c) {
		this.c = c;
	}
	public ResultSet getBookScore(String isbn) {
		
		String query = "SELECT AVG(score) FROM score " + 
						"WHERE isbn="+"'"+ isbn + "';";
		
		ResultSet rs = null;
		try {
			Statement st = c.createStatement();
			rs = st.executeQuery(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
		
		
	}
}
