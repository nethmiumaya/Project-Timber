package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.project.Gmailer;

import java.io.IOException;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class ResetPasswordPageController {

    @FXML
    private Button btnResetPassword;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtNewPassword;
    @FXML
    private TextField txtemail;
    private int otp;

    @FXML
    void ResetPasswordOnAction(ActionEvent event) throws IOException {
        switchNavigation("Otp.fxml", event);
    }

}
