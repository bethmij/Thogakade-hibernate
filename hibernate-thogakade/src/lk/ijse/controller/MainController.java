package lk.ijse.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.entity.Customer;
import lk.ijse.util.OpenView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.net.URL;

public class MainController {
    Session session;

    public AnchorPane mainPane;

    public MainController(){
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }

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
