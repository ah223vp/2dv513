package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReviewSearch {
	
	private Connection c;

	public ReviewSearch(Connection c) {
		this.c = c;
	}
	
	public ResultSet getReviews(String isbn) {
		
		String query = "SELECT * FROM REVIEWS " + 
						"WHERE ISBN=" +"'" + isbn + "';";
		
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
