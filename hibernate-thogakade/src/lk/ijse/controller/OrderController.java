package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.entity.tm.OrderTM;

import java.io.IOException;
import java.net.URL;

public class OrderController {
    public AnchorPane orderPane;
    public Label lblOrder;
    public TextField txtPrice;
    public TextField txtQty;
    public JFXComboBox cmbCust;
    public JFXComboBox cmbItem;
    public Label lblPrice;
    public TableView tbl;
    public TableColumn ColOrderId;
    public TableColumn ColCustId;
    public TableColumn ColItemId;
    public TableColumn ColUnitP;
    public TableColumn ColQty;
    public TableColumn ColPrice;
    public TableColumn ColAction;

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/view/mainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.orderPane.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
       // OrderTM orderTM = new OrderTM(Integer.parseInt(lblOrder.getText()), Integer.parseInt((String) cmbCust.getValue()), Integer.parseInt((String) cmbItem.getValue()), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText()), Double.parseDouble(lblPrice.getText()));
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void tblOnAction(MouseEvent mouseEvent) {
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }
}
