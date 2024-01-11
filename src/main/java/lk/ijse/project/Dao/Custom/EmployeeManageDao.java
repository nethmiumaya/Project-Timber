package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.EmployeeMmanage;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeManageDao extends SuperDao {
    List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException;
}