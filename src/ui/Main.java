package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ball-bouncing-pane.fxml"));
		Parent root = loader.load();
		
		BallBouncingGUI bbg = loader.getController();
		bbg.setStage(stage);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Ball bouncing with common threads on a pane node plus a special thread updating the GUI");
		stage.show();
	}

}
