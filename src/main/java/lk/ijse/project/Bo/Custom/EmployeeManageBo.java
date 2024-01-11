package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeManageBo extends SuperBo {
    List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException;
}
