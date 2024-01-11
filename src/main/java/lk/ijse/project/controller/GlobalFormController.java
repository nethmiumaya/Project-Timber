package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.project.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static lk.ijse.project.utill.Navigation.switchNavigation;
import static lk.ijse.project.utill.Navigation.switchPaging;

public class GlobalFormController implements Initializable {

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnbooking;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btndashboard;

    @FXML
    private Button btnemployee;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnorders;

    @FXML
    public AnchorPane paneId;

    @FXML
    private Button btnEmployeeAttendance;
    @FXML
    void btnBookingOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"BookingDetailForm.fxml");
    }
    @FXML
    void btnEmployeeAttendanceOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"EmployeeAttendance.fxml");
    }
    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"CustomerForm.fxml");
    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"DeliverDetail.fxml");
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
    switchPaging(paneId,"EmployeeManage.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"LoginPage.fxml");
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"CustomerOrderDetailForm.fxml");
    }


    @FXML
    void btnStockOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"StockDetail.fxml");
    }

    @FXML
    void btnaddcustomerOnAction(ActionEvent event) throws IOException {
        switchPaging(paneId,"AddCustomerForm.fxml");
    }

    @FXML
    void btndashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(paneId,"DasboardForm.fxml");
    }
    private static GlobalFormController controller;

    public GlobalFormController(){
        controller = this;
    }

    public static GlobalFormController getInstance(){
        return controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Navigation.switchPaging(paneId,"DasboardForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
