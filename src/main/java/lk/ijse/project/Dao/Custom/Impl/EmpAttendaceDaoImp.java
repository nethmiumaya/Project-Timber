package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.EmpAttendaceDao;
import lk.ijse.project.Dto.EmployeeAttendance;
import lk.ijse.project.Dto.EmployeeMmanage;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpAttendaceDaoImp implements EmpAttendaceDao {
    @Override
    public  boolean save(EmployeeAttendance dto) throws SQLException, ClassNotFoundException {
        return SQLUtile.execute("INSERT INTO attendance VALUES(?,?,?)",dto.getName(),dto.getDate(),dto.getJobrole());

    }
@Override
    public  boolean update(EmployeeAttendance dto) throws SQLException, ClassNotFoundException {
        return SQLUtile.execute("UPDATE attendance SET  date = ?,jobrole = ? WHERE name = ?",dto.getDate(),dto.getJobrole(),dto.getName());

    }

    @Override
    public String generateNextid() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String splitId(String currentId) {
        return null;
    }

    @Override
    public EmployeeAttendance search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public EmployeeMmanage searchOrder(String empId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT * FROM employee WHERE name = ?",empId);


        EmployeeAttendance dto = null;

        if(resultSet.next()) {

            String name = resultSet.getString(1);
            String date = resultSet.getString(2);
            String jobrole = resultSet.getString(3);



            dto = new EmployeeAttendance(name,date,jobrole);
        }

        return dto;
    }
@Override
    public int dashboardemployeetodayCount() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtile.execute("SELECT COUNT(name) FROM attendance WHERE date = DATE(NOW())");

        if (set.next()){
            int count = set.getInt(1);
            return count;
        }
        return 0;
    }

@Override
    public boolean delete(String emp_id) throws SQLException, ClassNotFoundException {
       return SQLUtile.execute("DELETE FROM attendance WHERE name = ?",emp_id);
    }
@Override
    public List<EmployeeAttendance> getAllAttendance() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM attendance");

        List<EmployeeAttendance> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            String name= resultSet.getString(1);
            String date = String.valueOf(resultSet.getDate(2));
            String jobrole  = resultSet.getString(3);

            var dto = new EmployeeAttendance(name,date,jobrole);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
