package rottenPotatoes.view;

import javafx.scene.layout.HBox;

/**
 * Creating a item to containg the review data.
 * @author Andreas
 *
 */
public class ReviewItem extends HBox {
	
	public ReviewItem() {
		
		for(int i = 0; i < 3; i++) {
			this.getChildren().add(new BookListItemBox());
		}
		
	}

}
