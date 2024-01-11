package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.AddCustomerBo;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.BookingBo;
import lk.ijse.project.Dao.Custom.AddCustomerDao;
import lk.ijse.project.Dao.Custom.BookingDao;
import lk.ijse.project.Dao.Custom.Impl.AddcustomerDaoImp;
import lk.ijse.project.Dao.Custom.Impl.BookingDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddBooking;
import lk.ijse.project.utill.Navigation;
import lk.ijse.project.validation.validation;

import java.io.IOException;
import java.sql.SQLException;

public class AddBookingController {

    @FXML
    private ImageView booking_page;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnadd;

    @FXML
    private TextField txtbookingid;

    @FXML
    private TextField txtcid;

    @FXML
    private DatePicker TextMate;

    @FXML
    private TextField txticode;

    @FXML
    private TextField txtinitialcost;

    @FXML
    private TextField txtnic;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txttime;

    @FXML
    private Label lblbid;

    AddCustomerBo addCustomerBo = (AddCustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddCustomer);
    BookingBo bookingBo = (BookingBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Booking);
    public void initialize() throws ClassNotFoundException {
        generateNextbOOKINGId();
    }


    private void generateNextbOOKINGId() throws ClassNotFoundException {
        try {
            String BookingId = bookingBo.generateNextbOOKINGId();
            lblbid.setText(BookingId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("BookingDetailForm.fxml", event);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        String booking_id=lblbid.getText();
        String nic=txtnic.getText();
        String icode = txticode.getText();
        double initialcost= Double.parseDouble(txtinitialcost.getText());
        String qty=txtqty.getText();
        String date = String.valueOf(TextMate.getValue());

        var dto=new AddBooking(booking_id,nic,icode,initialcost,qty,date);

        try {
            boolean isUpdated;
            isUpdated = bookingBo.updateBooking(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Booking updatedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        String booking_id = lblbid.getText();
        String nic=txtnic.getText();
        String icode = txticode.getText();
        double initialcost= Double.parseDouble(txtinitialcost.getText());
        String qty=txtqty.getText();
        String date = String.valueOf(TextMate.getValue());





        var model = new AddBooking(booking_id,nic,icode,initialcost,qty,date);
        try {

                if (validation.checkNic(txtnic.getText())) {
                    boolean isSaved;
                    isSaved = bookingBo.saveOrder(model);
                    if (isSaved) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Booking saveddd!").show();
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid nic").show();
                }


        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String bookingid=lblbid.getText();

        try{
            boolean isDeleted= bookingBo.deleteBooking(bookingid);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Booking deleted Successfully").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnbackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("BookingDetailForm.fxml", actionEvent);
    }
}
