package property;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CustomerListViewController {

	Main main;
	@FXML
	private Button addNewCustomerButton;
	public CustomerListViewController() {
		Main m = new Main();
		this.main = m;
	}
	
	@FXML
	public void onClickAddNewCustomerButton() throws IOException {
		main.showNewCustomerPageView();
	}

}
