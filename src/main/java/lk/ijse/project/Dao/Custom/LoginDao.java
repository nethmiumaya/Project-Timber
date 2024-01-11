package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LoginDao extends SuperDao {
      boolean loginusername(String username, String password) throws SQLException, ClassNotFoundException;
}
