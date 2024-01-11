package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.AddDeliverDao;
import lk.ijse.project.Dto.Deliver;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddDeliverDaoImp implements AddDeliverDao {
    @Override
    public  boolean save(final Deliver dto) throws SQLException, ClassNotFoundException {

        return SQLUtile.execute("INSERT INTO deliver VALUES(?,?,?,?,?)",dto.getDeliver_id(),dto.getAddress(),dto.getTele_no(),dto.getDueDate(),dto.getPayment());
    }
    @Override
    public boolean update(Deliver dto) throws SQLException, ClassNotFoundException {

       return SQLUtile.execute("UPDATE deliver SET  address = ?, tele_no = ?,dueDate = ?, payment = ? WHERE deliver_id = ?",dto.getAddress(),dto.getTele_no(),dto.getDueDate(),dto.getPayment(),dto.getDeliver_id());
    }
    @Override
    public  List<Deliver> searchDeliver(String id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT * FROM deliver");

        List<Deliver> deliverList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new Deliver(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5)
            );
            deliverList.add(dto);
        }
        return deliverList;
    }
    @Override
    public List<Deliver> getAlldeliver() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT * FROM deliver");
        List<Deliver> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            String did= resultSet.getString(1);
            String address  = resultSet.getString(2);
            int tele_no = resultSet.getInt(3);
            String date = String.valueOf(resultSet.getDate(4));
            double payment = resultSet.getDouble(5);


            var dto = new Deliver(did,address,tele_no,date,payment);
            dtoList.add(dto);
        }
        return dtoList;
    }
    @Override
    public boolean delete(String did) throws SQLException, ClassNotFoundException {

        return SQLUtile.execute("DELETE FROM deliver WHERE deliver_id = ?",did);
    }
@Override
    public List<Deliver> loadAlldeliver() throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtile.execute("SELECT * FROM deliver");

        List<Deliver> bookList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new Deliver(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5)


            );
            bookList.add(dto);
        }
        return bookList;
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
    public Deliver search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


}
