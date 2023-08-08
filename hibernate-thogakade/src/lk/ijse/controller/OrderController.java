package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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

    public void navigateToHome(MouseEvent mouseEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void tblOnAction(MouseEvent mouseEvent) {
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }
}
