package rottenPotatoes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Front of the model. The view has no direct connection with the db except for the init connection.
 * @author Andreas
 *
 */
public class DB_Facade {
	
	final String db_name = "rottenPotatoes";
	private Connection c;
	
	public void connectToDB() {
		
		c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/" + db_name,
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	       
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Connection established.....");
		
	}
	
	/**
	 * Logging in.
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean logonAttempt(String username, String password) {
		Logon logon = new Logon(c);
		return logon.logonAttempt(username, password);
		
		
	}
	
	/**
	 * Returning all books in the db.
	 * @return
	 */
	public ResultSet getBookList() {
		BookList bList = new BookList(c);
	
		return bList.getBookList();
	}
	/**
	 * Get the score for a particular book.
	 * @param isbn
	 * @return
	 */
	public ResultSet getBookScore(String isbn) {
		BookScore bs = new BookScore(c);
		
		return bs.getBookScore(isbn);
	}
	
	/**
	 * Returning the books by the searched author.
	 * @param query
	 * @return
	 */
	public ResultSet getAuthorSearch(String query) {
		// TODO Auto-generated method stub
		AuthorSearch as = new AuthorSearch(c);
		
		
		return as.authorSearch(query);
	}
	
	/**
	 * Returning books by the searched title.
	 * @param query
	 * @return
	 */
	public ResultSet getHeaderSearch(String query) {
		HeaderSearch hs = new HeaderSearch(c);
		return hs.headerSearch(query);
	}
	
	/**
	 * Returning the reviews for that book.
	 * @param query
	 * @return
	 */
	public ResultSet getReviews(String query) {
		
		ReviewSearch rs = new ReviewSearch(c);
		
		return rs.getReviews(query);
	}

	

}
