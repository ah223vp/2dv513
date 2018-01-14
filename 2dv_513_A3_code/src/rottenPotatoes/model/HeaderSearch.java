package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HeaderSearch {
	
	private Connection c;

	public HeaderSearch(Connection c) {
		this.c = c;
	}
	
	public ResultSet headerSearch(String searchString) {
		
		String query = "SELECT * FROM BOOKS " + 
						"WHERE LOWER(title) LIKE " + "'%" + searchString +"%';";
		
		
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
