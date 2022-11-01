import dao.impls.Repository;
import entities.Products;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable {
    public Pane home;



    public Button addProducts;
    public Button addBill;
    public Button handleCancel;
    public Button handleHistory;
    @FXML
    private TableColumn<Products, Initializable> tdId;
    @FXML
    private TableColumn<Products, String> tdName;
    @FXML
    private TableColumn tdUnit;
    @FXML
    private TableColumn tdQuantity;
    @FXML
    private TableColumn<Products, Float> tdPrice;
    @FXML
    private TableColumn tdSubTotal;
    @FXML
    private Text txTotal;
    @FXML
    private TableView<Products> tbvAddProduct;
    @FXML
    private ComboBox<Products> cboSelectNameProduct;
    @FXML
    private TextField txtQuantity;
    @FXML
    private TextField txtPrice;
    public Text txVailidate;

    public TextField getTxtQuantity() {
        return txtQuantity;
    }

    void checkValidate() throws Exception {
        String check = txtQuantity.getText();
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(check);
        txVailidate.setVisible(false);

        if(((check.length() == 0) || !(matcher.matches()) || Integer.parseInt(check)==0  )) {
            txtQuantity.setStyle("-fx-border-color: red; -fx-border-width: 3px");
            txVailidate.setVisible(true);
        }else
            txtQuantity.setStyle(null);

    }

    @FXML
    private void handleAddProduct(ActionEvent actionEvent) throws Exception {
        checkValidate();
    }

    @FXML
    private void handleSubmit(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("billDetails/billDetails.fxml"));
        Main.rootStage.setTitle("History");
        Main.rootStage.setScene(new Scene(listBook,1280,800));
    }

    @FXML
    private void handleCancel(ActionEvent a) throws Exception {
        tbvAddProduct.setItems(null);
    }

    @FXML
    private void handleChangeHistory(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("billsHistory/billsHistory.fxml"));
        Main.rootStage.setTitle("History");
        Main.rootStage.setScene(new Scene(listBook,1280,800));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Repository rp = new Repository();
        ObservableList<Products> pr = FXCollections.observableArrayList();
        ObservableList<Products> pr2 = FXCollections.observableArrayList();
        pr.addAll(rp.all());
        cboSelectNameProduct.setItems(pr);

    }
}
