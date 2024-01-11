package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.AddCustomerBo;
import lk.ijse.project.Dao.Custom.AddCustomerDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomer;
import lk.ijse.project.Entity.AddCustomerE;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddCustomeBoImp implements AddCustomerBo {

    AddCustomerDao addCustomerDao = (AddCustomerDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.AddCustomer);
    @Override
    public boolean save(AddCustomer dto) throws SQLException, ClassNotFoundException {
        return addCustomerDao.save(new AddCustomerE(dto.getCid(),dto.getFirst_name(),dto.getLast_name(),dto.getNic(),dto.getAddress(),dto.getTele_no(),dto.getEmail()));
    }

    @Override
    public boolean update(AddCustomer dto) throws SQLException, ClassNotFoundException {
        return addCustomerDao.update(new AddCustomerE(dto.getCid(),dto.getFirst_name(),dto.getLast_name(),dto.getNic(),dto.getAddress(),dto.getTele_no(),dto.getEmail()));
    }

    @Override
    public String generateNextid() throws SQLException, ClassNotFoundException {
        return addCustomerDao.generateNextid();
    }

    @Override
    public String splitId(String currentId) {
        return addCustomerDao.splitId(currentId);
    }

    @Override
    public AddCustomer search(String id) throws SQLException, ClassNotFoundException {
        AddCustomerE addCustomerE = addCustomerDao.search(id);
        return new AddCustomer(addCustomerE.getCid(),addCustomerE.getFirst_name(),addCustomerE.getLast_name(),addCustomerE.getNic(),addCustomerE.getAddress(),addCustomerE.getTele_no(),addCustomerE.getEmail());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return addCustomerDao.delete(id);
    }

    @Override
    public AddCustomer searchOrder(String coid) throws SQLException, ClassNotFoundException {
        AddCustomerE addCustomerE = addCustomerDao.search(coid);
        return new AddCustomer(addCustomerE.getCid(),addCustomerE.getFirst_name(),addCustomerE.getLast_name(),addCustomerE.getNic(),addCustomerE.getAddress(),addCustomerE.getTele_no(),addCustomerE.getEmail());

    }

    @Override
    public List<AddCustomer> searchcustomer(String id) throws SQLException, ClassNotFoundException {
        List<AddCustomer> addCustomers = new ArrayList<>();
        List<AddCustomerE> addCustomerE = addCustomerDao.searchcustomer(id);
        for (AddCustomerE add:addCustomerE) {
            addCustomers.add(new AddCustomer(add.getCid(),add.getFirst_name(),add.getLast_name(),add.getNic(),add.getAddress(),add.getTele_no(),add.getEmail()));
        }
        return addCustomers;
    }

    @Override
    public List<AddCustomer> getAllCustomer() throws SQLException, ClassNotFoundException {
        List<AddCustomer> addCustomers = new ArrayList<>();
        List<AddCustomerE> addCustomerE = addCustomerDao.getAllCustomer();
        for (AddCustomerE add:addCustomerE) {
            addCustomers.add(new AddCustomer(add.getCid(),add.getFirst_name(),add.getLast_name(),add.getNic(),add.getAddress(),add.getTele_no(),add.getEmail()));
        }
        return addCustomers;
    }
}
