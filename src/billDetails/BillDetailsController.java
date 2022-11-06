package billDetails;

import helper.DefaultScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import static helper.RootStage.rootStage;
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

    public void goToNewBill(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("../home.fxml"));
        rootStage.setTitle("New Bill");
        rootStage.setScene(new DefaultScene(p));
    }

    public void goToHistory(ActionEvent actionEvent) throws Exception {
        Parent p = FXMLLoader.load(getClass().getResource("../billsHistory/billsHistory.fxml"));
        rootStage.setTitle("History");
        rootStage.setScene(new DefaultScene(p));
    }
}
