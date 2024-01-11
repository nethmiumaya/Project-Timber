package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.CrudDao;
import lk.ijse.project.Dto.EmployeeAttendance;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.List;

public interface EmpAttendaceDao extends CrudDao<EmployeeAttendance> {


    EmployeeMmanage searchOrder(String empId) throws SQLException, ClassNotFoundException;

    int dashboardemployeetodayCount() throws SQLException, ClassNotFoundException;

    List<EmployeeAttendance> getAllAttendance() throws SQLException, ClassNotFoundException;
}
