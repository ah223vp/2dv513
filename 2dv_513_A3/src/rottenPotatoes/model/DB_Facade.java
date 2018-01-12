package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DB_Facade {
	
	final String db_name = "rottenPotatoes";
	private Connection c;
	
	public void connectToDB() {
		
		c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5434/" + db_name,
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	       
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Connection established.....");
		
	}
	
	public boolean logonAttempt(String username, String password) {
		Logon logon = new Logon(c);
		return logon.logonAttempt(username, password);
		
		
	}
	
	public ResultSet getBookList() {
		BookList bList = new BookList(c);
	
		return bList.getBookList();
	}
	public ResultSet getBookScore(String isbn) {
		BookScore bs = new BookScore(c);
		
		return bs.getBookScore(isbn);
	}

	public ResultSet getAuthorSearch(String query) {
		// TODO Auto-generated method stub
		AuthorSearch as = new AuthorSearch(c);
		
		
		return as.authorSearch(query);
	}

	public ResultSet getHeaderSearch(String query) {
		HeaderSearch hs = new HeaderSearch(c);
		return hs.headerSearch(query);
	}

	

}
