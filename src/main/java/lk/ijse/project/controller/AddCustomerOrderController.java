package lk.ijse.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.AddCustomerBo;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.CustomerBo;
import lk.ijse.project.Bo.Custom.PlaceOrderBo;
import lk.ijse.project.Dao.Custom.AddCustomerDao;
import lk.ijse.project.Dao.Custom.CustomerDao;
import lk.ijse.project.Dao.Custom.CustomerOrderDao;
import lk.ijse.project.Dao.Custom.Impl.AddcustomerDaoImp;
import lk.ijse.project.Dao.Custom.Impl.CustomerDaoImpl;
import lk.ijse.project.Dao.Custom.Impl.CustomerOrderImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomer;
import lk.ijse.project.Dto.AddCustomerOrderClass;
import lk.ijse.project.Dto.Tm.CustomerOrderTm;

import lk.ijse.project.utill.Navigation;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AddCustomerOrderController {

    @FXML
    private Button btnadd;

    @FXML
    private Button btnback;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnclear;

    @FXML
    private TableColumn<?, ?> colcid;

    @FXML
    private TableColumn<?, ?> colcusorderid;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableColumn<?, ?> coltotal;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private ImageView customer_order_detail;
    @FXML
    private ComboBox<String> cmbCu_id;
    @FXML
    private TextField txtcus_order_id;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txttotalprice;

    @FXML
    private TextField txtunitprice;
    @FXML
    private TableView<CustomerOrderTm> tblcusordr;
    @FXML
    private ComboBox<?> txtcusid;

    @FXML
    private TextField txtserch;

    @FXML
    private Label lblcus_order_id;
    @FXML
    private Label lblcusorderid;

    AddCustomerBo addCustomerBo= (AddCustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddCustomer);
    PlaceOrderBo placeOrderBo = (PlaceOrderBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.PlaceOrder);

    CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Customer);
    @FXML
    void txtsearchonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        ArrayList<String> allcusorderid = placeOrderBo.getAllCustomerOrderId();
        for (int i =0;i<allcusorderid.size();i++){
            if (txtserch.getText().equals(allcusorderid.get(i))){
                customerordersearchController.id =txtserch.getText();
                Navigation.switchNavigation("CustomerOrderSearchViewForm.fxml",event);
            }
        }
    }

    public void initialize() throws ClassNotFoundException {
        setCellValueFactory();
        loadAllCustomerOrders();
        loadAllCustomer();
        generateNextcustomerId();
    }



 private void loadAllCustomer() throws ClassNotFoundException {


     ObservableList<String> obList =FXCollections.observableArrayList();
     try {
         List<AddCustomer> allCustomer = customerBo.getAllCustomers();
         for (AddCustomer dto : allCustomer) {
             obList.add(dto.getCid());
             System.out.println(dto.getCid());
         }
         cmbCu_id.setItems(obList);
     }catch (SQLException e){
         System.out.println(e.getMessage());
     }


 }
    private void generateNextcustomerId() throws ClassNotFoundException {
        try {
            String customerid = placeOrderBo.generateNextcustomerOid();
            lblcusorderid.setText(customerid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setCellValueFactory() {

        colcusorderid.setCellValueFactory(new PropertyValueFactory<>("cus_order_id"));
        colcid.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colunitprice.setCellValueFactory(new  PropertyValueFactory<>("unit_price"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        coltotal.setCellValueFactory(new PropertyValueFactory<>("total_price"));
    }
    private void loadAllCustomerOrders() throws ClassNotFoundException {


        ObservableList<CustomerOrderTm> obList = FXCollections.observableArrayList();

        try {
            List<AddCustomerOrderClass> dtoList = placeOrderBo.getAllCustomerOrder();

            for(AddCustomerOrderClass dto : dtoList) {
                obList.add(
                        new CustomerOrderTm(

                                dto.getCus_order_id(),
                                dto.getCid(),
                                dto.getTotal_price(),
                                dto.getUnit_price(),
                                dto.getQty()

                        )
                );
            }

            tblcusordr.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnaddorderOnAction(ActionEvent event) throws ClassNotFoundException {


        String cus_order_id=lblcusorderid.getText();
        String cid = cmbCu_id.getValue();
        double total_price = Double.parseDouble(txttotalprice.getText());
        double unit_price = Double.parseDouble(txtunitprice.getText());
        int qty = Integer.parseInt(txtqty.getText());
        Date date = Date.valueOf(LocalDate.now());
        Time time = Time.valueOf(LocalTime.now());

        var model = new AddCustomerOrderClass(cus_order_id,cid,total_price,unit_price,qty,date,time);
        try {
            boolean isSaved;
            isSaved = placeOrderBo.saveCustomerOrder(model);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer order savedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {

        cmbCu_id.getValue();
        txttotalprice.setText("");
        txtunitprice.setText("");
        txtqty.setText("");

    }

    @FXML
    void btnbackOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("CustomerOrderDetailForm.fxml", event);
    }

    @FXML
    void btndeleteOnAction(ActionEvent event) throws ClassNotFoundException {
        String cus_order_id = lblcusorderid.getText();


        try {
            boolean isDeleted = placeOrderBo.deleteCustomerOrder(cus_order_id);

            if(isDeleted) {
                tblcusordr.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "customer order deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnupdateOnAction(ActionEvent event) throws ClassNotFoundException {
        String cus_order_id = lblcusorderid.getText();
        String cid = cmbCu_id.getValue();
        double total_price = Double.parseDouble(txttotalprice.getText());
        double unit_price = Double.parseDouble(txtunitprice.getText());
        int qty = Integer.parseInt(txtqty.getText());
        Date date = Date.valueOf(LocalDate.now());
        Time time = Time.valueOf(LocalTime.now());


        var dto = new AddCustomerOrderClass(cus_order_id,cid,total_price,unit_price,qty,date,time);


        try {
            boolean isUpdated = placeOrderBo.updateCustomerOrder(dto);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer order updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnclearOnAction(ActionEvent event) {
        clearFields();
    }
    @FXML
    void cusidOnAction(ActionEvent event) throws ClassNotFoundException {
        String  coid = cmbCu_id.getSelectionModel().getSelectedItem().toString();
        try {
            AddCustomer dto = addCustomerBo.searchOrder(coid);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CustorderIdOnAction(ActionEvent actionEvent) {

    }
}
