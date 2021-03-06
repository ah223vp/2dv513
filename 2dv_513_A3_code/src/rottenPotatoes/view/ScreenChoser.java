package rottenPotatoes.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import rottenPotatoes.model.DB_Facade;

public class ScreenChoser {
	
	
	private BorderPane root;
	private DB_Facade db;
	private LoginScreen loginScreen;
	private Scene scene;
	private SearchScreen searchScreen;

	public ScreenChoser(BorderPane root, DB_Facade db, Scene scene) {
		this.scene = scene;
		this.db = db;
		this.root = root;
		this.loginScreen = new LoginScreen(this.db);
		this.searchScreen  = new SearchScreen(this.db);
		setLoginScreen();
		keyActionLogon();
	}
	
	/**
	 * Logging in and switching screens.
	 * Validation is happening in the model.
	 */
	private void keyActionLogon() {
		
		Button submit = (Button) this.root.lookup("#loginButton");
		submit.setOnAction(e -> {
			System.out.println("Klickade");
			
			// If any one the fields is empty no search to db is needed
			if(((TextField) this.scene.lookup("#userText")).getText().length() == 0 && ((TextField) this.scene.lookup("#passText")).getText().length() == 0) {
				return;
			}
			
			// Verifying response.
			if(this.db.logonAttempt(((TextField) this.scene.lookup("#userText")).getText(), ((TextField) this.scene.lookup("#passText")).getText())) {
				System.out.println("Logging in");
				// Go to next page
				// Set search screen
				setSearchScreen();
			}
			Button logOut = (Button) this.root.lookup("#logOutButton");
			logOut.setOnAction(f -> {
				setLoginScreen();
			});
			
		});
		
		
	}
	private void setSearchScreen() {
		root.setCenter(searchScreen.createSearchScreen());
	}
	
	public void setLoginScreen() {
		root.setCenter(loginScreen.getLoginScreen());
	}

}
