package billsHistory;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sun.applet.Main;

import java.io.IOException;

public class BillsHistoryController {
    public TextField txtSearch;
    public TableColumn tdNameCustomer;
    public TableColumn tdDate;
    public TableColumn tdId;
    public TableView tbvBill;
    public AnchorPane billList;
    public Button btSearch;

    public void goToNewBill(ActionEvent actionEvent) throws IOException {

    }

    public void handleSearch(ActionEvent actionEvent) {
    }
}
