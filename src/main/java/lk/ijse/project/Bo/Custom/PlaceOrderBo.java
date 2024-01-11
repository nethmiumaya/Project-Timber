package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dao.Custom.CustomerOrderDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomerOrderClass;
import lk.ijse.project.Dto.Product;
import lk.ijse.project.Dto.Tm.CartTm;
import lk.ijse.project.Dto.placeOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo extends SuperBo{

     CustomerOrderDao customerOrderDao = (CustomerOrderDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.CustomerOrder);
     boolean placeOrder(placeOrder pDto) throws SQLException;
     String generateNextcustomerOid() throws SQLException, ClassNotFoundException;
     String splitcustomerId(String currentcustomerId);



     boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException, ClassNotFoundException;


     boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException, ClassNotFoundException;
     boolean saveCustomerOrder(final AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException;


     boolean updateCustomerOrder(final AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException;

     boolean saveCustomerOrder(placeOrder dto) throws SQLException;
     boolean saveProduct(Product dto) throws SQLException, ClassNotFoundException;

     boolean deleteProduct(String productId) throws SQLException, ClassNotFoundException;
     List<Product> loadAllProductID() throws SQLException, ClassNotFoundException;

     Product searchProduct(String pid) throws SQLException, ClassNotFoundException;

     String generateNextOrderId() throws SQLException, ClassNotFoundException;

     String splitOrderId(String currentOrderId);

     String generateNextProductid() throws SQLException, ClassNotFoundException;
     String splitproductId(String currentcustomerId);

     List<AddCustomerOrderClass> getAllCustomerOrder() throws SQLException, ClassNotFoundException;

     boolean deleteCustomerOrder(String cus_order_id) throws SQLException, ClassNotFoundException;

     List<AddCustomerOrderClass> searchCustomerOrder(String id) throws SQLException, ClassNotFoundException;


     ArrayList<String> getAllCustomerOrderId() throws SQLException, ClassNotFoundException;

      List<Product> getAllProducts() throws SQLException, ClassNotFoundException;
     public boolean updateProduct(Product dto) throws SQLException, ClassNotFoundException;
}
