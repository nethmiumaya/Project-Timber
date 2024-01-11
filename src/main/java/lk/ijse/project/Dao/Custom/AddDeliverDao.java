package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.CrudDao;
import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.Deliver;

import java.sql.SQLException;
import java.util.List;

public interface AddDeliverDao extends CrudDao<Deliver> {
    boolean save(Deliver dto) throws SQLException, ClassNotFoundException;

    boolean update(Deliver dto) throws SQLException, ClassNotFoundException;

    List<Deliver> searchDeliver(String id) throws SQLException, ClassNotFoundException;
     List<Deliver> getAlldeliver() throws SQLException, ClassNotFoundException;


    List<Deliver> loadAlldeliver() throws SQLException, ClassNotFoundException;

}
