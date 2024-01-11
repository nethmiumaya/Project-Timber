package lk.ijse.project.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.project.utill.Navigation;

import java.io.IOException;

public class SignUpPageController {

        public AnchorPane paneSignup;
        @FXML
        private Button Sign_Up;

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtPassword;

        @FXML
        private TextField txtforgot;

        @FXML
        private TextField txtuser;
        private AnchorPane root;

//        @FXML
//
    public void btnsignUpOnAction(ActionEvent actionEvent) throws IOException {
           Navigation.switchNavigation("LoginPage.fxml", actionEvent);
    }

}



