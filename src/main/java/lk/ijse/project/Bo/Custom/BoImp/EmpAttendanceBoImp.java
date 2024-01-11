package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.EmpAttendanceBo;
import lk.ijse.project.Dao.Custom.EmpAttendaceDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.EmployeeAttendance;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.List;

public class EmpAttendanceBoImp implements EmpAttendanceBo {
    EmpAttendaceDao empAttendaceDao = (EmpAttendaceDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.EmpAttendance);
    @Override
    public boolean save(EmployeeAttendance dto) throws SQLException, ClassNotFoundException {
        return empAttendaceDao.save(dto);
    }

    @Override
    public boolean update(EmployeeAttendance dto) throws SQLException, ClassNotFoundException {
        return empAttendaceDao.update(dto);
    }

    @Override
    public String generateNextid() throws SQLException, ClassNotFoundException {
        return empAttendaceDao.generateNextid();
    }

    @Override
    public String splitId(String currentId) {
        return empAttendaceDao.splitId(currentId);
    }

    @Override
    public EmployeeAttendance search(String id) throws SQLException, ClassNotFoundException {
        return empAttendaceDao.search(id);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return empAttendaceDao.delete(id);
    }

    @Override
    public EmployeeMmanage searchOrder(String empId) throws SQLException, ClassNotFoundException {
        return empAttendaceDao.searchOrder(empId);
    }

    @Override
    public int dashboardemployeetodayCount() throws SQLException, ClassNotFoundException {
        return empAttendaceDao.dashboardemployeetodayCount();
    }

    @Override
    public List<EmployeeAttendance> getAllAttendance() throws SQLException, ClassNotFoundException {
        return empAttendaceDao.getAllAttendance();
    }
}
