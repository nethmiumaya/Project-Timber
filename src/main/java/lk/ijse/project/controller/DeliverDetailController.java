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
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.AddDeliverBo;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Dao.Custom.AddDeliverDao;
import lk.ijse.project.Dao.Custom.DeliverDao;
import lk.ijse.project.Dao.Custom.Impl.AddDeliverDaoImp;
import lk.ijse.project.Dao.Custom.Impl.DeliverImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Deliver;
import lk.ijse.project.Dto.Tm.DelivetTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class DeliverDetailController {

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnEmployee;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnadddeliver;

    @FXML
    private Button btnbooking;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btndashboard;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnorders;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colpayment;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> coltele;

    @FXML
    private ImageView deliverPage;

    @FXML
    private TableView<DelivetTm> tbldeliver;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txttime;

    AddDeliverDao addDeliverDao = new AddDeliverDaoImp();

    AddDeliverBo deliverBo = (AddDeliverBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddDeliver);
    public void initialize() throws ClassNotFoundException {
        setCallValueFactory();
        lordAllDeliver();
        setDate();


    }
    private void  setCallValueFactory(){

        colid.setCellValueFactory(new PropertyValueFactory<>("deliver_id"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        coltele.setCellValueFactory(new PropertyValueFactory<>("tele_no"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colpayment.setCellValueFactory(new PropertyValueFactory<>("payment"));

    }

    private void lordAllDeliver() throws ClassNotFoundException {


        ObservableList<DelivetTm> obList = FXCollections.observableArrayList();

        try {
            List<Deliver> dtoList = deliverBo.getAlldeliver();


            for(Deliver dto : dtoList) {
                obList.add(
                        new DelivetTm(
                                dto.getDeliver_id(),
                                dto.getAddress(),
                                dto.getTele_no(),
                                dto.getDueDate(),
                                dto.getPayment()
                        )
                );
            }

            tbldeliver.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void setDate(){
        String dueDate = String.valueOf(LocalDate.now());

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
    void btnDeliveryOnAction(ActionEvent event) throws IOException {
        switchNavigation("DeliveryDetail.fxml", event);
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
    void btnStockOnAction(ActionEvent event) throws IOException {
        switchNavigation("StockDetail.fxml", event);
    }

    @FXML
    void btnadddeliverOnAction(ActionEvent event) throws IOException {
        switchNavigation("AddDeliverForm.fxml", event);
    }

    @FXML
    void btndashboardOnAction(ActionEvent event) throws IOException {
        switchNavigation("DasboardForm.fxml", event);
    }

    @FXML
    void btnsearchOnAction(ActionEvent event) {


    }

}
