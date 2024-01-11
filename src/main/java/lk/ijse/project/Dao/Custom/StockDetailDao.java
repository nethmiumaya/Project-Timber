package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.Item;

import java.sql.SQLException;
import java.util.List;

public interface StockDetailDao extends SuperDao {
    List<Item> getAllStock() throws SQLException, ClassNotFoundException;

    List<Item> loadAllItem() throws SQLException, ClassNotFoundException;
}
