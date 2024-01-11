package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.LoginDao;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    public boolean loginusername(String username, String password) throws SQLException, ClassNotFoundException {
        {
            ResultSet resultSet = SQLUtile.execute("SELECT * FROM user WHERE username =? AND password = ?",username,password);
           /* Connection connection =
                    DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM user WHERE username =? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();*/
            return resultSet.next();
        }
    }
}
