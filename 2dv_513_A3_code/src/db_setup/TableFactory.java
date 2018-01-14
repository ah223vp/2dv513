package db_setup;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableFactory {
	
	private Connection c;

	public TableFactory(Connection c) {
		this.c = c;
	}
	
	public void createTables() {
		Statement s;
		try {
			s = c.createStatement();
			s.executeUpdate(bookTable());
			s.executeUpdate(userTable());
			s.executeUpdate(scoreTable());
			s.executeUpdate(reviewTable());
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tables created!");
		
		
		
	}
	
	private String bookTable() {
		
		String bookTable = 
				"CREATE TABLE BOOKS" + 
				"(ISBN TEXT PRIMARY KEY," +
				"TITLE TEXT NOT NULL," +
				"AUTHOR TEXT NOT NULL," +
				"DESCRIPTION TEXT NOT NULL," +
				"PUBLISHEDDATE TEXT NOT NULL)";
		
		
		return bookTable;
		
	}
	
	private String userTable() {
		
		String userTable = 
				"CREATE TABLE USERS" +
				"(USERNAME	VARCHAR(50)	PRIMARY KEY," +
				"PASSWORD	VARCHAR(50)	NOT NULL," +
				"NAME	VARCHAR(50)	NOT NULL)";
		return userTable;
	}
	
	private String scoreTable() {
		
		String scoreTable = 
				"CREATE TABLE SCORE" +
				"(ISBN	TEXT	NOT NULL," +
				"USERNAME VARCHAR(50) NOT NULL," +
				"SCORE	INT	NOT NULL)";
		
		return scoreTable;
	}
	
	private String reviewTable() {
		
		String reviewTable = 
				"CREATE TABLE REVIEWS" +
				"(ISBN	TEXT	NOT NULL," +
				"USERNAME VARCHAR(50)	NOT NULL," +
				"REVIEW	TEXT	NOT NULL)";
		return reviewTable;
	}
	
}
