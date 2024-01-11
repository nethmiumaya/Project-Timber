package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.Deliver;

import java.sql.SQLException;
import java.util.List;

public interface DelieverBo extends SuperBo{
    public List<Deliver> getAllDeliver() throws SQLException, ClassNotFoundException;

    public List<Deliver> loadAllDeliver() throws SQLException, ClassNotFoundException;


}
