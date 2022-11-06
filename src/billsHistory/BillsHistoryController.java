package billsHistory;

import helper.DefaultScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static helper.RootStage.rootStage;

public class BillsHistoryController {
    public TextField txtSearch;
    public TableColumn tdNameCustomer;
    public TableColumn tdDate;
    public TableColumn tdId;
    public TableView tbvBill;
    public AnchorPane billList;
    public Button btSearch;

    public void goToNewBill(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("../home.fxml"));
        rootStage.setTitle("New Bill");
        rootStage.setScene(new DefaultScene(p));
    }

    public void handleSearch(ActionEvent actionEvent) {
    }
}
