package hust.soict.globalict.aims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Nguyen Thi Hong Anh
 */
public class Aims extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/globalict/aims/Aims.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Aims management application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
