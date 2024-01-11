package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.SupplierOrderBo;
import lk.ijse.project.Dao.Custom.SupplierOrderDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierOrderBoImp implements SupplierOrderBo {
    SupplierOrderDao supplierOrderDao = (SupplierOrderDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.SupplierOrder);

    @Override
    public boolean saveSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException {
        return supplierOrderDao.saveSupplierOrder(dto);
    }

    @Override
    public boolean updateSupplierOrder(Supplier dto) throws SQLException, ClassNotFoundException {
        return supplierOrderDao.updateSupplierOrder(dto);
    }

    @Override
    public boolean deleteSupplierOrder(String oId) throws SQLException, ClassNotFoundException {
        return supplierOrderDao.deleteSupplierOrder(oId);
    }

    @Override
    public List<Supplier> getAllSupplier() throws SQLException, ClassNotFoundException {
        return supplierOrderDao.getAllSupplier();
    }
}
