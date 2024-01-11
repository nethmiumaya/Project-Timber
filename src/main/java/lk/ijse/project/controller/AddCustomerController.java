package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.project.Bo.Custom.AddCustomerBo;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Dao.Custom.AddCustomerDao;
import lk.ijse.project.Dao.Custom.Impl.AddcustomerDaoImp;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomer;
import lk.ijse.project.utill.Navigation;
import lk.ijse.project.validation.validation;

import java.io.IOException;
import java.sql.SQLException;

public class AddCustomerController {

    @FXML
    private Button btnadd;

    @FXML
    private Button btncancel;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcusid;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtfirst;

    @FXML
    private TextField txtlast;

    @FXML
    private TextField txtnic;

    @FXML
    private TextField txttele;

    @FXML
    private Label lblcusid;


AddCustomerBo addCustomerBo = (AddCustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.AddCustomer);
public void initialize() throws ClassNotFoundException {generateNextcustomerId();}
    @FXML
    void cusidOnAction(ActionEvent event) throws ClassNotFoundException {
        String id = lblcusid.getText();

        try {
            AddCustomer dto = addCustomerBo.search(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    private void generateNextcustomerId() throws ClassNotFoundException {
        try {
            String customerid = addCustomerBo.generateNextid();
            lblcusid.setText(customerid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void fillFields(AddCustomer dto) {
        lblcusid.setText(dto.getCid());
        txtfirst.setText(dto.getFirst_name());
        txtlast.setText(dto.getLast_name());
        txtnic.setText(dto.getNic());
        txtaddress.setText(dto.getAddress());
        txttele.setText(dto.getTele_no());
        txtemail.setText(dto.getEmail());

    }

    @FXML
    void btnaddOnAction(ActionEvent event) throws IOException, ClassNotFoundException {
             String cid=lblcusid.getText();
             String firstname = txtfirst.getText();
            String lastname = txtlast.getText();
            String address = txtaddress.getText();
            String email=txtemail.getText();
            String tele=txttele.getText();
            String nic=txtnic.getText();


        var model = new AddCustomer(cid,firstname,lastname,nic,address,tele,email);
            try {
                if (validation.checkCustomerId(lblcusid.getText())) {
                    if (validation.checkPhoneNumber(txttele.getText())) {
                        if (validation.checkNic(txtnic.getText())) {
                            if (validation.checkemail(txtemail.getText())) {
                                boolean isSaved;
                                isSaved = addCustomerBo.save(model);
                                if (isSaved) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Customer saveddd!").show();
                                }
                            }else {
                                new Alert(Alert.AlertType.ERROR,"Invalid Email").show();
                            }
                        }else {
                            new Alert(Alert.AlertType.ERROR, "Invalid NIC!").show();
                        }

                    } else {
                        new Alert(Alert.AlertType.ERROR, "Invalid phone number!").show();

                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid customer id!").show();
                }
            }
                    catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

    @FXML
    void btncancelOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("CustomerForm.fxml", event);
    }

    @FXML
    void deletebtnonaction(ActionEvent event) {
       String cid= lblcusid.getText();

       try{
          boolean isDeleted= addCustomerBo.delete(cid);
          if(isDeleted){
              new Alert(Alert.AlertType.CONFIRMATION,"Customer deleted Successfully").show();
          }
       } catch (Exception e) {
           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
       }

    }

    @FXML
    void updatebtnonaction(ActionEvent event) throws ClassNotFoundException {
        String firstname = txtfirst.getText();
        String lastname = txtlast.getText();
        String address = txtaddress.getText();
        String email=txtemail.getText();
        String tele=txttele.getText();
        String nic=txtnic.getText();
        String cid=lblcusid.getText();

        var dto=new AddCustomer(cid,firstname,lastname,nic,address,tele,email);

        try {
            boolean isUpdated;
            isUpdated = addCustomerBo.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer updatedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    @FXML
    void txtsearchonAction(ActionEvent event)throws IOException {
        Navigation.switchNavigation("CustomerSearchForm.fxml", event);
    }

}
