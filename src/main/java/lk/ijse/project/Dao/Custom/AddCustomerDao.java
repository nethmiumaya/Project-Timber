package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.CrudDao;
import lk.ijse.project.Entity.AddCustomerE;

import java.sql.SQLException;
import java.util.List;

public interface AddCustomerDao extends CrudDao<AddCustomerE> {

      AddCustomerE searchOrder(String coid) throws SQLException, ClassNotFoundException;


     List<AddCustomerE> searchcustomer(String id) throws SQLException, ClassNotFoundException;

     List<AddCustomerE> getAllCustomer() throws SQLException, ClassNotFoundException;

}
