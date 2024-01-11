package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.CustomerOrderDao;
import lk.ijse.project.Dao.Custom.CustomerOrderDetailDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dao.Custom.PlaceOrderDao;
import lk.ijse.project.Dto.placeOrder;
import lk.ijse.project.db.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class placeOrderDaoImp implements PlaceOrderDao {



    CustomerOrderDao customerOrderDao = (CustomerOrderDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.CustomerOrder);

    CustomerOrderDetailDao customerOrderDetailDao = (CustomerOrderDetailDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.CustomerOrderDetail);

@Override
    public  boolean placeOrder(placeOrder pDto) throws SQLException {
        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = customerOrderDao.saveCustomerOrder(pDto);
            if (isOrderSaved) {
                boolean isUpdated = customerOrderDetailDao.updateProduct(pDto.getTmList());
                if(isUpdated) {
                    connection.commit();
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return result;
    }
}
