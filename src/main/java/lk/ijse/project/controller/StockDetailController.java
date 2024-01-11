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
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.StockBo;
import lk.ijse.project.Bo.Custom.StockDetailBo;
import lk.ijse.project.Dao.Custom.Impl.StockDaoImp;
import lk.ijse.project.Dao.Custom.Impl.StockDetailDaoImp;
import lk.ijse.project.Dao.Custom.StockDao;
import lk.ijse.project.Dao.Custom.StockDetailDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Item;
import lk.ijse.project.Dto.Tm.ItemTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class StockDetailController {

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnEmployee;

    @FXML
    private Button btnStock;

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
    private Button btnsearch;

    @FXML
    private Button btnstock;

    @FXML
    private TableColumn<?, ?> colcode;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colprice;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private ImageView stockpage;

    @FXML
    private TableView<ItemTm> tblitem;
    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtiname;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txtunitprice;


StockBo stockBo = (StockBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Stock);
StockDetailBo stockDetailBo = (StockDetailBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.StockDetail);
    public void initialize() throws ClassNotFoundException {
        setCallValueFactory();
        lordAllItem();

    }
    private void  setCallValueFactory(){

        colcode.setCellValueFactory(new PropertyValueFactory<>("i_code"));
        colname.setCellValueFactory(new PropertyValueFactory<>("i_name"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qtyofHand"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("unit_price"));

    }
    private void lordAllItem() throws ClassNotFoundException {


        ObservableList<ItemTm> obList = FXCollections.observableArrayList();

        try {
            List<Item> dtoList = stockDetailBo.getAllStock();


            for(Item dto : dtoList) {
                obList.add(
                        new ItemTm(
                                dto.getI_code(),
                                dto.getI_name(),
                                dto.getQtyofHand(),
                                dto.getUnit_price()

                        )
                );
            }

            tblitem.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void btnaddOnAction(ActionEvent event) throws IOException {
        switchNavigation("AddStockForm.fxml", event);
    }

}
