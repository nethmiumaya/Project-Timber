package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.CrudDao;
import lk.ijse.project.Dto.Item;

import java.sql.SQLException;
import java.util.List;

public interface StockDao extends CrudDao<Item> {

     List<Item> searchItem(String code) throws SQLException, ClassNotFoundException;

     String generateNextItemid() throws SQLException, ClassNotFoundException;
     String splititemId(String currentItemrId);

     List<Item> getAllItem() throws SQLException, ClassNotFoundException;

     List<Item> loadAllItem() throws SQLException, ClassNotFoundException;
     int dashboardStockCount() throws SQLException, ClassNotFoundException;
}
