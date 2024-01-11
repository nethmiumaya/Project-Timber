package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.AddCustomerDao;
import lk.ijse.project.Dto.AddCustomer;
import lk.ijse.project.Entity.AddCustomerE;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddcustomerDaoImp implements AddCustomerDao {
    @Override
    public boolean save(final AddCustomerE entity) throws SQLException, ClassNotFoundException {

      return   SQLUtile.execute("INSERT INTO customer VALUES(?,?,?,?,?,?,?)",entity.getCid(),entity.getFirst_name(),entity.getLast_name(),entity.getNic(),entity.getAddress(),entity.getTele_no(),entity.getEmail());

    }
@Override
    public boolean update(final AddCustomerE entity) throws SQLException, ClassNotFoundException {
       return SQLUtile.execute("UPDATE customer SET first_name = ?,last_name = ?,nic = ?, address = ?, tele_no = ?,email = ? WHERE cid = ?", entity.getFirst_name(), entity.getLast_name(), entity.getNic(), entity.getAddress(), entity.getTele_no(), entity.getEmail(), entity.getCid());
    }
@Override
    public AddCustomerE searchOrder(String coid) throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtile.execute("SELECT * FROM customer WHERE cid = ?",coid);

        AddCustomerE entity = null;

        if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String first = resultSet.getString(2);
            String last = resultSet.getString(3);
            String nic = resultSet.getString(4);
            String cus_address = resultSet.getString(5);
            String cus_tel = resultSet.getString(6);
            String email = resultSet.getString(7);

            entity = new AddCustomerE(cus_id, first, last, nic, cus_address, cus_tel, email);
        }

        return entity;
    }
@Override
    public  String generateNextid() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT cid FROM customer ORDER BY cid DESC LIMIT 1");

        String currentcustomerId = null;
        if (resultSet.next()) {
            currentcustomerId = resultSet.getString(1);

            return splitId(currentcustomerId);
        }
        return splitId(null);
    }
    @Override
    public String splitId(String currentcustomerId) {
        if ( currentcustomerId != null) {
            String[] split =  currentcustomerId.split("C");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            return "C00" + id;
        }
        return "C001";
    }

@Override
    public  List<AddCustomerE> searchcustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM customer");


        List<AddCustomerE> cusList = new ArrayList<>();

        while (resultSet.next()) {
            var entity=new AddCustomerE(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)


            );
            cusList.add(entity);
        }
        return cusList;
    }
    @Override
    public AddCustomerE search(String id) throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
    ResultSet resultSet = SQLUtile.execute("SELECT * FROM customer WHERE cid = ?",id);


        AddCustomerE entity = null;

        if(resultSet.next()) {
            entity = new AddCustomerE(
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
             resultSet.getString(4),
            resultSet.getString(5),
            resultSet.getString(6),
             resultSet.getString(7)
);
              }

        return entity;
    }

@Override
    public boolean delete(String cid) throws SQLException, ClassNotFoundException {
      return   SQLUtile.execute("DELETE FROM customer WHERE cid = ?",cid);
    }

@Override
    public  List<AddCustomerE> getAllCustomer() throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();

        ResultSet resultSet = SQLUtile.execute("SELECT * FROM customer");


        List<AddCustomerE> dtoList = new ArrayList<>();



        while (resultSet.next()) {
            String first_name = resultSet.getString(1);
            String last_name = resultSet.getString(2);
            String nic = resultSet.getString(3);
            String address = resultSet.getString(4);
            String tele_no = resultSet.getString(5);
            String email = resultSet.getString(6);
            String cid = resultSet.getString(7);


            var entity = new AddCustomerE(first_name,last_name,nic,address,tele_no,email,cid);
            dtoList.add(entity);
        }
        return dtoList;
    }


}
