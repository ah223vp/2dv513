package rottenPotatoes.view;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BookListItem extends HBox {
	
	public BookListItem () {
		
		this.minWidth(600);
		this.minHeight(50);
		//this.setStyle("-fx-border-size: 5px");
		//this.setStyle("-fx-border-color: black");
		for(int i = 0; i < 6; i++) {
			this.getChildren().add(new BookListItemBox());
		}
		
		
		
	}
	

}
