package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.EmployeeAttendance;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.List;

public interface EmpAttendanceBo extends SuperBo{
    boolean save(final EmployeeAttendance dto) throws SQLException, ClassNotFoundException;

    boolean update(final EmployeeAttendance dto) throws SQLException, ClassNotFoundException;


    String generateNextid() throws SQLException, ClassNotFoundException;
    String splitId(String currentId);



    EmployeeAttendance search(String id) throws SQLException, ClassNotFoundException;


    boolean delete(String id) throws SQLException, ClassNotFoundException;

    EmployeeMmanage searchOrder(String empId) throws SQLException, ClassNotFoundException;

    int dashboardemployeetodayCount() throws SQLException, ClassNotFoundException;

    List<EmployeeAttendance> getAllAttendance() throws SQLException, ClassNotFoundException;



}
