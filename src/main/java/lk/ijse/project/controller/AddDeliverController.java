package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Dao.Custom.AddDeliverDao;
import lk.ijse.project.Dao.Custom.Impl.AddDeliverDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Deliver;
import lk.ijse.project.utill.Navigation;
import lk.ijse.project.Bo.Custom.AddDeliverBo;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AddDeliverController {

    @FXML
    private Button btnadd;

    @FXML
    private Button btncancel;

    @FXML
    private ImageView deliverpage;

    @FXML
    private TextField txtaddress;

    @FXML
    private DatePicker txtdate;

    @FXML
    private TextField txtdid;

    @FXML
    private TextField txtquantity;

    @FXML
    private TextField txtteleno;

    @FXML
    private TextField txtpayment;
    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;
    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> collocation;

    @FXML
    private TableColumn<?, ?> coltype;

    @FXML
    private Label lblsearch;

    AddDeliverBo addDeliverBo = (AddDeliverBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddDeliver);
    @FXML
    void txtidOnAction(ActionEvent event) throws IOException {

    }
    @FXML
    void txtsearchonAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DeliverSearchViewForm.fxml", event);
    }

    @FXML
    void btnaddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        String did = txtdid.getText();
        String address = txtaddress.getText();
        int teleno= parseInt(txtteleno.getText());
        String dueDate = String.valueOf(datepicker.getValue());
        double payment = Double.parseDouble(txtpayment.getText());



        var model = new Deliver(did,address,teleno,dueDate,payment);
        boolean isSaved;
        isSaved = addDeliverBo.save(model);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deliver saveddd!").show();
        }

    }

    @FXML
    void btncancelOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("DeliverDetail.fxml", event);
    }
    @FXML
    void btndeleteOnAction(ActionEvent event) {
        String did= txtdid.getText();

        try{
            boolean isDeleted= addDeliverBo.delete(did);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Deliver deleted Successfully").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnupdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String did = txtdid.getText();
        String address = txtaddress.getText();
        int teleno= parseInt(txtteleno.getText());
        String date = String.valueOf(datepicker.getValue());
        double payment = Double.parseDouble(txtpayment.getText());



        var dto=new Deliver(did,address,teleno,date,payment);

        try {
            boolean isUpdated;
            isUpdated = addDeliverBo.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deliver updatedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

}
