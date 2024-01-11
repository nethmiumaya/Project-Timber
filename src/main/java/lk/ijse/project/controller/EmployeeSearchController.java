package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.EmployeeBo;
import lk.ijse.project.Dao.Custom.EmployeeDao;
import lk.ijse.project.Dao.Custom.Impl.EmployeeDaoImp;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class EmployeeSearchController {

    @FXML
    private Button btnback;

    @FXML
    private ImageView empviewPage;

    @FXML
    private Label lbladdress;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblempid;

    @FXML
    private Label lblfname;

    @FXML
    private Label lbllname;

    @FXML
    private Label lblnic;

    @FXML
    private Label lblteleno;

    @FXML
    private TextField txtcus_order_id;

    @FXML
    private TextField txtcus_order_id1;

    @FXML
    private TextField txtcus_order_id11;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txttotalprice;

    @FXML
    private TextField txtunitprice;

    @FXML
    private TextField txtunitprice1;
    static String id;

EmployeeBo employeeBo = (EmployeeBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Employee);
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        switchNavigation("EmployeeManage.fxml", event);
    }
    public void initialize() throws ClassNotFoundException {
        setData();
    }
    public void setData() throws ClassNotFoundException {
        try {

            ArrayList<EmployeeMmanage> employeeList = (ArrayList<EmployeeMmanage>) employeeBo.searchEmployee(id);

            if (!employeeList.isEmpty()) {
                EmployeeMmanage EmployeeManageDto = employeeList.get(0); // Assuming you want the first item in the list
                lblempid.setText(EmployeeManageDto.getEmployee_id());
                lblfname.setText(EmployeeManageDto.getFirst_name());
                lbllname.setText(String.valueOf(EmployeeManageDto.getLast_name()));
                lbladdress.setText(String.valueOf(EmployeeManageDto.getAddress()));
                lblteleno.setText(String.valueOf(EmployeeManageDto.getTele_no()));
                lbldate.setText(EmployeeManageDto.getJoin_date());
                lblnic.setText(String.valueOf(EmployeeManageDto.getNic()));
            } else {
                // Handle the case where the list is empty
                System.out.println("No matching customer orders found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
