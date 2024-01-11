package lk.ijse.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.CustomerBo;
import lk.ijse.project.Dao.Custom.CustomerDao;
import lk.ijse.project.Dao.Custom.Impl.CustomerDaoImpl;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomer;
import lk.ijse.project.Dto.Tm.CustomerformTm;
import lk.ijse.project.utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class CustomerController {
    @FXML
    private TableColumn<?, ?> colaction;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colfirst;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> collast;

    @FXML
    private TableColumn<?, ?> colnic;

    @FXML
    private TableColumn<?, ?> coltele;


    @FXML
    private TextField btncustomerdetail;

    @FXML
    private TextField txtsearch;

    @FXML
    private TableView<CustomerformTm> tblCustomer;



CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Customer);
   public void initialize() throws ClassNotFoundException {
       setCallValueFactory();
       lordAllCustomer();


   }

   private void  setCallValueFactory(){
       colid.setCellValueFactory(new PropertyValueFactory<>("cid"));
       colfirst.setCellValueFactory(new PropertyValueFactory<>("first_name"));
       collast.setCellValueFactory(new PropertyValueFactory<>("last_name"));
       colnic.setCellValueFactory(new PropertyValueFactory<>("nic"));
       coltele.setCellValueFactory(new PropertyValueFactory<>("tele_no"));
       coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));



   }
    @FXML
    void btnAddOnAction(ActionEvent event) throws IOException {
    Navigation.switchNavigation("AddCustomerForm.fxml",event);
    }
   private void lordAllCustomer() throws ClassNotFoundException {


       ObservableList<CustomerformTm> obList = FXCollections.observableArrayList();

       try {
           List<AddCustomer> dtoList = customerBo.getAllCustomers();

           for(AddCustomer dto : dtoList) {
               obList.add(
                       new CustomerformTm(

                               dto.getCid(),
                               dto.getFirst_name(),
                               dto.getLast_name(),
                               dto.getNic(),
                               dto.getTele_no(),
                               dto.getAddress()
                       )
               );
           }

           tblCustomer.setItems(obList);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

   }



    @FXML
    void btnsearchOnAction(ActionEvent event) {

    }

    @FXML
    void searchmouseOnAction(MouseEvent event)throws SQLException,IOException {
      /*  AddCustomerModel addCustomerModel = new AddCustomerModel();
        ArrayList<String> allCustomerid=addCustomerModel.getAllCustomerId();
        for (int i=0;i<allCustomerid.size();i++){
            if (txtsearch.getText().equals(allCustomerid.get(i))){
                ViewCustomerSearchController.Cid=txtsearch.getText();
                Navigation.switchNavigation("CustomerSearchForm.fxml",event);
            }
        }*/
    }

}
