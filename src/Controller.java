import dao.impls.ProductsRepository;
import entities.Products;
import helper.DefaultScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;

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
    public Button test;
    ObservableList<Products> pr = FXCollections.observableArrayList();

    public float finalCost(){
        float total = 0;
        for (Products p: pr) {
            float entryCost = p.getQuantity() * p.getPrice();
            total = total + entryCost;
        }
        return total;
    }
    @FXML
    private void handleAddProduct(ActionEvent actionEvent) {
        float total = 0;
        Float price = Float.parseFloat(txtPrice.getText());
        Integer qty = Integer.parseInt(txtQuantity.getText());
        String s = cboSelectNameProduct.getValue().getName();
        Products newProducts = new Products(null, s, price, qty);

        pr.add(newProducts);
        tbvAddProduct.getItems().add(newProducts);
//        total = qty * price;
//        finalCost = finalCost + total;
        txTotal.setText(String.valueOf(finalCost()));


    }



    @FXML
    private void handleSubmit(ActionEvent actionEvent) {
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

//        test.setOnAction(e -> {
//            this.txTotal.setText(String.valueOf(finalCost()));
//        });
//        tbvAddProduct.setItems(pr);

//        for (Products p : pr) {
//            finalCost = finalCost + p.getSubtotal();
//            System.out.println("FinalCost: "+finalCost);
//        }
//                this.txTotal.setText(String.valueOf(finalCost));

        ProductsRepository rp = new ProductsRepository();
        ObservableList<Products> pr = FXCollections.observableArrayList();
        pr.addAll(rp.all());
        cboSelectNameProduct.setItems(pr);
        tbvAddProduct.setEditable(true);

        tdQuantity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tdQuantity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Products, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Products, Integer> event) {
                float total = 0;
                Products pr = event.getRowValue();
                pr.setQuantity(event.getNewValue());

                tbvAddProduct.refresh();
                txTotal.setText(String.valueOf(finalCost()));


            }
        });
    }

    public void choose(ActionEvent actionEvent) {
        String s = String.valueOf(cboSelectNameProduct.getValue().getPrice());
        txtPrice.setText(s);
        txtPrice.setEditable(false);
    }
}
