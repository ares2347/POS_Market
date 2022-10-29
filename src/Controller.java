import dao.impls.Repository;
import entities.Products;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
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

    @FXML
    private void handleAddProduct(ActionEvent actionEvent) {
        Float price = Float.parseFloat(txtPrice.getText());
        Integer qty = Integer.parseInt(txtQuantity.getText());
        String s = cboSelectNameProduct.getValue().getName();
        Products newProducts = new Products(null, s, price, qty);

        tbvAddProduct.getItems().add(newProducts);

        System.out.println("qty: "+qty);
    }


    @FXML
    private void handleSubmit(ActionEvent actionEvent) {
    }

    @FXML
    private void handleCancel(ActionEvent actionEvent) {
    }

    @FXML
    private void handleChangeHistory(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tdName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tdUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tdQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tdPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tdSubTotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));


        Repository rp = new Repository();
        ObservableList<Products> pr = FXCollections.observableArrayList();
        pr.addAll(rp.all());
        cboSelectNameProduct.setItems(pr);
        System.out.println("...");

    }

    public void choose(ActionEvent actionEvent) {
        String s = String.valueOf(cboSelectNameProduct.getValue().getPrice());
        txtPrice.setText(s);
        txtPrice.setEditable(false);
    }
}
