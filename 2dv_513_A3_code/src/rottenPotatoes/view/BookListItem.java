package rottenPotatoes.view;



import javafx.scene.layout.HBox;


/**
 * Building the book item. 
 * @author Andreas
 *
 */
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
