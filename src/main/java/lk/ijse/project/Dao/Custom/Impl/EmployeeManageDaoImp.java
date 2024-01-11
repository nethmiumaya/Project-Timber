package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.EmployeeManageDao;
import lk.ijse.project.Dto.EmployeeMmanage;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManageDaoImp implements EmployeeManageDao {
    @Override
    public  List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT * FROM employee");

        List<EmployeeMmanage> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            String emp_id = resultSet.getString(1);
            String first_name = resultSet.getString(2);
            String last_name = resultSet.getString(3);
            String address = resultSet.getString(4);
            int tele_no = resultSet.getInt(5);
            String join_date = resultSet.getString(6);
            String nic = resultSet.getString(7);

            var dto = new EmployeeMmanage(emp_id,first_name,last_name,address,tele_no,join_date,nic);

            dtoList.add(dto);
        }
        return dtoList;
    }
}
