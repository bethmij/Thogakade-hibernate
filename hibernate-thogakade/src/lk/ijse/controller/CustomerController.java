package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.entity.Customer;
import lk.ijse.repository.CustomerRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public TableColumn ColId;
    public TableColumn ColName;
    public TableColumn ColAddress;
    public TableColumn ColContact;
    public TableColumn ColAction;
    public AnchorPane customerPane;
    public Label custId;
    public TextField txtSalary;
    CustomerRepository customerRepository = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerRepository = new CustomerRepository();
        int customerId = customerRepository.getCustomerId();
        if( customerId==0)
            custId.setText(String.valueOf(1));
        else
            custId.setText(String.valueOf(customerId));
    }

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/view/mainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.customerPane.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Customer customer = new Customer(Integer.parseInt(custId.getText()),txtName.getText(), txtAddress.getText(), txtContact.getText(), Double.valueOf(txtSalary.getText()) );
        customerRepository = new CustomerRepository();
        int savedId = customerRepository.saveCustomer(customer);

        if(savedId>0)
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved!").show();
        else
            new Alert(Alert.AlertType.ERROR, "Customer Saved Failed!").show();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }


}
