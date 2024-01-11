package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.EmployeeBo;
import lk.ijse.project.Dao.Custom.EmployeeDao;
import lk.ijse.project.Dao.Custom.Impl.EmployeeDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.EmployeeMmanage;
import lk.ijse.project.utill.Navigation;
import lk.ijse.project.utill.NewId;
import lk.ijse.project.validation.validation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class AddEmployeeController {

    @FXML
    private Button AddAsAnEmployee;

    @FXML
    private Button AsAnAdmin;

    @FXML
    private ImageView addasemployee;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtnic;

    @FXML
    private TextField txtfullname;


    @FXML
    private TextField txtlastname;


    @FXML
    private TextField txttele;

    @FXML
    private TextField txtid;
    @FXML
    private DatePicker txtjoindate;

    @FXML
    private Label lblempid;

    EmployeeBo employeeBo = (EmployeeBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Employee);
    public void initialize() throws ClassNotFoundException {generateNextemployeeId();}
    private void generateNextemployeeId() throws ClassNotFoundException {
        try {
            String customerid = employeeBo.generateNextid();
            lblempid.setText(customerid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void AddAsAnEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("SignUp.fxml", event);
    }
    @FXML
    void txtsearchonAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeSearchForm.fxml", event);
    }
    @FXML
    void AsAnAdminOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("SignUp.fxml", event);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws  IOException {
        Navigation.switchNavigation("AddEmployeeForm.fxml", event);
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeManage.fxml", event);
    }


    public void btnaddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        EmployeeMmanage EmployeeManageDto = new EmployeeMmanage();
        ArrayList<String> list = employeeBo.getAllEmployeeId();

        EmployeeManageDto.setEmployee_id(NewId.newId(list, NewId.GetType.EMPLOYEE));
        String employee_id = lblempid.getText();
        String first_name = txtfullname.getText();
        String last_name = txtlastname.getText();
        String address = txtaddress.getText();
        int tele_no = parseInt(txttele.getText());
        String join_date = String.valueOf(txtjoindate.getValue());
        String nic = txtnic.getText();



        var model = new EmployeeMmanage(employee_id,first_name,last_name,address,tele_no,join_date,nic);
        try {
            if (validation.checkEmployeeId(lblempid.getText())) {
                if (validation.checkPhoneNumber(txttele.getText())) {
                    boolean isSaved;
                    isSaved = employeeBo.save(model);
                    if (isSaved) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Employee saveddd!").show();
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid phone number!").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid employee id!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnupdateOnAction(ActionEvent actionEvent) throws ClassNotFoundException {



        String employee_id = lblempid.getText();
        String first_name = txtfullname.getText();
        String last_name = txtlastname.getText();
        String address = txtaddress.getText();
        int tele_no= parseInt(txttele.getText());
        String join_date = String.valueOf(txtjoindate.getValue());
        String nic = txtnic.getText();



        var dto=new EmployeeMmanage(employee_id,first_name,last_name,address,tele_no,join_date,nic);

        try {
            boolean isUpdated;
            isUpdated = employeeBo.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee updatedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btndeleteOnAction(ActionEvent actionEvent) {
        String employee_id= lblempid.getText();

        try{
            boolean isDeleted= employeeBo.delete(employee_id);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Employee deleted Successfully").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
