package rottenPotatoes.view;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import rottenPotatoes.model.DB_Facade;
import javafx.scene.text.Text;

public class LoginScreen {
	
	private DB_Facade db;
	private BorderPane loginScreen;
	
	public LoginScreen(DB_Facade db) {
		this.db = db;
		createLoginScreen();
	}
	public void createLoginScreen() {
		
		BorderPane login = new BorderPane();
		
		Label username = new Label("Username:");
		Label password = new Label("Password:");
		
		TextField userText = new TextField();
		userText.setId("userText");
		TextField passText = new TextField();
		passText.setId("passText");
		
		Button submit = new Button();
		submit.setId("loginButton");
		submit.setText("Submit");
		
		
		
		
		//login.setStyle("-fx-background-color: green;");
		
		HBox button = new HBox();
		button.getChildren().add(submit);
		
		VBox input = new VBox();
		input.setSpacing(10);
		input.getChildren().addAll(userText, passText);
		
		VBox labels = new VBox();
		labels.setSpacing(10);
		labels.getChildren().addAll(username, password);
		
		Text t = new Text("Default login:"+"\n" + "tester1" + "\n" + "123" );
		
		login.setTop(t);
		login.setRight(input);
		login.setLeft(labels);
		login.setBottom(submit);
		
		login.setMaxSize(200, 200);
		
		
		this.loginScreen = login;
		
	}
	public BorderPane getLoginScreen() {
		return loginScreen;
	}
}
