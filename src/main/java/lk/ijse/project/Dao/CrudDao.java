package lk.ijse.project.Dao;

import lk.ijse.project.Dto.AddCustomer;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDao {

    boolean save(final T dto) throws SQLException, ClassNotFoundException;

    boolean update(final T dto) throws SQLException, ClassNotFoundException;


    String generateNextid() throws SQLException, ClassNotFoundException;
    String splitId(String currentId);



    T search(String id) throws SQLException, ClassNotFoundException;


    boolean delete(String id) throws SQLException, ClassNotFoundException;




}
