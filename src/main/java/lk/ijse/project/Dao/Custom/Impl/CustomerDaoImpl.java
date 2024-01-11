package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.CustomerDao;
import lk.ijse.project.Dto.AddCustomer;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<AddCustomer> getAllCustomers() throws SQLException, ClassNotFoundException {

        ResultSet resultSet =  SQLUtile.execute("SELECT * FROM customer");

        List<AddCustomer> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String cid = resultSet.getString(1);
            String firstname = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            String nic = resultSet.getString(4);
            String address = resultSet.getString(5);
            String tele = resultSet.getString(6);
            String email = resultSet.getString(7);

            var dto = new AddCustomer(cid,firstname,lastname,nic,address,tele,email);
            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public List<AddCustomer> loadAllCustomers() throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute( "SELECT * FROM customer");

        List<AddCustomer> cusList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new AddCustomer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString( 5),
                    resultSet.getString( 6),
                    resultSet.getString(7)
            );
            cusList.add(dto);
        }
        return cusList;
    }
@Override
    public AddCustomer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM customer WHERE cid = ?",id);

        AddCustomer dto = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String first = resultSet.getString(2);
            String last = resultSet.getString(3);
            String nic = resultSet.getString(4);
            String cus_address = resultSet.getString(5);
            String cus_tel = resultSet.getString(6);
            String email = resultSet.getString(7);

            dto = new AddCustomer(cus_id, first, last, nic, cus_address, cus_tel, email);
        }

        return dto;
    }

}
