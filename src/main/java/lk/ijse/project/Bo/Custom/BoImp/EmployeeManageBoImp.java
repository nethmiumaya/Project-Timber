package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.EmployeeManageBo;
import lk.ijse.project.Dao.Custom.EmployeeManageDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.List;

public class EmployeeManageBoImp implements EmployeeManageBo {

    EmployeeManageDao employeeManageDao = (EmployeeManageDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.EmployeeManage);

    @Override
    public List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException {
        return employeeManageDao.getAllEmployee();
    }
}
