package rottenPotatoes.view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rottenPotatoes.model.DB_Facade;

public class Window extends Application{
	
	final int WIDTH = 1200;
	final int HEIGHT = 600;
	final String title = "Rotten tomatoes";
	private DB_Facade db;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		startApplication();
		BorderPane root = new BorderPane();

		
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		
		ScreenChoser sc = new ScreenChoser(root, this.db, scene);

		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void startApplication() {
		DB_Facade db = new DB_Facade();
		db.connectToDB();
		
		this.db = db;
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
	

}
