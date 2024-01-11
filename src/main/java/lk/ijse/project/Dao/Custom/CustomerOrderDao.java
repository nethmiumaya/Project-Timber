package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.AddCustomerOrderClass;
import lk.ijse.project.Dto.Tm.CartTm;
import lk.ijse.project.Dto.placeOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface CustomerOrderDao extends SuperDao {
     String generateNextcustomerOid() throws SQLException, ClassNotFoundException;
     String splitcustomerId(String currentcustomerId);

     boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException, ClassNotFoundException;


     boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException, ClassNotFoundException;
     boolean saveCustomerOrder(final AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException;


     boolean updateCustomerOrder(final AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException;

     boolean saveCustomerOrder(placeOrder dto) throws SQLException;






     List<AddCustomerOrderClass> getAllCustomerOrder() throws SQLException, ClassNotFoundException;

     boolean deleteCustomerOrder(String cus_order_id) throws SQLException, ClassNotFoundException;

     List<AddCustomerOrderClass> searchCustomerOrder(String id) throws SQLException, ClassNotFoundException;


     ArrayList<String> getAllCustomerOrderId() throws SQLException, ClassNotFoundException;

}
