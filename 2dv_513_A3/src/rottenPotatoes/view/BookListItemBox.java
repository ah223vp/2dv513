package rottenPotatoes.view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class BookListItemBox extends StackPane {
	
	public BookListItemBox() {
		
		double width = 100;
		
		//StackPane item = new StackPane();
		
		//this.setWidth(width);
		this.setWidth(100);
		this.setMaxWidth(200);
		
		this.setHeight(20.0);
		
		//Rectangle r = new Rectangle();
		//r.minWidth(width);
		//r.setWidth(width);
		//r.setHeight(20.0);
		
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
		//this.setStyle("-fx-background-color: red");
	}
	
	

}