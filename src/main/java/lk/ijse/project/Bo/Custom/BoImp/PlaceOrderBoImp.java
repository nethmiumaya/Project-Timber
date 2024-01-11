package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.PlaceOrderBo;
import lk.ijse.project.Dao.Custom.CustomerOrderDao;
import lk.ijse.project.Dao.Custom.CustomerOrderDetailDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddCustomerOrderClass;
import lk.ijse.project.Dto.Product;
import lk.ijse.project.Dto.Tm.CartTm;
import lk.ijse.project.Dto.placeOrder;
import lk.ijse.project.db.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImp implements PlaceOrderBo {
    CustomerOrderDao customerOrderDao = (CustomerOrderDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.CustomerOrder);

    CustomerOrderDetailDao customerOrderDetailDao = (CustomerOrderDetailDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.CustomerOrderDetail);

    @Override
    public  boolean placeOrder(placeOrder pDto) throws SQLException {
        boolean result = false;
        Connection connection = null;
          connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = customerOrderDao.saveCustomerOrder(pDto);
            if (isOrderSaved) {
                boolean isUpdated = customerOrderDetailDao.updateProduct(pDto.getTmList());
                if(isUpdated) {
                    connection.commit();
                    result = true;
                }else connection.rollback();
            }else connection.rollback();

        return result;
    }

    @Override
    public String generateNextcustomerOid() throws SQLException, ClassNotFoundException {
        return customerOrderDao.generateNextcustomerOid();
    }

    @Override
    public String splitcustomerId(String currentcustomerId) {
        return customerOrderDao.splitcustomerId(currentcustomerId);
    }

    @Override
    public boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException, ClassNotFoundException {
        return customerOrderDao.saveOrderDetail(orderId, tmList);
    }

    @Override
    public boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException, ClassNotFoundException {
        return customerOrderDao.saveOrderDetail(orderId, cartTm);
    }

    @Override
    public boolean saveCustomerOrder(AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException {
        return customerOrderDao.saveCustomerOrder(dto);
    }

    @Override
    public boolean updateCustomerOrder(AddCustomerOrderClass dto) throws SQLException, ClassNotFoundException {
        return customerOrderDao.updateCustomerOrder(dto);
    }

    @Override
    public boolean saveCustomerOrder(placeOrder dto) throws SQLException {
        return customerOrderDao.saveCustomerOrder(dto);
    }

    @Override
    public boolean saveProduct(Product dto) throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.saveProduct(dto);
    }

    @Override
    public boolean deleteProduct(String productId) throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.deleteProduct(productId);
    }

    @Override
    public List<Product> loadAllProductID() throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.loadAllProductID();
    }

    @Override
    public Product searchProduct(String pid) throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.searchProduct(pid);
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.generateNextOrderId();
    }

    @Override
    public String splitOrderId(String currentOrderId) {
        return customerOrderDetailDao.splitOrderId(currentOrderId);
    }

    @Override
    public String generateNextProductid() throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.generateNextProductid();
    }

    @Override
    public String splitproductId(String currentcustomerId) {
        return customerOrderDetailDao.splitproductId(currentcustomerId);
    }

    @Override
    public List<AddCustomerOrderClass> getAllCustomerOrder() throws SQLException, ClassNotFoundException {
        return customerOrderDao.getAllCustomerOrder();
    }

    @Override
    public boolean deleteCustomerOrder(String cus_order_id) throws SQLException, ClassNotFoundException {
        return customerOrderDao.deleteCustomerOrder(cus_order_id);
    }

    @Override
    public List<AddCustomerOrderClass> searchCustomerOrder(String id) throws SQLException, ClassNotFoundException {
        return customerOrderDao.searchCustomerOrder(id);
    }

    @Override
    public ArrayList<String> getAllCustomerOrderId() throws SQLException, ClassNotFoundException {
        return customerOrderDao.getAllCustomerOrderId();
    }

    @Override
    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.getAllProducts();
    }

    @Override
    public boolean updateProduct(Product dto) throws SQLException, ClassNotFoundException {
        return customerOrderDetailDao.updateProduct(dto);
    }


}
