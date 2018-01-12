package rottenPotatoes;

import rottenPotatoes.model.DB_Facade;
import rottenPotatoes.view.Window;

public class Rottenpotatoes {

	
	// entry point to application
	
	public static void main(String[] args) {
		
		
		DB_Facade db = new DB_Facade();
		db.connectToDB();
		
		//Window w = new Window(db);
		
		
		//Window.launch(Window.class);

	}

}
