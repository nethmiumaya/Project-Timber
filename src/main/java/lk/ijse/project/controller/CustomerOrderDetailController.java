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
import lk.ijse.project.Bo.Custom.PlaceOrderBo;
import lk.ijse.project.Dao.Custom.CustomerOrderDetailDao;
import lk.ijse.project.Dao.Custom.Impl.CustomerOrderDetailDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.db.DbConnection;
import lk.ijse.project.Dto.AddCustomerOrderClass;
import lk.ijse.project.Dto.Product;
import lk.ijse.project.Dto.Tm.ProductTm;
import lk.ijse.project.utill.Navigation;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class CustomerOrderDetailController {

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnEmployee;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnSupplierOrders;

    @FXML
    private JFXButton btnback;

    @FXML
    private Button btnbooking;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btncustomerorder;

    @FXML
    private Button btncustomerorders;

    @FXML
    private Button btndashboard;

    @FXML
    private JFXButton btndelete;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnorders;

    @FXML
    private JFXButton btnsave;

    @FXML
    private Button btnsearch;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private TableColumn<?, ?> colcategory;

    @FXML
    private TableColumn<?, ?> coldescription;

    @FXML
    private TableColumn<?, ?> colpid;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableColumn<?, ?> colrestprice;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private ImageView orderspane;

    @FXML
    private TableView<ProductTm> tblproduct;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtcategory;

    @FXML
    private TextField txtdesc;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txtrestprice;

    @FXML
    private TextField txtunitprice;
    @FXML
    private Button btnplaceorder;

    @FXML
    private Label lblpid;

    //CustomerOrderDetailDao customerOrderDetailDao = (CustomerOrderDetailDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.CustomerOrderDetail);
    PlaceOrderBo placeOrderBo = (PlaceOrderBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.PlaceOrder);
    @FXML
    void btnemployeejasperOnAction(ActionEvent event) throws JRException, SQLException {

        InputStream resource = this.getClass().getResourceAsStream("/report/employee.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void generateNextPRODUCTId() throws ClassNotFoundException {
        try {
            String productid = placeOrderBo.generateNextProductid();
            lblpid.setText(productid);
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
        switchNavigation("CustomerForm.fxml", event);
    }

    @FXML
    void btnCustomerOrdersOnAction(ActionEvent event) throws IOException {
        switchNavigation("AddCustomerOrderForm.fxml", event);

    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        switchNavigation("DeliverDetail.fxml", event);
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        switchNavigation("EmployeeManage.fxml", event);

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        switchNavigation("LoginPage.fxml", event);
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) throws IOException {
        switchNavigation("CustomerOrderDetailForm.fxml", event);
    }

    @FXML
    void btnstockOnAction(ActionEvent event) throws IOException {
        switchNavigation("StockDetail.fxml", event);
    }

    @FXML
    void btnSupplierOrdersOnAction(ActionEvent event) throws IOException {
        //switchNavigation("SupplierOrderDetail.fxml", event);
        Navigation.switchPaging(GlobalFormController.getInstance().paneId, "SupplierOrderDetail.fxml");

    }

    @FXML
    void btnaddcustomerorderOnAction(ActionEvent event) throws IOException {
        switchNavigation("AddCustomerOrderForm.fxml", event);

    }

    @FXML
    void btndashboardOnAction(ActionEvent event) throws IOException {
        switchNavigation("DasboardForm.fxml", event);
    }

    @FXML
    void btnsearchOnAction(ActionEvent event) {

    }

    public void btnStockOnAction(ActionEvent actionEvent) throws IOException {
        switchNavigation("StockDetail.fxml", actionEvent);
    }
    @FXML
    void btnPlaceorderOnAction(ActionEvent event) throws IOException {
        switchNavigation("PaceOrderForm.fxml", event);
    }
    public void initialize() throws ClassNotFoundException {
        setCellValueFactory();
        loadAllProducts();
        generateNextPRODUCTId();
    }

    private void loadAllProducts() throws ClassNotFoundException {

        ObservableList<ProductTm> obList = FXCollections.observableArrayList();

        try {
            List<Product> dtoList = placeOrderBo.getAllProducts();

            for(Product dto : dtoList) {
                obList.add(
                        new ProductTm(

                                dto.getProduct_id(),
                                dto.getCategory(),
                                dto.getUnit_price(),
                                dto.getRest_price(),
                                dto.getDescription(),
                                dto.getQty()

                        )
                );
            }

            tblproduct.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public List<AddCustomerOrderClass> loadAllCustomerOrder() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer_order";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<AddCustomerOrderClass> cusList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new AddCustomerOrderClass(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getDate(6),
                    resultSet.getTime(7)


            );
            cusList.add(dto);
        }
        return cusList;
    }

    private void setCellValueFactory() {

        colpid.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colunitprice.setCellValueFactory(new  PropertyValueFactory<>("unit_price"));
        colrestprice.setCellValueFactory(new PropertyValueFactory<>("rest_price"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));

    }
    private void clearFields() {

        lblpid.setText("");
        txtcategory.setText("");
        txtunitprice.setText("");
        txtrestprice.setText("");
        txtdesc.setText("");
        txtqty.setText("");

    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws ClassNotFoundException {


        String product_id=lblpid.getText();
        String category = txtcategory.getText();
        double unit_price = Double.parseDouble(txtunitprice.getText());
        double rest_price = Double.parseDouble(txtrestprice.getText());
        String description=txtdesc.getText();
        int qty = Integer.parseInt(txtqty.getText());

        var model = new Product(product_id,category,unit_price,rest_price,description,qty);
        try {
            boolean isSaved;
            isSaved = placeOrderBo.saveProduct(model);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Product order saveddd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String product_id=lblpid.getText();
        String category = txtcategory.getText();
        double unit_price = Double.parseDouble(txtunitprice.getText());
        double rest_price = Double.parseDouble(txtrestprice.getText());
        String description=txtdesc.getText();
        int qty = Integer.parseInt(txtqty.getText());



        var dto = new Product(product_id,category,unit_price,rest_price,description,qty);


        try {
            boolean isUpdated = placeOrderBo.updateProduct(dto);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Product updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        String product_id = lblpid.getText();


        try {
            boolean isDeleted = placeOrderBo.deleteProduct(product_id);

            if(isDeleted) {
                tblproduct.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "product deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    public void btnbackOnAction(ActionEvent actionEvent) {
            clearFields();
    }
}
