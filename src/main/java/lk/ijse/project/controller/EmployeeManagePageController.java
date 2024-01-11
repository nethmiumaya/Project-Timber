package lk.ijse.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.EmployeeManageBo;
import lk.ijse.project.Dao.Custom.EmployeeManageDao;
import lk.ijse.project.Dao.Custom.Impl.EmployeeManageDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.EmployeeMmanage;
import lk.ijse.project.Dto.Tm.EmployeeTm;
import lk.ijse.project.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class EmployeeManagePageController {

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnEmployeeAttendance;

    @FXML
    private Button btnEmployeeManage;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnaddemployee;

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
    private Button btnsearch;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colempid;

    @FXML
    private TableColumn<?, ?> colfirstname;

    @FXML
    private TableColumn<?, ?> coljoindate;

    @FXML
    private TableColumn<?, ?> collastname;

    @FXML
    private TableColumn<?, ?> colnic;

    @FXML
    private TableColumn<?, ?> colteleno;

    @FXML
    private TableView<EmployeeTm> emanagetbl;

    @FXML
    private TextField txtdate;

    private AnchorPane paneattendance;

    private AnchorPane PANEMANAGE;
    @FXML
    private TextField txttime;

    EmployeeManageBo employeeManageBo = (EmployeeManageBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.EmployeeManage);

    public void initialize() throws ClassNotFoundException {
        setCallValueFactory();
        lordAllEmployee();
    }
    private void  setCallValueFactory(){
        colempid.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
        colfirstname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        collastname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colteleno.setCellValueFactory(new PropertyValueFactory<>("tele_no"));
        coljoindate.setCellValueFactory(new PropertyValueFactory<>("join_date"));
        colnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
    }
    private void lordAllEmployee() throws ClassNotFoundException {

        

        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeMmanage> dtoList = employeeManageBo.getAllEmployee();


            for(EmployeeMmanage dto : dtoList) {
                obList.add(
                        new EmployeeTm(
                                dto.getEmployee_id(),
                                dto.getFirst_name(),
                                dto.getLast_name(),
                                dto.getAddress(),
                                dto.getTele_no(),
                                dto.getJoin_date(),
                                dto.getNic()
                        )
                );
            }

            emanagetbl.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @FXML
    void btnBookingOnAction(ActionEvent event) throws IOException {
        switchNavigation("BookingDetailForm.fxml", event);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("CustomerForm.fxml", event);
    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DeliverDetail.fxml", event);
    }

    @FXML
    void btnEmployeeAttendanceOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeAttendance.fxml", event);
    }

    /*@FXML
    void btnEmployeeManageOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeManage.fxml", event);
    }*/

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
       Navigation.switchNavigation("EmployeeManage.fxml", event);
        //switchPaging(paneId,"EmployeeManage.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("LoginPage.fxml", event);
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("CustomerOrderDetailForm.fxml", event);
    }

    @FXML
    void btnStockOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("StockDetail.fxml", event);
    }

    @FXML
    void btnaddemployeeOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("AddEmployeeForm.fxml", event);
    }

    @FXML
    void btndashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DasboardForm.fxml", event);
    }

    @FXML
    void btnsearchOnAction(ActionEvent event) {

    }

}
