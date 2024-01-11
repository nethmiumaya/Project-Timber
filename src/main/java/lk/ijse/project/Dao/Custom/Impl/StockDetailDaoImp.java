package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.StockDetailDao;
import lk.ijse.project.Dto.Item;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDetailDaoImp implements StockDetailDao {
    public List<Item> getAllStock() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM item");

        List<Item> dtoList = new ArrayList<>();

        while (resultSet.next()) {


            String i_code = resultSet.getString(1);
            String i_name = resultSet.getString(2);
            int qtyofHand = resultSet.getInt(3);
            double unit_price = resultSet.getDouble(4);

            var dto = new Item(i_code,i_name,qtyofHand,unit_price);

            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<Item> loadAllItem() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM item");

        List<Item> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            var dto=new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)


            );
            dtoList .add(dto);
        }
        return dtoList;
    }
}
