package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.project.Gmailer;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class OtpVerificationController implements Initializable {

        @FXML
        private Button btnBack;

        @FXML
        private Button btnVerify;

        @FXML
        private TextField otpField1Txt;

        @FXML
        private TextField otpField2Txt;

        @FXML
        private TextField otpField3Txt;

        @FXML
        private TextField otpField4Txt;

        @FXML
        private ImageView otpPage;

        @FXML
        private TextField txtemail;

        public int otpCode;
        @FXML
        void btnBackOnAction(ActionEvent event) throws IOException {
                switchNavigation("LoginPage.fxml", event);
        }
        @FXML
        void btnVerifyOnAction(ActionEvent event) throws IOException {
                if (verifyOto()) {
                        switchNavigation("LoginPage.fxml", event);
                } else {
                        switchNavigation("Otp.fxml", event);
                }
        }

        @FXML
        public void sendBtnOnAction(ActionEvent event) throws Exception {
                Gmailer.setEmailCom(txtemail.getText(), getOtp());
        }

        private int getOtp() {
                int otp;
                do {
                        Random random = new Random();
                        otp = random.nextInt(9999);
                        if (otp > 1000) {
                                otpCode = otp;
                                return otp;
                        }
                }while (true);
        }

        private final EventHandler<KeyEvent> numericOnlyFilter = event -> {
                char inputChar = event.getCharacter().charAt(0);

                if (!Character.isDigit(inputChar) && inputChar != '\b') {
                        event.consume();
                }
        };

        public boolean verifyOto(){
                int num1 = Integer.parseInt(otpField1Txt.getText());
                int num2 = Integer.parseInt(otpField2Txt.getText());
                int num3 = Integer.parseInt(otpField3Txt.getText());
                int num4 = Integer.parseInt(otpField4Txt.getText());
                int total = num1 * 1000 + num2 * 100 + num3 * 10 + num4;

                return total == otpCode;
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                otpField1Txt.requestFocus();
                otpField1Txt.addEventFilter(KeyEvent.KEY_TYPED, numericOnlyFilter);
                otpField2Txt.addEventFilter(KeyEvent.KEY_TYPED, numericOnlyFilter);
                otpField3Txt.addEventFilter(KeyEvent.KEY_TYPED, numericOnlyFilter);
                otpField4Txt.addEventFilter(KeyEvent.KEY_TYPED, numericOnlyFilter);

                otpField1Txt.setOnKeyReleased(event -> {
                        String input = otpField1Txt.getText().trim();
                        if (input.length() == 1) {
                                otpField2Txt.requestFocus();
                        } else if (input.length() == 0 && event.getCode() == KeyCode.BACK_SPACE) {
                                otpField1Txt.clear();
                                otpField1Txt.requestFocus();
                        }
                });

                otpField2Txt.setOnKeyReleased(event -> {
                        String input = otpField2Txt.getText().trim();
                        if (input.length() == 1) {
                                otpField3Txt.requestFocus();
                        } else if (input.length() == 0 && event.getCode() == KeyCode.BACK_SPACE) {
                                otpField1Txt.requestFocus();
                        }
                });

                otpField3Txt.setOnKeyReleased(event -> {
                        String input = otpField3Txt.getText().trim();
                        if (input.length() == 1) {
                                otpField4Txt.requestFocus();
                        } else if (input.length() == 0 && event.getCode() == KeyCode.BACK_SPACE) {
                                otpField2Txt.requestFocus();
                        }
                });

                otpField4Txt.setOnKeyReleased(event -> {
                        String input = otpField4Txt.getText().trim();
                        if (input.length() == 0 && event.getCode() == KeyCode.BACK_SPACE) {
                                otpField3Txt.requestFocus();
                        }
                });
        }
}