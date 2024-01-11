package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.project.Bo.Custom.AddDeliverBo;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Dao.Custom.AddDeliverDao;
import lk.ijse.project.Dao.Custom.Impl.AddDeliverDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Deliver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class DeliverSearchControllerFrom {

    @FXML
    private Button btnback;

    @FXML
    private Label lbladdress;

    @FXML
    private Label lbldate;

    @FXML
    private Label lbldid;

    @FXML
    private Label lblpayment;

    @FXML
    private Label lblteleno;

    @FXML
    private TextField txtcus_order_id;

    @FXML
    private TextField txtcus_order_id1;

    @FXML
    private TextField txtcus_order_id11;

    @FXML
    private TextField txtunitprice;

    @FXML
    private TextField txtunitprice1;

    static String id;

    AddDeliverBo addDeliverBo = (AddDeliverBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddDeliver);
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        switchNavigation("EmployeeManage.fxml", event);
    }
    public void initialize() throws ClassNotFoundException {
        setData();
    }
    public void setData() throws ClassNotFoundException {
        try {
            // Assuming AddCustomerOrderModel.searchCustomerOrder(id) returns an ArrayList
            ArrayList<Deliver> deliverList = (ArrayList<Deliver>) addDeliverBo.searchDeliver(id);

            if (!deliverList.isEmpty()) {
                Deliver DeliverDto = deliverList.get(0); // Assuming you want the first item in the list
                lbldid.setText(DeliverDto.getDeliver_id());
                lbladdress.setText(DeliverDto.getAddress());
                lblteleno.setText(String.valueOf(DeliverDto.getTele_no()));
                lbldate.setText(DeliverDto.getDueDate());
                lblpayment.setText(String.valueOf(DeliverDto.getPayment()));

            } else {
                // Handle the case where the list is empty
                System.out.println("No matching deliver found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
