package lk.ijse.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.BookingBo;
import lk.ijse.project.Dao.Custom.BookingDao;
import lk.ijse.project.Dao.Custom.Impl.BookingDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddBooking;
import lk.ijse.project.Dto.Tm.BookingTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class BookingDetailController {

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnaddbooking;

    @FXML
    private Button btnbooking;

    @FXML
    private Button btncustomer;

    @FXML
    private Button btndashboard;

    @FXML
    private Button btnemployee;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnorders;

    @FXML
    private Button btnsearch;
    @FXML
    private TableColumn<?, ?> colbid;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colicost;

    @FXML
    private TableColumn<?, ?> colitemcode;

    @FXML
    private TableColumn<?, ?> colnic;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableView<BookingTm> tblbooking;

    BookingBo bookingBo = (BookingBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Booking);
    public void initialize() throws ClassNotFoundException {
        setCallValueFactory();
        lordAllBooking();

    }

    private void  setCallValueFactory(){

        colbid.setCellValueFactory(new PropertyValueFactory<>("bookingid"));
        colnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("icode"));
        colicost.setCellValueFactory(new PropertyValueFactory<>("initialcost"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    private void lordAllBooking() throws ClassNotFoundException {



        ObservableList<BookingTm> obList = FXCollections.observableArrayList();

        try {
            List<AddBooking> dtoList = bookingBo.getAllBooking();


            for(AddBooking dto : dtoList) {
                obList.add(
                        new BookingTm(
                                dto.getBookingid(),
                                dto.getNic(),
                                dto.getIcode(),
                                dto.getInitialcost(),
                                dto.getQty(),
                                dto.getDate()
                        )
                );
            }

            tblbooking.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void btnBookingOnAction(ActionEvent event) throws IOException {
        switchNavigation("BookingDetailController.fxml", event);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        switchNavigation("CustomerForm.fxml", event);
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
    void btnStockOnAction(ActionEvent event) throws IOException {
        switchNavigation("StockDetail.fxml", event);
    }

    @FXML
    void btnaddBookingOnAction(ActionEvent event) throws IOException {
        switchNavigation("AddBookingForm.fxml",event);
    }

    @FXML
    void btndashboardOnAction(ActionEvent event) throws IOException {
        switchNavigation("DasboardForm.fxml", event);
    }

    @FXML
    void btnsearchOnAction(ActionEvent event) {

    }

}
