package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToMain(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);	
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToNhanKhau(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/controller/nhankhau/NhanKhau.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);	
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToHoKhau(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/controller/hokhau/HoKhau.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);	
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToKhoanPhi(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/controller/khoanthu/KhoanPhi.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);	
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToNopTien(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/controller/noptien/NopTien.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);	
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToThongKe(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/controller/thongke/ThongKe.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);	
        stage.setScene(scene);
        stage.show();
	}
}
