package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.AddCustomer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo extends SuperBo{
    List<AddCustomer> getAllCustomers() throws SQLException, ClassNotFoundException;

    List<AddCustomer> loadAllCustomers() throws SQLException, ClassNotFoundException;

    AddCustomer searchCustomer(String id) throws SQLException, ClassNotFoundException;

}
