package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.StockDao;
import lk.ijse.project.Dto.Item;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImp implements StockDao {
    @Override
    public  boolean save( Item dto) throws SQLException, ClassNotFoundException {
        return   SQLUtile.execute("INSERT INTO item VALUES(?,?,?,?)",dto.getI_code(),dto.getI_name(),dto.getQtyofHand(),dto.getUnit_price());
    }
@Override
    public  boolean update(final Item dto) throws SQLException, ClassNotFoundException {

       return SQLUtile.execute("UPDATE item SET i_name = ?, qtyofHand = ?, unit_price = ? WHERE i_code = ?",dto.getI_name(),dto.getQtyofHand(),dto.getUnit_price(),dto.getI_code());
    }

    @Override
    public String generateNextid() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String splitId(String currentId) {
        return null;
    }

    @Override
    public Item search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public  List<Item> searchItem(String code) throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM item");

        List<Item> empList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),

                    resultSet.getInt(4),
                    resultSet.getDouble(3)


            );
            empList.add(dto);
        }
        return empList;
    }
@Override
    public  String generateNextItemid() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT i_code FROM item ORDER BY i_code DESC LIMIT 1");

        String currentItemrId = null;
        if (resultSet.next()) {
            currentItemrId = resultSet.getString(1);

            return splititemId(currentItemrId);
        }
        return splititemId(null);
    }
    @Override
    public String splititemId(String currentItemrId) {
        if ( currentItemrId != null) {
            String[] split =  currentItemrId.split("I");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            return "I00" + id;
        }
        return "I001";
    }


@Override
    public List<Item> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM item");
        
        List<Item> dtoList = new ArrayList<>();
        
        while (resultSet.next()) {
            String i_code = resultSet.getString(1);
            String i_name = resultSet.getString(2);
            int qtyofHand = Integer.parseInt(resultSet.getString(3));
            double unit_price = Double.parseDouble(resultSet.getString(4));

            var dto = new Item(i_code,i_name,qtyofHand,unit_price);
            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public boolean delete(String i_code) throws SQLException, ClassNotFoundException {

        return SQLUtile.execute("DELETE FROM item WHERE i_code = ?",i_code);
    }
@Override
    public List<Item> loadAllItem() throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtile.execute("SELECT * FROM item");

        List<Item> itemList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)

            );
            itemList.add(dto);
        }
        return itemList;
    }
@Override
    public int dashboardStockCount() throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();
        ResultSet set = SQLUtile.execute("select COUNT(i_code) from item");

        if (set.next()){
            int count = set.getInt(1);
            return count;
        }
        return 0;

    }
}
