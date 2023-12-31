package lk.ijse.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenView {

    public void openView(String view, AnchorPane pane){
        Stage stage = (Stage)pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/mainForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle(view);
       // stage.centerOnScreen();
    }

    public static void openView (String view ){
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(OpenView.class.getResource("view/"+view+".fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle(view);
        stage.centerOnScreen();
        stage.show();
    }

}
