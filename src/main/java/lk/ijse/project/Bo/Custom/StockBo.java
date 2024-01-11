package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.Item;

import java.sql.SQLException;
import java.util.List;

public interface StockBo extends SuperBo{
    boolean save(final Item dto) throws SQLException, ClassNotFoundException;

    boolean update(final Item dto) throws SQLException, ClassNotFoundException;


    String generateNextid() throws SQLException, ClassNotFoundException;
    String splitId(String currentId);



    Item search(String id) throws SQLException, ClassNotFoundException;


    boolean delete(String id) throws SQLException, ClassNotFoundException;
    List<Item> searchItem(String code) throws SQLException, ClassNotFoundException;

    String generateNextItemid() throws SQLException, ClassNotFoundException;
    String splititemId(String currentItemrId);

    List<Item> getAllItem() throws SQLException, ClassNotFoundException;

    List<Item> loadAllItem() throws SQLException, ClassNotFoundException;
    int dashboardStockCount() throws SQLException, ClassNotFoundException;



}
