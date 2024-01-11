package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBo extends SuperBo{
    boolean save(final EmployeeMmanage dto) throws SQLException, ClassNotFoundException;

    boolean update(final EmployeeMmanage dto) throws SQLException, ClassNotFoundException;


    String generateNextid() throws SQLException, ClassNotFoundException;
    String splitId(String currentId);



    EmployeeMmanage search(String id) throws SQLException, ClassNotFoundException;


    boolean delete(String id) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllEmployeeId() throws SQLException, ClassNotFoundException;



    List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException;

    List<EmployeeMmanage>  searchEmployee(String id) throws SQLException, ClassNotFoundException;




    int dashboardemployeecount() throws SQLException, ClassNotFoundException;



}
