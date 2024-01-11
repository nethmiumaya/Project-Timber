package lk.ijse.project.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.SupplierOrderBo;
import lk.ijse.project.Dao.Custom.Impl.SupplierOrderDaoImp;
import lk.ijse.project.Dao.Custom.SupplierOrderDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Supplier;
import lk.ijse.project.Dto.Tm.SupplierTm;
import lk.ijse.project.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SupplierOrderDetailController {

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnSupplierOrders;

    @FXML
    private Button btnbooking;

    @FXML
    private JFXButton btnclear;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btncustomerorders;

    @FXML
    private Button btndashboard;

    @FXML
    private JFXButton btndelete;

    @FXML
    private Button btnemployee;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnorders;

    @FXML
    private JFXButton btnsave;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colorderid;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableColumn<?, ?> colsupplierid;

    @FXML
    private TableColumn<?, ?> coltotalprice;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private ImageView supplierorderspane;

    @FXML
    private TableView<SupplierTm> tblsupplierorder;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtoid;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txtsupplierid;

    @FXML
    private TextField txttime;

    @FXML
    private TextField txttotalprice;

    @FXML
    private TextField txtunitprice;

    SupplierOrderBo supplierOrderBo = (SupplierOrderBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.SupplierOrder);

    public void initialize() throws ClassNotFoundException {
        setCallValueFactory();
        lordAllSupplierOrder();

    }

    private void  setCallValueFactory(){

        colorderid.setCellValueFactory(new PropertyValueFactory<>("o_id"));
        coltotalprice.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        colunitprice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }
    private void lordAllSupplierOrder() throws ClassNotFoundException {


        ObservableList<SupplierTm> obList = FXCollections.observableArrayList();

        try {
            List<Supplier> dtoList = supplierOrderBo.getAllSupplier();


            for(Supplier dto : dtoList) {
                obList.add(
                        new SupplierTm(
                                dto.getO_id(),
                                dto.getTotal_price(),
                                dto.getUnit_price(),
                                dto.getQty(),
                                dto.getDate()

                        )
                );
            }

            tblsupplierorder.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnBookingOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("BookingDetailForm.fxml", event);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("CustomerForm.fxml", event);
    }

    @FXML
    void btnCustomerOrdersOnAction(ActionEvent event) throws IOException {
       // Navigation.switchNavigation("CustomerOrderDetailForm.fxml", event);
        Navigation.switchPaging(GlobalFormController.getInstance().paneId, "CustomerOrderDetailForm.fxml");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String o_id= txtoid.getText();

        try{
            boolean isDeleted= supplierOrderBo.deleteSupplierOrder(o_id);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Supplier Order deleted Successfully").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DeliverDetail.fxml", event);
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeManage.fxml", event);
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
    void btnSaveOnAction(ActionEvent event) throws ClassNotFoundException {

        String o_id = txtoid.getText();
        double total_price = Double.parseDouble(txttotalprice.getText());
        double unit_price = Double.parseDouble(txtunitprice.getText());
        int qty = Integer.parseInt(txtqty.getText());
        String date= txtdate.getText();



        var model = new Supplier(o_id,total_price,unit_price,qty,date);
        try {
            boolean isSaved;
            isSaved = supplierOrderBo.saveSupplierOrder(model);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Order saveddd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnStockOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("StockDetail.fxml", event);
    }

    @FXML
    void btnSupplierOrdersOnAction(ActionEvent event) throws IOException {
       // Navigation.switchNavigation("SupplierOrderDetail.fxml", event);
        Navigation.switchPaging(GlobalFormController.getInstance().paneId, "SupplierOrderDetail.fxml");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException {
        String o_id = txtoid.getText();
        double total_price = Double.parseDouble(txttotalprice.getText());
        double unit_price = Double.parseDouble(txtunitprice.getText());
        int qty = Integer.parseInt(txtqty.getText());
        String date= txtdate.getText();

        var dto=new Supplier(o_id,total_price,unit_price,qty,date);

        try {
            boolean isUpdated;
            isUpdated = supplierOrderBo.updateSupplierOrder(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Order updatedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    private void clearFields() {

        txtoid.setText("");
        txttotalprice.getText();
        txtunitprice.setText("");
        txtqty.setText("");
        txtdate.setText("");


    }
    @FXML
    void btnclearOnAction(ActionEvent event) {clearFields();;}

    @FXML
    void btndashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DasboardForm.fxml", event);
    }

}
