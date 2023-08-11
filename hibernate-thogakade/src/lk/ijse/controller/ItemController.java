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
import lk.ijse.entity.Item;
import lk.ijse.entity.tm.CustomerTM;
import lk.ijse.entity.tm.ItemTM;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.repository.ItemRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    public Label itemCode;
    public TextField txtName;
    public TextField txtQuantity;
    public TableView tbl;
    public TableColumn ColId;
    public TableColumn ColName;
    public TableColumn ColDescription;
    public TableColumn ColQty;
    public TableColumn ColAction;
    public TextField txtDescription;
    public AnchorPane itemPane;
    ItemRepository itemRepository;
    private ObservableList<ItemTM> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAllItem();
        setLblID();
    }


    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/view/mainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.itemPane.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void tblOnAction(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            Integer itemID = (Integer) ColId.getCellData(tbl.getSelectionModel().getSelectedIndex());

            if(itemID!=null){
                ItemTM itemTM = (ItemTM) tbl.getSelectionModel().getSelectedItem();
                itemCode.setText(String.valueOf(itemTM.getId()));
                txtName.setText(itemTM.getName());
                txtDescription.setText(itemTM.getDescription());
                txtQuantity.setText(itemTM.getQtyOnHand());
            }
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Item item = new Item(Integer.parseInt(itemCode.getText()),txtName.getText(), txtDescription.getText(), txtQuantity.getText()  );
        itemRepository = new ItemRepository();
        int savedId = itemRepository.saveItem(item);

        if(savedId>0) {
            getAllItem();
            setLblID();
            clearTxt();
            new Alert(Alert.AlertType.CONFIRMATION, "Item Saved!").show();
        }else
            new Alert(Alert.AlertType.ERROR, "Item Save Failed!").show();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Item item = new Item((Integer) ColId.getCellData(tbl.getSelectionModel().getSelectedIndex()),txtName.getText(), txtDescription.getText(), txtQuantity.getText() );
       itemRepository = new ItemRepository();
        boolean isUpdated = itemRepository.updateItem(item);

        if(isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "Item Updated!").show();
            getAllItem();
            clearTxt();
            setLblID();
        }else
            new Alert(Alert.AlertType.ERROR, "Item Update Failed!").show();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearTxt();
    }

    private void clearTxt() {
        txtName.clear();
        txtQuantity.clear();
        txtDescription.clear();
    }

    private void setLblID() {
        itemRepository = new ItemRepository();
        int itemId = itemRepository.getItemCode();
        if( itemId==0)
            itemCode.setText(String.valueOf(1));
        else
            itemCode.setText(String.valueOf(itemId+1));
    }

    private void getAllItem() {
        tbl.getItems().clear();
        try {
            itemRepository = new ItemRepository();
            List<Item> allItems = itemRepository.getAllItem();
            for (Item items : allItems) {
                Button deleteButton = new Button("Delete");
                deleteButton.setCursor(Cursor.HAND);
                setDeleteBtnOnAction(deleteButton);

                ItemTM itemTM = new ItemTM(items.getId(), items.getName(), items.getDescription(), items.getQtyOnHand(), deleteButton);
                obList.add(itemTM);
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
                itemRepository = new ItemRepository();
                Item item = itemRepository.getItem((Integer) ColId.getCellData(tbl.getSelectionModel().getSelectedIndex()));

                itemRepository = new ItemRepository();
                boolean isDeleted = itemRepository.deleteItem(item);
                if(isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item Deleted!").show();
                    getAllItem();
                    setLblID();

                }else
                    new Alert(Alert.AlertType.ERROR, "Item Delete Failed!").show();
            }
        });
    }

    private void setCellValueFactory() {
        ColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        ColQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        ColAction.setCellValueFactory(new PropertyValueFactory<>("button"));
    }

}
