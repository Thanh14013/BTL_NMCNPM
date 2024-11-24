package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/login/Login.fxml"));

			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(e -> {
				e.consume();
				logout(primaryStage);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(Stage stage) {
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("Are you sure you want to logout?");
		alert.setContentText("Do you want to save changes before exiting?");
		if (alert.showAndWait().get().getText().equals("OK")) {
			
			System.out.println("Sucessfully Logout");
			stage.close();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
