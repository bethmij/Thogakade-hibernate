package lk.ijse.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.util.OpenView;

import java.io.IOException;
import java.net.URL;

public class MainController {

    public AnchorPane mainPane;

    public void customerOnClick(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/view/customerForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.mainPane.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void itemOnClick(MouseEvent mouseEvent) {
    }

    public void orderOnClick(MouseEvent mouseEvent) {
    }
}
