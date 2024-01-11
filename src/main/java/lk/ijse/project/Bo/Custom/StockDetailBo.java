package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.Item;

import java.sql.SQLException;
import java.util.List;

public interface StockDetailBo extends SuperBo{
    List<Item> getAllStock() throws SQLException, ClassNotFoundException;

    List<Item> loadAllItem() throws SQLException, ClassNotFoundException;

}
