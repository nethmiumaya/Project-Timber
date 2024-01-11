package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.EmployeeDao;
import lk.ijse.project.Dto.EmployeeMmanage;
import lk.ijse.project.utill.SQLUtile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {
    @Override
     public boolean update(EmployeeMmanage dto) throws SQLException, ClassNotFoundException {

        return   SQLUtile.execute("UPDATE employee SET  first_name = ?, last_name = ?,address = ?, tele_no = ?,join_date =?,nic =? WHERE emp_id = ?",dto.getFirst_name(),dto.getLast_name(),dto.getAddress(),dto.getTele_no(),dto.getJoin_date(),dto.getNic(),dto.getEmployee_id());
    }
@Override
    public  boolean save(EmployeeMmanage dto) throws SQLException, ClassNotFoundException {

       return SQLUtile.execute("INSERT INTO employee VALUES(?,?,?,?,?,?,?)",dto.getEmployee_id(),dto.getFirst_name(),dto.getLast_name(),dto.getAddress(),dto.getTele_no(),dto.getJoin_date(),dto.getNic());
    }
@Override
    public ArrayList<String> getAllEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT emp_id FROM employee ORDER BY LENGTH(emp_id),emp_id");
        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }
@Override
    public String generateNextid() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT emp_id FROM employee ORDER BY emp_id DESC LIMIT 1");

        String currentemployeeId = null;
        if (resultSet.next()) {
            currentemployeeId = resultSet.getString(1);

            return splitId(currentemployeeId);
        }
        return splitId(null);
    }
    @Override
     public String splitId(String currentemployeeId) {
        if ( currentemployeeId != null) {
            String[] split =  currentemployeeId.split("E");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            return "E00" + id;
        }
        return "E001";
    }

    @Override
    public EmployeeMmanage search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<EmployeeMmanage> getAllEmployee() throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM employee");

        List<EmployeeMmanage> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            String employee_id= resultSet.getString(1);
            String  first_name = resultSet.getString(2);
            String last_name = resultSet.getString(3);
            String address = resultSet.getString(4);
            int tele_no = resultSet.getInt(5);
            String join_date  = resultSet.getString(6);
            String nic = resultSet.getString(7);


            var dto = new EmployeeMmanage(employee_id,first_name,last_name,address,tele_no,join_date,nic);
            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public List<EmployeeMmanage>  searchEmployee(String id) throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet=SQLUtile.execute("SELECT * FROM employee");

        List<EmployeeMmanage> empList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new EmployeeMmanage(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7)


            );
            empList.add(dto);
        }
        return empList;
    }

@Override

    public boolean delete(String employeeId) throws SQLException, ClassNotFoundException {
      return   SQLUtile.execute("DELETE FROM employee WHERE emp_id = ?",employeeId);
    }

@Override
    public  int dashboardemployeecount() throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();
        ResultSet set = SQLUtile.execute("select COUNT(emp_id) from employee");
        if (set.next()){
            int count = set.getInt(1);
            return count;
        }
        return 0;
    }
}
