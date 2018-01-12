package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorSearch {
	
	private Connection c;

	public AuthorSearch(Connection c) {
		this.c = c;
	}
	
	public ResultSet authorSearch(String searchString) {
		
		String query = "SELECT * FROM BOOKS " + 
						"WHERE LOWER(author) LIKE " + "'%" + searchString +"%';";
		
		
		Statement st;
		ResultSet rs = null;
		try {
			st = c.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
		
	}
}
