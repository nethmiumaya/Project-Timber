package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.AddCustomerBo;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Dao.Custom.AddCustomerDao;
import lk.ijse.project.Dao.Custom.Impl.AddcustomerDaoImp;
import lk.ijse.project.Dto.AddCustomer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class CustomerSearchFormController {

    @FXML
    private Button btnback;

    @FXML
    private ImageView customersearch;

    @FXML
    private Label lbladdress;

    @FXML
    private Label lblcusid;

    @FXML
    private Label lblemail;

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

    AddCustomerBo addCustomerBo = (AddCustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddCustomer);
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        switchNavigation("CustomerForm.fxml", event);

    }
    public void initialize() throws ClassNotFoundException {
        setData();
    }

    public void setData() throws ClassNotFoundException {
        try {

            // Assuming AddCustomerOrderModel.searchCustomerOrder(id) returns an ArrayList
            List<AddCustomer> orderList =  addCustomerBo.searchcustomer(id);

            if (!orderList.isEmpty()) {

                for (AddCustomer list : orderList){
                    if (list.getCid().equals(id)){

                    }
                }
                AddCustomer cusDto = orderList.get(0); // Assuming you want the first item in the list
                lblfname.setText(cusDto.getFirst_name());
                lbllname.setText(cusDto.getLast_name());
                lbladdress.setText(cusDto.getAddress());
                lblemail.setText(cusDto.getEmail());
                lblteleno.setText(cusDto.getTele_no());
                lblnic.setText(cusDto.getNic());
                lblcusid.setText(cusDto.getCid());

            } else {
                // Handle the case where the list is empty
                System.out.println("No matching customer orders found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
