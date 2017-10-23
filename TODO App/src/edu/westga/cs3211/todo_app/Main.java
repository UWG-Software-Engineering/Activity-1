package edu.westga.cs3211.todo_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/** TODO App entry point.
 * 
 * @author CS3211
 * @version Fall2017
 */
public class Main extends Application {
	private static final String STAGE_TITLE = "TODO App";
	private static final String GUI_RESOURCE = "view/MainWindow.fxml";

	/** JavaFX entry point.
	 * 
	 *  @precondition none
	 *  @postcondition none
	 *  
	 *  @param primaryStage the main window hook
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource(Main.GUI_RESOURCE));
		Scene scene = new Scene(parent);
		primaryStage.setTitle(Main.STAGE_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/** Java entry point
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Main.launch(args);
	}
}
