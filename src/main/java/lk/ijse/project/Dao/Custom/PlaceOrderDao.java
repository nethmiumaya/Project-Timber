package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.placeOrder;

import java.sql.SQLException;

public interface PlaceOrderDao extends SuperDao {
     boolean placeOrder(placeOrder pDto) throws SQLException;
}
