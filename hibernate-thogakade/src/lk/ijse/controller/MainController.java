package lk.ijse.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.util.OpenView;

public class MainController {

    public AnchorPane mainPane;

    public void customerOnClick(MouseEvent mouseEvent) {
        OpenView.openView("customerForm",mainPane);
    }

    public void itemOnClick(MouseEvent mouseEvent) {
    }

    public void orderOnClick(MouseEvent mouseEvent) {
    }
}
