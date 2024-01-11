package lk.ijse.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
import lk.ijse.project.utill.Navigation;
import lk.ijse.project.validation.validation;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Double.parseDouble;
import static lk.ijse.project.utill.Navigation.switchNavigation;

public class AddItemController {

    @FXML
    private Button btnadd;

    @FXML
    private Button btncancel;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private ImageView itempage;

    @FXML
    private TextField txtIid;

    @FXML
    private TextField txtiname;

    @FXML
    private TextField txtqty;

    @FXML
    private TextField txtunitprice;

    @FXML
    private Label lblicode;

    public void initialize() throws ClassNotFoundException {generateNextItemId();}

    StockBo stockBo = (StockBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Stock);

    private void generateNextItemId() throws ClassNotFoundException {
        try {
            String itemid = stockBo.generateNextItemid();
            lblicode.setText(itemid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnCancelOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("StockDetail.fxml", event);
    }

    @FXML
    void btnaddOnAction(ActionEvent event) throws ClassNotFoundException {


        String i_code = lblicode.getText();
        String i_name = txtiname.getText();
        int qtyofHand = Integer.parseInt(txtqty.getText());
        double unit_price= parseDouble(txtunitprice.getText());



        var model = new Item(i_code,i_name,qtyofHand,unit_price);
        try {
            if (validation.checkItemCode(lblicode.getText())) {

                    boolean isSaved;
                    isSaved = stockBo.save(model);
                    if (isSaved) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Item saveddd!").show();
                    }
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid Item id!").show();
            }
        }
        catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btndeleteOnAction(ActionEvent event) {
        String i_code= lblicode.getText();

        try {
            if (validation.checkItemCode(lblicode.getText())) {
                boolean isDeleted = stockBo.delete(i_code);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item deleted Successfully").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid Item Code!").show();
            }
        }
            catch(Exception e){
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }

    }

    @FXML
    void btnupdateOnAction(ActionEvent event) throws ClassNotFoundException {
        String i_code = lblicode.getText();
        String i_name = txtiname.getText();
        int qtyofHand = Integer.parseInt(txtqty.getText());
        double unit_price= parseDouble(txtunitprice.getText());

        var dto=new Item(i_code,i_name,qtyofHand,unit_price);

        try {
            boolean isUpdated;
            isUpdated = stockBo.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item updatedd!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


    public void txtsearchonAction(ActionEvent actionEvent) throws IOException {
        switchNavigation("StockSearchForm.fxml", actionEvent);
    }
}
