package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import witnesscard.WitnessCardController;

public class Main extends Application {

	public static Stage PrimaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			PrimaryStage = primaryStage;
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(WitnessCardController.class.getResource("AddWitnessCard.fxml"));
			AnchorPane root =(AnchorPane)loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
