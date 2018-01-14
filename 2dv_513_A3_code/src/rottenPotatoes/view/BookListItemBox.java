package rottenPotatoes.view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Creating the boxes for the book list item. Building blocks for search results.
 * @author Andreas
 *
 */
public class BookListItemBox extends StackPane {
	
	public BookListItemBox() {
		
		double width = 100;
		
		this.setWidth(width);
		this.setMaxWidth(200);
		
		this.setHeight(20.0);

		Label l = new Label();
		
		l.setWrapText(true);
		l.setId("#text");
	
		Text t = new Text();
		t.setWrappingWidth(200);
		t.setTextAlignment(TextAlignment.CENTER);
		t.setId("text");
		this.getChildren().addAll(t);
		this.setStyle("-fx-border-size: 3px");
		this.setStyle("-fx-border-color: black");
		
	}
	
	

}