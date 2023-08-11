package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.entity.Item;
import lk.ijse.entity.tm.CustomerTM;
import lk.ijse.entity.tm.ItemTM;
import lk.ijse.entity.tm.OrderTM;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.repository.ItemRepository;
import lk.ijse.repository.OrderRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    public AnchorPane orderPane;
    public Label lblOrder;
    public TextField txtPrice;
    public TextField txtQty;
    public Label lblPrice;
    public TableView tbl;
    public TableColumn ColOrderId;
    public TableColumn ColCustId;
    public TableColumn ColItemId;
    public TableColumn ColUnitP;
    public TableColumn ColQty;
    public TableColumn ColPrice;
    public TableColumn ColAction;
    public Label lblDate;
    public ComboBox cmbCust;
    public ComboBox cmbItem;
    OrderRepository orderRepository;
    ItemRepository itemRepository;
    CustomerRepository customerRepository;
    private ObservableList<OrderTM> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setOrderId();
        setItemList();
        setCusIdList();
        setCellValueFactory();
    }

    private void setCusIdList() {
        customerRepository = new CustomerRepository();
        List<Integer> itemList = customerRepository.getCustIDList();
        ObservableList<Integer> dataList = FXCollections.observableArrayList();

        for (Integer ids : itemList) {
            dataList.add(ids);
        }
        cmbCust.setItems(dataList);
    }

    private void setItemList() {
        itemRepository = new ItemRepository();
        List<Integer> itemList = itemRepository.getItemList();
        ObservableList<Integer> dataList = FXCollections.observableArrayList();

        for (Integer ids : itemList) {
            dataList.add(ids);
        }
        cmbItem.setItems(dataList);
    }

    private void setOrderId() {
        orderRepository = new OrderRepository();
        int orderId = orderRepository.getOrderId();
        if( orderId==0)
            lblOrder.setText(String.valueOf(1));
        else
            lblOrder.setText(String.valueOf(orderId+1));
    }

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/view/mainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.orderPane.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Button delete = new Button("Delete");
        delete.setCursor(Cursor.HAND);
        setDeleteBtnOnAction(delete);

        OrderTM orderTM = new OrderTM(Integer.parseInt(lblOrder.getText()), (Integer) cmbCust.getValue(), (Integer) cmbItem.getValue(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText()), Double.parseDouble(lblPrice.getText()), delete);
        obList.add(orderTM);
        tbl.setItems(obList);
    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void tblOnAction(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            Integer custID = (Integer) ColOrderId.getCellData(tbl.getSelectionModel().getSelectedIndex());

            if(custID!=null){
                OrderTM orderTM = (OrderTM) tbl.getSelectionModel().getSelectedItem();
                lblOrder.setText(String.valueOf(orderTM.getOrderId());
                cmbCust.setValue(orderTM.getCustId());
                cmbItem.setValue(customerTM.getAddress());
                txtPrice.setText(customerTM.getContact());
                txtQty.setText(String.valueOf(customerTM.getSalary()));
                lblPrice.setText(String.valueOf(customerTM.getSalary()));
            }
        }
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void priceOnAction(KeyEvent keyEvent) {
        double total = Double.parseDouble(txtPrice.getText()) * Integer.parseInt(txtQty.getText());
        lblPrice.setText(String.valueOf(total));
    }

    private void setDeleteBtnOnAction(Button deleteButton) {
        deleteButton.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to delete?", yes, no).showAndWait();

            if (result.orElse(no) == yes) {
                int selectedIndex = tbl.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    tbl.getItems().remove(selectedIndex);
                }
            }
        });
    }

    private void setCellValueFactory() {
        ColOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        ColCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        ColItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        ColUnitP.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        ColQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        ColAction.setCellValueFactory(new PropertyValueFactory<>("button"));
    }
}
