package lk.ijse.controller;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.entity.Customer;
import lk.ijse.entity.tm.CustomerTM;
import lk.ijse.repository.CustomerRepository;


import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
    public TableColumn ColSalary;
    public TableView tbl;
    CustomerRepository customerRepository;
    private ObservableList<CustomerTM> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCellValueFactory();
        getAllCustomer();
        setLblID();
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

        if(savedId>0) {
            getAllCustomer();
            setLblID();
            clearTxt();
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved!").show();
        }else
            new Alert(Alert.AlertType.ERROR, "Customer Save Failed!").show();


    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Customer customer = new Customer((Integer) ColId.getCellData(tbl.getSelectionModel().getSelectedIndex()),txtName.getText(), txtAddress.getText(), txtContact.getText(), Double.valueOf(txtSalary.getText()) );
        customerRepository = new CustomerRepository();
        boolean isUpdated = customerRepository.updateCustomer(customer);

        if(isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated!").show();
            getAllCustomer();
            clearTxt();
            setLblID();
        }else
            new Alert(Alert.AlertType.ERROR, "Customer Update Failed!").show();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearTxt();
    }

    private void clearTxt() {
        txtName.clear();
        txtAddress.clear();
        ;
        txtContact.clear();
        ;
        txtSalary.clear();
        ;
    }

    private void setCellValueFactory() {
        ColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        ColSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        ColAction.setCellValueFactory(new PropertyValueFactory<>("button"));
    }

    public void getAllCustomer(){
        tbl.getItems().clear();
        try {
            customerRepository = new CustomerRepository();
            List<Customer> allCustomer = customerRepository.getAllCustomer();

            for (Customer cust : allCustomer) {
                Button deleteButton = new Button("Delete");
                deleteButton.setCursor(Cursor.HAND);
                setDeleteBtnOnAction(deleteButton);

                CustomerTM customerTM = new CustomerTM(cust.getId(), cust.getName(), cust.getAddress(), cust.getContact(), cust.getSalary(), deleteButton);
                obList.add(customerTM);
                tbl.setItems(obList);
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void setDeleteBtnOnAction(Button deleteButton) {
        deleteButton.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to delete?", yes, no).showAndWait();

            if (result.orElse(no) == yes) {
                customerRepository = new CustomerRepository();
                Customer customer = customerRepository.getCustomer((Integer) ColId.getCellData(tbl.getSelectionModel().getSelectedIndex()));

                customerRepository = new CustomerRepository();
                boolean isDeleted = customerRepository.deleteCustomer(customer);
                if(isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted!").show();
                    getAllCustomer();
                    setLblID();

                }else
                    new Alert(Alert.AlertType.ERROR, "Customer Delete Failed!").show();
            }
        });
    }

    private void setLblID() {
        customerRepository = new CustomerRepository();
        int customerId = customerRepository.getCustomerId();
        if( customerId==0)
            custId.setText(String.valueOf(1));
        else
            custId.setText(String.valueOf(customerId+1));
    }

    public void tblOnAction(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            Integer custID = (Integer) ColId.getCellData(tbl.getSelectionModel().getSelectedIndex());

            if(custID!=null){
                CustomerTM customerTM = (CustomerTM) tbl.getSelectionModel().getSelectedItem();
                custId.setText(String.valueOf(customerTM.getId()));
                txtName.setText(customerTM.getName());
                txtAddress.setText(customerTM.getAddress());
                txtContact.setText(customerTM.getContact());
                txtSalary.setText(String.valueOf(customerTM.getSalary()));
            }
        }
    }


}

