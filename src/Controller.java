import dao.impls.BillsRepository;
import dao.impls.ProductsRepository;
import entities.Bill;
import entities.Products;
import helper.DefaultScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableColumn<Products, Integer> tdId;
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
    private ObservableList<Products> productsObservableList = FXCollections.observableArrayList();
    @FXML
    private void handleAddProduct(ActionEvent actionEvent) {
        Float price = Float.parseFloat(txtPrice.getText());
        Integer qty = Integer.parseInt(txtQuantity.getText());
        String s = cboSelectNameProduct.getValue().getName();
        productsObservableList.add(new Products(null, s, price, qty));
        tbvAddProduct.getItems().setAll(productsObservableList);
        System.out.println("qty: "+qty);
    }


    @FXML
    private void handleSubmit(ActionEvent actionEvent) {
        System.out.println(productsObservableList);
    }

    @FXML
    private void handleCancel(ActionEvent actionEvent) {
    }

    @FXML
    private void handleChangeHistory(ActionEvent actionEvent) throws Exception {
        Parent history = FXMLLoader.load(getClass().getResource("./billsHistory/billsHistory.fxml"));
        Main.rootStage.setTitle("History");
        Main.rootStage.setScene(new DefaultScene(history));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tdUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tdQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tdPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tdSubTotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        ProductsRepository rp = new ProductsRepository();
        BillsRepository b = new BillsRepository();
        ObservableList<Products> pr = FXCollections.observableArrayList();
        pr.addAll(rp.all());
        cboSelectNameProduct.setItems(pr);
        System.out.println(b.create(new Bill()).getId());
        System.out.println("...");
    }

    public void choose(ActionEvent actionEvent) {
        String s = String.valueOf(cboSelectNameProduct.getValue().getPrice());
        txtPrice.setText(s);
        txtPrice.setEditable(false);
    }
}
