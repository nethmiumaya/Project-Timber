package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.LoginBo;
import lk.ijse.project.Dao.Custom.Impl.LoginDaoImpl;
import lk.ijse.project.Dao.Custom.LoginDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class loginPageController {

    @FXML
    private ImageView LogIn;

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane root;

    @FXML
    private Label txtForgorPassword;

    @FXML
    public TextField txtPassword;

    @FXML
    private Label txtSignUp;

    @FXML
    public TextField txtUsername;

    LoginBo loginBo = (LoginBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Login);
    @FXML
    void btnLoginOnAction(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {


                boolean isValidAdmin =
                        loginBo.loginusername(txtUsername.getText(),txtPassword.getText());
                if (isValidAdmin){
                    Navigation.switchNavigation("globalForm.fxml", event);
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid User id or Password Please try again!!!").show();
                    txtUsername.clear();
                    txtPassword.clear();

                }
            }


    @FXML
    void txtForgotPassword(MouseEvent actionEvent) throws IOException {
        switchNavigation("Otp.fxml",actionEvent);
    }

    @FXML
    void txtSignUp(MouseEvent actionEvent) throws IOException {
        switchNavigation("SignUp.fxml", actionEvent);

    }

}
