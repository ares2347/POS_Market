package billDetails;

import helper.DefaultScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sun.applet.Main;

import java.io.IOException;

public class BillDetailsController {
    public Text txBillId;
    public Text txDate;
    public TableView tbvBillProduct;
    public TableColumn tdName;
    public TableColumn tdUnit;
    public TableColumn tdQuantity;
    public TableColumn tdPrice;
    public TableColumn tdSubTotal;
    public Text txTotal;
    public AnchorPane apBillDetails;
    public Text txMartketName;
    public Button btNewBill;
    public Button btHistory;
    public Text txAddress;

    public void goToNewBill(ActionEvent actionEvent) {
    }

    public void goToHistory(ActionEvent actionEvent) throws Exception {
    }
}
