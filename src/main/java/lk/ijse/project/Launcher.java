package lk.ijse.project;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = load(getClass().getResource("/view/LoginPage.fxml"));
        stage.setScene(new Scene(root));
       // stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
