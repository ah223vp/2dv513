package rottenPotatoes.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import rottenPotatoes.model.DB_Facade;

/**
 * Handling the results and painting the middle section.
 * @author Andreas
 *
 */
public class ResultHandler {
	
	
	private DB_Facade db;
	private VBox results;

	public ResultHandler(DB_Facade db, VBox results) {
		this.db = db;
		this.results = results;
	}
	
	public void displayAuthorSearch(String query) {
		
		showBooks(db.getAuthorSearch(query));

	}
	public void displayHeaderSearch(String query) {

		showBooks(db.getHeaderSearch(query));

	}

	private void displayEmptySearchResult() {
		
	}
	
	public void displayBookList() {
		showBooks(db.getBookList());

	}
	
	/**
	 * Building the review view.
	 * @param query
	 */
	public void displayReviews(String query) {
		
		ResultSet rs = db.getReviews(query);
		
		try {
			while(rs.next()){
				
				HBox item = new ReviewItem();
				
				((Text) item.getChildren().get(0).lookup("#text")).setText(rs.getString(1));
				((Text) item.getChildren().get(1).lookup("#text")).setText(rs.getString(2));
				((Text) item.getChildren().get(2).lookup("#text")).setText(rs.getString(3));
				
				
				results.getChildren().add(item);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rs);
	}
	/**
	 * Building the book item view.
	 * @param rs
	 */
	private void showBooks(ResultSet rs) {
		try {

			int i = 0;
			while(rs.next()) {
				i++;
				HBox item = new BookListItem();


				// Hardcoded for now
				((Text) item.getChildren().get(0).lookup("#text")).setText(rs.getString(1));
				((Text) item.getChildren().get(1).lookup("#text")).setText(rs.getString(2));
				((Text) item.getChildren().get(2).lookup("#text")).setText(rs.getString(3));
				((Text) item.getChildren().get(3).lookup("#text")).setText(rs.getString(4));
				((Text) item.getChildren().get(4).lookup("#text")).setText(rs.getString(5));


				// Not a good way of doing it but could not get the sql query to work and ran out of time.
				ResultSet score = db.getBookScore(rs.getString(1));
				score.next();
				DecimalFormat d = new DecimalFormat("0.#");
				//long str = Long.parseLong(score.getString(1));

				String str = d.format(Double.parseDouble(score.getString(1)));

				((Text) item.getChildren().get(5).lookup("#text")).setText(str);


				results.getChildren().add(item);
			}
			//System.out.println(db.getBookList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

