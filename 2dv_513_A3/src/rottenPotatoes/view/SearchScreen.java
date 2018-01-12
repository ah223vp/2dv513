package rottenPotatoes.view;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import rottenPotatoes.model.DB_Facade;

public class SearchScreen {
	
	private DB_Facade db;
	private VBox results;

	public SearchScreen(DB_Facade db) {
		this.db = db;
		
	}
	
	public BorderPane createSearchScreen() {
		
		BorderPane root = new BorderPane();
		
		results = new VBox();
		
		ResultHandler res = new ResultHandler(this.db, results);

		
		TextField input = new TextField("Search text here");
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
		
		Button reviews = new Button();
		reviews.setText("BookReviews");
		
		Button myReviews = new Button();
		myReviews.setText("My reviews");
		
		Button myScores = new Button();
		myScores.setText("My scores");
		
		Button logOut = new Button();
		logOut.setText("Log out");
		logOut.setId("logOutButton");
		
		HBox buttons = new HBox();
		
		buttons.getChildren().addAll(author, title, bookScore, reviews,myReviews,myScores,logOut);
		
		
		root.setTop(input);
		
		// Put the results in the center and manipulate that one.
		
		ScrollPane sc = new ScrollPane();
		sc.setContent(results);
		root.setCenter(sc);
		
		root.setBottom(buttons);
		
		
		return root;
	}
	private void clearChildren() {
		results.getChildren().clear();
	}
}
