package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.DelieverBo;
import lk.ijse.project.Dao.Custom.DeliverDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Deliver;

import java.sql.SQLException;
import java.util.List;

public class DeliverBoImp implements DelieverBo {
    DeliverDao deliverDao = (DeliverDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.Deliver);

    @Override
    public List<Deliver> getAllDeliver() throws SQLException, ClassNotFoundException {
        return deliverDao.getAllDeliver();
    }

    @Override
    public List<Deliver> loadAllDeliver() throws SQLException, ClassNotFoundException {
        return deliverDao.loadAllDeliver();
    }
}
