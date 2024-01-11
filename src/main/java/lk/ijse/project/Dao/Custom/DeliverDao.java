package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.Deliver;

import java.sql.SQLException;
import java.util.List;

public interface DeliverDao extends SuperDao {
    public List<Deliver> getAllDeliver() throws SQLException, ClassNotFoundException;

    public List<Deliver> loadAllDeliver() throws SQLException, ClassNotFoundException;

}
