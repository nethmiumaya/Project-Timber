package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.AddCustomer;

import java.sql.SQLException;
import java.util.List;

public interface AddCustomerBo extends SuperBo{
    boolean save(final AddCustomer dto) throws SQLException, ClassNotFoundException;

    boolean update(final AddCustomer dto) throws SQLException, ClassNotFoundException;


    String generateNextid() throws SQLException, ClassNotFoundException;
    String splitId(String currentId);



    AddCustomer search(String id) throws SQLException, ClassNotFoundException;


    boolean delete(String id) throws SQLException, ClassNotFoundException;

    AddCustomer searchOrder(String coid) throws SQLException, ClassNotFoundException;


    List<AddCustomer> searchcustomer(String id) throws SQLException, ClassNotFoundException;

    List<AddCustomer> getAllCustomer() throws SQLException, ClassNotFoundException;



}
