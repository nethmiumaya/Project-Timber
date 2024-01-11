package lk.ijse.project.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static lk.ijse.project.utill.Navigation.switchNavigation;


public class ForgotPasswordController {

    @FXML
    private Button btnResetPassword;

    @FXML
    private TextField txtUsername;

    public void btnResetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        switchNavigation("Otp.fxml", actionEvent);
    }
}
