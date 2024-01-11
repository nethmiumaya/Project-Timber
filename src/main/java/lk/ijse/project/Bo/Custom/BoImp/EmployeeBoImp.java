package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.EmployeeBo;
import lk.ijse.project.Dao.Custom.EmployeeDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImp implements EmployeeBo {
    EmployeeDao employeeDao = (EmployeeDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.Employee);

    @Override
    public boolean save(EmployeeMmanage dto) throws SQLException, ClassNotFoundException {
        return employeeDao.save(dto);
    }

    @Override
    public boolean update(EmployeeMmanage dto) throws SQLException, ClassNotFoundException {
        return employeeDao.update(dto);
    }

    @Override
    public String generateNextid() throws SQLException, ClassNotFoundException {
        return employeeDao.generateNextid();
    }

    @Override
    public String splitId(String currentId) {
        return employeeDao.splitId(currentId);
    }

    @Override
    public EmployeeMmanage search(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.search(id);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(id);
    }

    @Override
    public ArrayList<String> getAllEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDao.getAllEmployeeId();
    }

    @Override
    public List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException {
        return employeeDao.getAllEmployee();
    }

    @Override
    public List<EmployeeMmanage> searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.searchEmployee(id);
    }

    @Override
    public int dashboardemployeecount() throws SQLException, ClassNotFoundException {
        return employeeDao.dashboardemployeecount();
    }

}
