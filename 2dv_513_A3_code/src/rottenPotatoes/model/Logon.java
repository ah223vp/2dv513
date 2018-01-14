package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logon {
	
	private Connection c;

	public Logon(Connection c) {
		this.c = c;
	}
	
	public boolean logonAttempt(String username, String password) {
		
		String query = 
				"SELECT * FROM USERS WHERE " +
						"USERNAME="+"'" + username + "'" +
						" AND " +
						"PASSWORD=" + "'" + password + "';";
		
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String usernameResult = "";
			String passwordResult = "";
			
			while(rs.next()) {
				
				if(rs.getString(1).length() > 0 && rs.getString(2).length() > 0) {
					usernameResult = rs.getString(1);
					passwordResult = rs.getString(2);
				}
			}
			
			if(usernameResult.equals(username) && passwordResult.equals(password)) {
				return true;
			}
			
			//System.out.println(stmt.getResultSet());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
		
		
	}
}
