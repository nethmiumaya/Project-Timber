package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.AddCustomer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends SuperDao {
     List<AddCustomer> getAllCustomers() throws SQLException, ClassNotFoundException;

     List<AddCustomer> loadAllCustomers() throws SQLException, ClassNotFoundException;

     AddCustomer searchCustomer(String id) throws SQLException, ClassNotFoundException;

}
