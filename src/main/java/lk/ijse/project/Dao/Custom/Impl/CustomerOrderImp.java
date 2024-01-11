package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.CustomerOrderDao;
import lk.ijse.project.db.DbConnection;
import lk.ijse.project.Dto.AddCustomerOrderClass;
import lk.ijse.project.Dto.Tm.CartTm;
import lk.ijse.project.Dto.placeOrder;
import lk.ijse.project.utill.SQLUtile;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderImp implements CustomerOrderDao {
    @Override
    public  String generateNextcustomerOid() throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT cus_order_id FROM customer_order ORDER BY cus_order_id DESC LIMIT 1");
        String currentcustomerId = null;
        if (resultSet.next()) {
            currentcustomerId = resultSet.getString(1);

            return splitcustomerId(currentcustomerId);
        }
        return splitcustomerId(null);
    }
    @Override
    public   String splitcustomerId(String currentcustomerId) {
        if ( currentcustomerId != null) {
            String[] split =  currentcustomerId.split("O");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            return "O00" + id;
        }
        return "O001";

    }
@Override
    public boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException, ClassNotFoundException {
        for (CartTm cartTm : tmList) {
            if (!saveOrderDetail(orderId, cartTm)) {
                return false;
            }
        }
        return true;
    }
@Override
    public boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();
        return SQLUtile.execute("INSERT INTO customer_order VALUES(?, ?, ?, ?)",orderId,cartTm.getProduct_id(),cartTm.getQty(),cartTm.getUnit_price());

    }
@Override
    public  boolean saveCustomerOrder(final AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException {
        
       return SQLUtile.execute("INSERT INTO customer_order VALUES(?,?,?,?,?,?,?)",dto.getCus_order_id(),dto.getCid(),dto.getTotal_price(),dto.getUnit_price(),dto.getQty(),dto.getDate(),dto.getTime());
    }
@Override
    public  boolean updateCustomerOrder(final AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException {
 //   "UPDATE customer SET city = ?, street = ?, house_no = ?, contact_no = ?, emp_id = ?, account_type = ?, email = ?, first_name = ?, last_name = ?, nic = ? WHERE cus_id = ?",customer.getCity(),customer.getStreet(),customer.getHouse_no(),customer.getContact_no(),customer.getEmp_id(),customer.getAccount_type(),customer.getEmail(),customer.getFirst_name(),customer.getLast_name(),customer.getNic(),customer.getCus_id());

        return SQLUtile.execute("UPDATE customer_order SET cid = ?, total_price = ?,unit_price = ?,  qty = ?,date = ?,time =? WHERE cus_order_id = ?",dto.getCid(),dto.getTotal_price(),dto.getUnit_price(),dto.getQty(),dto.getDate(),dto.getTime(),dto.getCus_order_id());
    }
@Override
    public  boolean saveCustomerOrder(placeOrder dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        List<CartTm> list = dto.getTmList();

        String sql = "INSERT INTO customer_order VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getOrder_id());
        pstm.setString(2, dto.getCus_order_id());
        pstm.setDouble(3, list.get(0).getTotal_price());
        pstm.setDouble(4, list.get(0).getUnit_price());
        pstm.setInt(5, list.get(0).getQty());
        pstm.setDate(6, Date.valueOf(dto.getDate()));
        pstm.setTime(7, Time.valueOf(LocalTime.now()));

        return pstm.executeUpdate() > 0;
    }

@Override
    public List<AddCustomerOrderClass> getAllCustomerOrder() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT * FROM customer_order");

        List<AddCustomerOrderClass> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String cus_order_id = resultSet.getString(1);
            String cid = resultSet.getString(2);
            double unit_price = resultSet.getDouble(3);
            double total_price = resultSet.getDouble(4);
            int qty = resultSet.getInt(5);
            Date date = resultSet.getDate(6);
            Time time =resultSet.getTime(7);

            var dto = new AddCustomerOrderClass(cus_order_id,cid,unit_price,total_price,qty,date,time);
            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public boolean deleteCustomerOrder(String cus_order_id) throws SQLException, ClassNotFoundException {

        return SQLUtile.execute("DELETE FROM customer_order WHERE cus_order_id = ?",cus_order_id);
    }
@Override
    public  List<AddCustomerOrderClass> searchCustomerOrder(String id) throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM customer_order");

        List<AddCustomerOrderClass> cusList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new AddCustomerOrderClass(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getDate(6),
                    resultSet.getTime(7)


            );
            cusList.add(dto);
        }
        return cusList;
    }
@Override
    public ArrayList<String> getAllCustomerOrderId() throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT cus_order_id from customer_order order by LENGTH(cus_order_id),cus_order_id");

        ArrayList<String> list = new ArrayList<>();

        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        return list;
    }

}
