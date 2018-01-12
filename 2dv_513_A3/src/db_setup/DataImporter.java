package db_setup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataImporter {
	
	private Connection c;

	public DataImporter(Connection c) {
		this.c = c;
	}
	
	public void importData() {
		
		String userStatement = 
				"INSERT INTO USERS" + 
						"(USERNAME,PASSWORD,NAME) VALUES" +
						"(?,?,?);";
		String bookStatement = 
				"INSERT INTO BOOKS" + 
						"(ISBN,TITLE,AUTHOR,DESCRIPTION,PUBLISHEDDATE) VALUES" +
						"(?,?,?,?,?);";
		String scoreStatement = 
				"INSERT INTO SCORE" + 
						"(ISBN,USERNAME,SCORE) VALUES" +
						"(?,?,?);";
		String reviewStatement = 
				"INSERT INTO REVIEWs" + 
						"(ISBN,USERNAME,REVIEW) VALUES" +
						"(?,?,?);";
				
		
		
			try {
				PreparedStatement userPrep = c.prepareStatement(userStatement);
				PreparedStatement bookPrep = c.prepareStatement(bookStatement);
				PreparedStatement reviewPrep = c.prepareStatement(reviewStatement);
				PreparedStatement scorePrep = c.prepareStatement(scoreStatement);
				
				String[][] users = users();
				String[][] books = books();
				String[][] reviews = reviews();
				
				
				// Inserting data
				
				importLoopStrings(userPrep, users);
				importLoopStrings(bookPrep, books);
				importLoopStrings(reviewPrep, reviews);
				insertScore(scorePrep);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			

	}
	private void importLoopStrings(PreparedStatement prep, String[][] arr) {
		
		try {
		for(int i = 0; i < arr.length; i++ ) {
			for(int j = 0; j < arr[i].length; j++) {
				
					prep.setString((j+1), arr[i][j]);
				
			}
			prep.addBatch();
		}
		
		prep.executeBatch();
		prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private String[][] users() {
		String[][] users = 
			{{"tester1", "123", "Andreas"}, {"tester2", "123", "Anton"},{"tester3", "123", "Hannah"}};
		return users;
	}
	private String[][] books(){
		String[][] books = 
			{{"9780434003488","The Hitchiker's guide to the galaxy", "Douglas Adams", "First a legendary radio series, then a bestselling book, now a blockbuser movie, the immensely successful Hitch Hiker's Guide to the Galaxy needs no introduction.","1995-10" },
			{"9780765326379", "Oathbringer: Book Three of the Stormlight Archive","Brandon Sanderson", "In Oathbringer, the third volume of the New York Times bestselling Stormlight Archive, humanity faces a new Desolation with the return of the Voidbringers, a foe with numbers as great as their thirst for vengeance.","2017-11"},
			{"9781250166548", "Edgedancer: From the Stormlight Archive","Brandon Sanderson", "From #1 New York Times bestselling author Brandon Sanderson, a special gift edition of Edgedancer, a short novel of the Stormlight Archive (previously published in Arcanum Unbounded). Three years ago, Lift asked a goddess to stop her from growing older--a wish she believed was granted. Now, in Edgedancer, the barely teenage nascent Knight Radiant finds that time stands still for no one.","2017-10"},
			{"9780553392951", "Assassin's Fate: Book III of the Fitz and the Fool Trilogy","Robin Hobb", "More than twenty years ago, the first epic fantasy novel featuring FitzChivalry Farseer and his mysterious, often maddening friend the Fool struck like a bolt of brilliant lightning. Now New York Times bestselling author Robin Hobb brings to a momentous close the third trilogy featuring these beloved characters in a novel of unsurpassed artistry that is sure to endure as one of the great masterworks of the genre.","2017-05"},
			{"9780007562251", "Assassin's Apprentice","Robin Hobb", "A glorious classic fantasy combining the magic of Ursula Le Guin's The Wizard of Earthsea with the epic mastery of Tolkien's The Lord of the Rings.\r\n" + 
					"In a faraway land where members of the royal family are named for the virtues they embody, one young boy will become a walking enigma. Born on the wrong side of the sheets, Fitz, son of Chivalry Farseer, is a royal bastard cast out into the world, friendless and lonely. \r\n" + 
					"Only his magical link with animals - the old art known as the Wit - gives him solace and companionship.", "2014-03"},
			{"9781406372151", "The Hate U Give", "Angie Thomas", "A powerful and brave YA novel about what prejudice looks like in the 21st century.Sixteen-year-old Starr lives in two worlds: the poor neighbourhood where she was born and raised and her posh high school in the suburbs.","2017-03"}
			};
		
		return books;
	}
	private String[][] reviews(){
		String[][] reviews = 
			{		{"9780434003488", "tester1", "Book was good"},
					{"9780434003488", "tester2", "42 is everything!"},
					{"9780434003488", "tester3", "Amazing!!!"},
					{"9780765326379", "tester1", "Nice one"},
					{"9781250166548", "tester1", "Exciting book!"},
					{"9780553392951", "tester1", "Very good"},
					{"9780553392951", "tester2", "I liked it"},
					{"9780007562251", "tester2", "Not the best one"},
					{"9781406372151", "tester1", "Wiiio"}
			};
		
		return reviews;
	}
	
	// Yuck..
	private void insertScore(PreparedStatement prep) {
		
		// Ugliest thing I will ever make but it will due for now.
		
		try {
			prep.setString(1, "9780434003488");
			prep.setString(2, "tester1");
			prep.setInt(3, 5);
			prep.addBatch();
			
			prep.setString(1, "9780434003488");
			prep.setString(2, "tester2");
			prep.setInt(3, 5);
			prep.addBatch();
			
			prep.setString(1, "9780434003488");
			prep.setString(2, "tester3");
			prep.setInt(3, 5);
			prep.addBatch();
			
			prep.setString(1, "9780765326379");
			prep.setString(2, "tester1");
			prep.setInt(3, 3);
			prep.addBatch();
			
			prep.setString(1, "9780765326379");
			prep.setString(2, "tester2");
			prep.setInt(3, 1);
			prep.addBatch();
			
			prep.setString(1, "9780007562251");
			prep.setString(2, "tester1");
			prep.setInt(3, 1);
			prep.addBatch();
			
			prep.setString(1, "9780007562251");
			prep.setString(2, "tester3");
			prep.setInt(3, 2);
			prep.addBatch();
			
			prep.setString(1, "9780007562251");
			prep.setString(2, "tester2");
			prep.setInt(3, 2);
			prep.addBatch();
			
			prep.setString(1, "9781406372151");
			prep.setString(2, "tester1");
			prep.setInt(3, 2);
			prep.addBatch();
			
			prep.setString(1, "9781406372151");
			prep.setString(2, "tester2");
			prep.setInt(3, 2);
			prep.addBatch();
			
			prep.setString(1, "9781406372151");
			prep.setString(2, "tester3");
			prep.setInt(3, 3);
			prep.addBatch();
			
			prep.setString(1, "9781250166548");
			prep.setString(2, "tester3");
			prep.setInt(3, 3);
			prep.addBatch();
			
			prep.setString(1, "9781250166548");
			prep.setString(2, "tester1");
			prep.setInt(3, 4);
			prep.addBatch();
			
			prep.setString(1, "9780553392951");
			prep.setString(2, "tester1");
			prep.setInt(3, 5);
			prep.addBatch();
			
			prep.setString(1, "9780553392951");
			prep.setString(2, "tester2");
			prep.setInt(3, 2);
			prep.addBatch();
			
			System.out.println("Executing inserts");
			prep.executeBatch();
			prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
