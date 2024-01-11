package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.CustomerBo;
import lk.ijse.project.Dao.Custom.CustomerDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomer;

import java.sql.SQLException;
import java.util.List;

public class CustomerBoImp implements CustomerBo {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.Customer);

    @Override
    public List<AddCustomer> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDao.getAllCustomers();
    }

    @Override
    public List<AddCustomer> loadAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDao.loadAllCustomers();
    }

    @Override
    public AddCustomer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.searchCustomer(id);
    }
}
