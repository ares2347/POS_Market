package billsHistory;

import dao.impls.BillsRepository;
import entities.Bill;
import entities.Products;
import helper.DefaultScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static helper.RootStage.rootStage;

public class BillsHistoryController implements Initializable {
    public TextField txtSearch;
    public TableColumn tdTotal;
    public TableColumn tdDate;
    public TableColumn tdId;
    public TableColumn<Bill, Button> tdAction;
    public TableView tbvBill;
    public AnchorPane billList;
    public Button btSearch;

    private final ObservableList<Bill> billObservableList = FXCollections.observableArrayList();
    private final BillsRepository billsRepository = new BillsRepository();

    public void goToNewBill(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("../home.fxml"));
        rootStage.setTitle("New Bill");
        rootStage.setScene(new DefaultScene(p));
    }

    public void handleSearch(ActionEvent actionEvent) {
        if (txtSearch.getText().isEmpty()) {
            billObservableList.setAll(billsRepository.all());
        } else {
            billObservableList.setAll(billsRepository.findById(Integer.parseInt(txtSearch.getText())));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        billObservableList.setAll(billsRepository.all());

        tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdDate.setCellValueFactory(new PropertyValueFactory<>("datetime"));
        tdTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        tdAction.setCellValueFactory(new PropertyValueFactory<Bill, Button>("view"));
        tbvBill.setItems(billObservableList);
    }
}
