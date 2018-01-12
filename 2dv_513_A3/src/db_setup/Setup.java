package db_setup;

import java.sql.Connection;
import java.sql.DriverManager;



public class Setup {
		
	String db_name = "rottenPotatoes";
	
	public static void main(String[] args) {
		
		Setup s = new Setup();
		s.db();
	}
	
	public void db() {
		Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5434/" + db_name,
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         
	        
	         // Creating tables
	         //TableFactory tf = new TableFactory(c);
	         //tf.createTables();
	        
	         
	         // Importing Sample data
	         //DataImporter di = new DataImporter(c);
	         //di.importData();
	        
	        
	         
	         c.close();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Transaction done!");
	     
	}

}
