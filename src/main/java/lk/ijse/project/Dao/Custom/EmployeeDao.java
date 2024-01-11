package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.CrudDao;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao extends CrudDao<EmployeeMmanage> {

     ArrayList<String> getAllEmployeeId() throws SQLException, ClassNotFoundException;



     List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException;

     List<EmployeeMmanage>  searchEmployee(String id) throws SQLException, ClassNotFoundException;




     int dashboardemployeecount() throws SQLException, ClassNotFoundException;
}
