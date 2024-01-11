package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.StockBo;
import lk.ijse.project.Dao.Custom.StockDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Item;

import java.sql.SQLException;
import java.util.List;

public class StockBoImp implements StockBo {
    StockDao stockDao = (StockDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.Stock);

    @Override
    public boolean save(Item dto) throws SQLException, ClassNotFoundException {
        return stockDao.save(dto);
    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
        return stockDao.update(dto);
    }

    @Override
    public String generateNextid() throws SQLException, ClassNotFoundException {
        return stockDao.generateNextid();
    }

    @Override
    public String splitId(String currentId) {
        return stockDao.splitId(currentId);
    }

    @Override
    public Item search(String id) throws SQLException, ClassNotFoundException {
        return stockDao.search(id);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return stockDao.delete(id);
    }

    @Override
    public List<Item> searchItem(String code) throws SQLException, ClassNotFoundException {
        return stockDao.searchItem(code);
    }

    @Override
    public String generateNextItemid() throws SQLException, ClassNotFoundException {
        return stockDao.generateNextItemid();
    }

    @Override
    public String splititemId(String currentItemrId) {
        return stockDao.splititemId(currentItemrId);
    }

    @Override
    public List<Item> getAllItem() throws SQLException, ClassNotFoundException {
        return stockDao.getAllItem();
    }

    @Override
    public List<Item> loadAllItem() throws SQLException, ClassNotFoundException {
        return stockDao.loadAllItem();
    }

    @Override
    public int dashboardStockCount() throws SQLException, ClassNotFoundException {
        return stockDao.dashboardStockCount();
    }
}
