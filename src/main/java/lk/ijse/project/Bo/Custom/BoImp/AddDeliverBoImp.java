package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.AddDeliverBo;
import lk.ijse.project.Dao.Custom.AddDeliverDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.Deliver;

import java.sql.SQLException;
import java.util.List;

public class AddDeliverBoImp implements AddDeliverBo {
    AddDeliverDao addDeliverDao = (AddDeliverDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.AddDeliver);

    @Override
    public boolean save(Deliver dto) throws SQLException, ClassNotFoundException {
        return addDeliverDao.save(dto);
    }

    @Override
    public boolean update(Deliver dto) throws SQLException, ClassNotFoundException {
        return addDeliverDao.update(dto);
    }

    @Override
    public String generateNextid() throws SQLException, ClassNotFoundException {
        return addDeliverDao.generateNextid();
    }

    @Override
    public String splitId(String currentId) {
        return addDeliverDao.splitId(currentId);
    }

    @Override
    public Deliver search(String id) throws SQLException, ClassNotFoundException {
        return addDeliverDao.search(id);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return addDeliverDao.delete(id);
    }

    @Override
    public List<Deliver> searchDeliver(String id) throws SQLException, ClassNotFoundException {
        return addDeliverDao.searchDeliver(id);
    }

    @Override
    public List<Deliver> getAlldeliver() throws SQLException, ClassNotFoundException {
        return addDeliverDao.getAlldeliver();
    }

    @Override
    public List<Deliver> loadAlldeliver() throws SQLException, ClassNotFoundException {
        return addDeliverDao.loadAlldeliver();
    }
}
