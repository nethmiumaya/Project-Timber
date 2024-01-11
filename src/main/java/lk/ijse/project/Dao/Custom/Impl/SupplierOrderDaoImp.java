package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.SupplierOrderDao;
import lk.ijse.project.Dto.Supplier;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierOrderDaoImp implements SupplierOrderDao {
    @Override
    public  boolean saveSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException {

        return SQLUtile.execute("INSERT INTO supplier_order VALUES(?,?,?,?,?)",dto.getO_id(),dto.getTotal_price(),dto.getUnit_price(),dto.getQty(),dto.getDate());
    }
@Override
    public boolean updateSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException {

       return SQLUtile.execute("UPDATE supplier_order SET  total_price = ?, unit_price = ?, qty = ?, date =? WHERE o_id = ?",dto.getTotal_price(),dto.getUnit_price(),dto.getQty(),dto.getDate(),dto.getO_id());
    }
@Override
    public boolean deleteSupplierOrder(String oId) throws SQLException, ClassNotFoundException {

        return SQLUtile.execute("DELETE FROM supplier_order WHERE o_id = ?",oId);
    }
@Override
    public List<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM supplier_order");

        List<Supplier> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String o_id = resultSet.getString(1);
            double total_price = resultSet.getDouble(2);
            double unit_price = resultSet.getDouble(3);
            int qty = Integer.parseInt(resultSet.getString(4));
            String date = resultSet.getString(5);

            var dto = new Supplier(o_id,total_price,unit_price,qty,date);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
