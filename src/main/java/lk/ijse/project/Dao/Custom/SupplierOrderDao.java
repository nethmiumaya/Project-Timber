package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierOrderDao extends SuperDao {
     boolean saveSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException;

     boolean updateSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException;

     boolean deleteSupplierOrder(String oId) throws SQLException, ClassNotFoundException;

     List<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException;
}
