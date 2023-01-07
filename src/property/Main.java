package property;

import java.io.IOException;
import java.util.ArrayList;

import filehandler.CSVReader;
import filehandler.DeserializePropertyList;
import filehandler.SerializeChildList;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import property.models.Property;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set up the main layout
		this.primaryStage = primaryStage;
		 showHomePage();
//		showPropertyListView();

	}
	
	public void showHomePage() throws IOException {
		showMainView();
		showMainItems();
	}

	private void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainItems.fxml"));
		BorderPane  mainItems = loader.load();
		mainLayout.setCenter(mainItems);

		ArrayList<Property> list = new ArrayList<Property>(); 
		list = DeserializePropertyList.readChildList();

		CSVReader csvReader = new CSVReader();
		csvReader.setCsvFile("House_Rent_Dataset.csv");
		csvReader.fileRead();


	}

	private void showMainView() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
		mainLayout = loader.load();

		// Set the scene
		this.primaryStage.setTitle("Rental House App");
		Scene scene = new Scene(mainLayout);
		this.primaryStage.setScene(scene);
		this.primaryStage.show();

	}

	public void showPropertyListView() throws IOException {

		System.out.println("showPropertyListView Clicked");
 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/PropertyListView.fxml"));
//		mainLayout = loader.load();
		BorderPane  mainItems = loader.load();
		mainLayout.setCenter(mainItems);

	}

	public void showAddPropertyView() throws IOException {

		//        System.out.println("Clicked");

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/NewPropertyForm.fxml"));
		BorderPane newProperty = loader.load();

		Stage addDialougeStage = new Stage();
		addDialougeStage.setTitle("Add Propery");
		addDialougeStage.initModality(Modality.WINDOW_MODAL);
		addDialougeStage.initOwner(primaryStage);
		Scene sceen = new Scene(newProperty);
		addDialougeStage.setScene(sceen);
		addDialougeStage.show();
	} 


	public static void main(String[] args) {
		launch(args);
	}

}
