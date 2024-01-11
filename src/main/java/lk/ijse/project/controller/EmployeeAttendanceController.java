package lk.ijse.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.project.Bo.Custom.AddCustomerBo;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Dao.Custom.AddCustomerDao;
import lk.ijse.project.Dao.Custom.EmpAttendaceDao;
import lk.ijse.project.Dao.Custom.Impl.AddcustomerDaoImp;
import lk.ijse.project.Dao.Custom.Impl.EmpAttendaceDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomer;
import lk.ijse.project.Dto.EmployeeAttendance;
import lk.ijse.project.Dto.Tm.AttendanceTm;
import lk.ijse.project.utill.Navigation;
import lk.ijse.project.Bo.Custom.EmpAttendanceBo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeAttendanceController {

    @FXML
    private Button btnEmployeeAttendance;

    @FXML
    private Button btnEmployeeAttendance1;

    @FXML
    private Button btnEmployeeManage;

    @FXML
    private Button btnEmployeeManage1;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnbooking;

    @FXML
    private Button btncancel;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btndashboard;

    @FXML
    private Button btndelete;

    @FXML
    private Button btndelivery;

    @FXML
    private Button btnemployee;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnorders;

    @FXML
    private Button btnstock;

    @FXML
    private Button btnupdate;

    @FXML
    private TableColumn<?, ?> coldate;


    @FXML
    private TableColumn<?, ?> coljobrole;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private Pane emploeeatteendancepane;

    @FXML
    private TableView<AttendanceTm> tblattendance;

    @FXML
    private TextField txtdate;

    @FXML
    private DatePicker txtdatepicker;

    @FXML
    private TextField txtempid;

    @FXML
    private TextField txtjobrole;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txttime;

    @FXML
    private AnchorPane PANEMANAGE;

    private AnchorPane paneattendance;
    @FXML
    private ComboBox<String> cmbid;

    @FXML
    private TableColumn<?, ?> colid;

    AddCustomerBo addCustomerBo = (AddCustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddCustomer);
     EmpAttendanceBo empAttendaceBo = (EmpAttendanceBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.EmpAttendance);
    public void initialize() throws ClassNotFoundException {
        setCallValueFactory();
        lordAllAttendance();

    }
    private void  setCallValueFactory(){

        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coljobrole.setCellValueFactory(new PropertyValueFactory<>("jobrole"));


    }


    private void lordAllAttendance() throws ClassNotFoundException {



        ObservableList<AttendanceTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeAttendance> dtoList = empAttendaceBo.getAllAttendance();


            for(EmployeeAttendance dto : dtoList) {
                obList.add(
                        new AttendanceTm(

                                dto.getName(),
                                dto.getDate(),
                                dto.getJobrole()

                        )
                );
            }

            tblattendance.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("CustomerForm.fxml", event);
    }

    @FXML
    void btnEmployeeAttendanceOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeAttendance.fxml", event);
    }

    @FXML
    void btnEmployeeManageOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeManage.fxml", event);
    }
    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
    }


    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("LoginPage.fxml", event);
    }

    @FXML
    void btnaddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String name = txtname.getText();
        String date = String.valueOf(txtdatepicker.getValue());
        String jobrole = txtjobrole.getText();



        var model = new EmployeeAttendance(name,date,jobrole);
        boolean isSaved;
        isSaved = empAttendaceBo.save(model);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Attendance saveddd!").show();
        }
    }

    @FXML
    void btnbookingOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("BookingDetailForm.fxml", event);
    }

    @FXML
    void btncancelOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeAttendance.fxml", event);
    }

    @FXML
    void btndashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DasboardForm.fxml", event);
    }

    @FXML
    void btndeleteOnAction(ActionEvent event) {
        String empname= txtname.getText();

        try{
            boolean isDeleted= empAttendaceBo.delete(empname);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Employee attendance deleted Successfully").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btndeliveryOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DeliverDetail.fxml", event);
    }

    @FXML
    void btnordersOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("CustomerOrderDetailForm.fxml", event);
    }

    @FXML
    void btnstockOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("StockDetail.fxml", event);
    }

    @FXML
    void btnupdateOnAction(ActionEvent event) throws ClassNotFoundException {

        String name = txtname.getText();
        String date = String.valueOf(txtdatepicker.getValue());
        String jobrole = txtjobrole.getText();


        var dto=new EmployeeAttendance(name,date,jobrole);

        try {
            boolean isUpdated;
            isUpdated = empAttendaceBo.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attendance updatedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void cmbeidOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        String  emp_id = cmbid.getSelectionModel().getSelectedItem().toString();
        try {
            AddCustomer dto = addCustomerBo.searchOrder(emp_id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
