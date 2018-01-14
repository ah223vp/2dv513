package rottenPotatoes.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.Node;
import rottenPotatoes.model.DB_Facade;

/**
 * Main class to handle the searchScreen
 * Switching views depending on searches
 * @author Andreas
 *
 */
public class SearchScreen {
	
	private DB_Facade db;
	private VBox results;

	public SearchScreen(DB_Facade db) {
		this.db = db;
		
	}
	
	/**
	 * Handling the different searches and contains all the eventhandlers.
	 * @return
	 */
	public BorderPane createSearchScreen() {
		
		BorderPane root = new BorderPane();
		
		results = new VBox();
		
		ResultHandler res = new ResultHandler(this.db, results);
		
		
		/**
		 * Handler for clicking the the book and showing the reviews.
		 */
		results.setOnMouseClicked(e ->{
			
			
			Node ee = (Node) e.getTarget();
			
			if(ee.getId() != null) {
				Text t = (Text) ee;
				
				// Check so the text is only digits and an isbn number
				if(t.getText().matches("^\\d+$")) {
					clearChildren();
					
					res.displayReviews(t.getText());
				}else 
					return;
				
				
			}
			
		
		});
		
		VBox header = new VBox();
		Text t = new Text("Click a books isbn to read its reviews!");
		TextField input = new TextField("Search text here");
		input.setMaxWidth(300);
		
		header.getChildren().addAll(t,input);
		
		input.setOnMouseClicked(e ->{
			input.clear();
		});
		
		
		Button author = new Button();
		author.setText("Search by author");
		author.setOnAction(e ->{
			clearChildren();
			res.displayAuthorSearch(input.getText());
			
		});
		
		Button title = new Button();
		title.setText("Search by title");
		title.setOnAction(e ->{
			clearChildren();
			res.displayHeaderSearch(input.getText());
		});
		
		Button bookScore = new Button();
		bookScore.setText("List Books");
		bookScore.setOnAction(e -> {
			clearChildren();
			res.displayBookList();
			
		});
		
		
		Button logOut = new Button();
		logOut.setText("Log out");
		logOut.setId("logOutButton");
		
		HBox buttons = new HBox();
		
		buttons.getChildren().addAll(author, title, bookScore,logOut);
		
		
		//root.setTop(input);
		
		root.setTop(header);
		
		// Put the results in the center and manipulate that one.
		
		ScrollPane sc = new ScrollPane();
		sc.setContent(results);
		root.setCenter(sc);
		
		root.setBottom(buttons);
		
		
		return root;
	}
	/**
	 * Clearing the window between searches.
	 */
	private void clearChildren() {
		results.getChildren().clear();
	}
}
