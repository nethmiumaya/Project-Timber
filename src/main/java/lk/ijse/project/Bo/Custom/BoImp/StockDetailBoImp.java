package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.StockDetailBo;
import lk.ijse.project.Dao.Custom.StockDetailDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Item;

import java.sql.SQLException;
import java.util.List;

public class StockDetailBoImp implements StockDetailBo {
    StockDetailDao stockDetailDao = (StockDetailDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.StockDetail);

    @Override
    public List<Item> getAllStock() throws SQLException, ClassNotFoundException {
        return stockDetailDao.getAllStock();
    }

    @Override
    public List<Item> loadAllItem() throws SQLException, ClassNotFoundException {
        return stockDetailDao.getAllStock();
    }
}
