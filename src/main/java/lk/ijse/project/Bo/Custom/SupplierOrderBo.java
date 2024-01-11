package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierOrderBo extends SuperBo{
    boolean saveSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException;

    boolean updateSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException;

    boolean deleteSupplierOrder(String oId) throws SQLException, ClassNotFoundException;

    List<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException;

}
