package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction(){
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartmentAction(){
		loadView("/gui/DepartmentList.fxml");
	}
	
	@FXML
	public void onMenuItemAboutAction(){
		loadView("/gui/About.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
	}
	
	private synchronized void loadView(String absolutName){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVbox = loader.load();
			
			Scene mainScene = Main.getScene();
			VBox mainBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainBox.getChildren().get(0);
			mainBox.getChildren().clear();
			mainBox.getChildren().add(mainMenu);
			mainBox.getChildren().addAll(newVbox.getChildren());
		}
		
		catch(IOException e){
			Alerts.showAlert("IO exeption", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
		
	}
}
