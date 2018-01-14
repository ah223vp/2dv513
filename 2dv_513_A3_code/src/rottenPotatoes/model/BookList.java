package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookList {
	
	private Connection c;

	public BookList(Connection c) {
		this.c = c;
	}
	
	public ResultSet getBookList() {
		
		String query = "SELECT * FROM BOOKS;";
		
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
