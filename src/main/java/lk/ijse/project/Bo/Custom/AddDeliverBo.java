package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Dto.Deliver;

import java.sql.SQLException;
import java.util.List;

public interface AddDeliverBo extends SuperBo {
    boolean save(final Deliver dto) throws SQLException, ClassNotFoundException;

    boolean update(final Deliver dto) throws SQLException, ClassNotFoundException;


    String generateNextid() throws SQLException, ClassNotFoundException;
    String splitId(String currentId);



    Deliver search(String id) throws SQLException, ClassNotFoundException;


    boolean delete(String id) throws SQLException, ClassNotFoundException;

    List<Deliver> searchDeliver(String id) throws SQLException, ClassNotFoundException;
    List<Deliver> getAlldeliver() throws SQLException, ClassNotFoundException;


    List<Deliver> loadAlldeliver() throws SQLException, ClassNotFoundException;



}
