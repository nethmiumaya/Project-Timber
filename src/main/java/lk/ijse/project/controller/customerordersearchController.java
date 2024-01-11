package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.PlaceOrderBo;
import lk.ijse.project.Dao.Custom.CustomerOrderDao;
import lk.ijse.project.Dao.Custom.Impl.CustomerOrderImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomerOrderClass;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class customerordersearchController {

    @FXML
    private Label lblcusid;

    @FXML
    private Label lblcusorderid;

    @FXML
    private Label lblquantity;

    @FXML
    private Label lbltotal;

    @FXML
    private Label lblunitprice;

    @FXML
    private TextField txtcus_order_id;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txttotalprice;

    @FXML
    private TextField txtunitprice;

    @FXML
    private TextField txtunitprice1;
    static String id;

   // CustomerOrderDao customerOrderDao = (CustomerOrderDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.CustomerOrder);
   PlaceOrderBo placeOrderBo = (PlaceOrderBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.PlaceOrder);
    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        switchNavigation("CustomerOrderDetailForm.fxml", event);

    }
    public void initialize() throws ClassNotFoundException {
        setData();
    }

    public void setData() throws ClassNotFoundException {
        try {
            // Assuming AddCustomerOrderModel.searchCustomerOrder(id) returns an ArrayList
            ArrayList<AddCustomerOrderClass> orderList = (ArrayList<AddCustomerOrderClass>) placeOrderBo.searchCustomerOrder(id);

            if (!orderList.isEmpty()) {
                AddCustomerOrderClass cusOrderDto = orderList.get(0); // Assuming you want the first item in the list
                lblcusorderid.setText(cusOrderDto.getCus_order_id());
                lblcusid.setText(cusOrderDto.getCus_order_id());
                lblunitprice.setText(String.valueOf(cusOrderDto.getUnit_price()));
                lblquantity.setText(String.valueOf(cusOrderDto.getQty()));
                lbltotal.setText(String.valueOf(cusOrderDto.getTotal_price()));
            } else {
                System.out.println("No matching customer orders found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}