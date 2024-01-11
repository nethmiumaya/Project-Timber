package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.project.Bo.Custom.BoFactory;
import lk.ijse.project.Bo.Custom.StockBo;
import lk.ijse.project.Dao.Custom.Impl.StockDaoImp;
import lk.ijse.project.Dao.Custom.StockDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class StockSearchControllerForm {

    @FXML
    private Button btnback;

    @FXML
    private Label lblicode;

    @FXML
    private Label lbliname;

    @FXML
    private Label lblqty;

    @FXML
    private Label lblunitprice;

    @FXML
    private ImageView stocksearchpage;

    @FXML
    private TextField txtcus_order_id;

    @FXML
    private TextField txtcus_order_id1;

    @FXML
    private TextField txtcus_order_id11;

    @FXML
    private TextField txtunitprice1;

    static String id;
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        switchNavigation("StockDetail.fxml", event);
    }
    public void initialize() throws ClassNotFoundException {
        setData();
    }

    StockBo stockBo = (StockBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Stock);
    public void setData() throws ClassNotFoundException {
        try {
            // Assuming AddCustomerOrderModel.searchCustomerOrder(id) returns an ArrayList
            ArrayList<Item> itemList = (ArrayList<Item>) stockBo.searchItem(id);

            if (!itemList.isEmpty()) {
                Item ItemDto = itemList.get(0); // Assuming you want the first item in the list
                lblicode.setText(ItemDto.getI_code());
                lbliname.setText(ItemDto.getI_name());
                lblunitprice.setText(String.valueOf(ItemDto.getUnit_price()));
                lblqty.setText(String.valueOf(ItemDto.getQtyofHand()));

            } else {
                // Handle the case where the list is empty
                System.out.println("No matching Item found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
