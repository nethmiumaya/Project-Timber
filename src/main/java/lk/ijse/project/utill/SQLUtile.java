package lk.ijse.project.utill;

import lk.ijse.project.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
public class SQLUtile {



    public static <T>T execute(String sql, Object...arg) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i = 0; i < arg.length; i++) {
            statement.setObject((i+1),arg[i]);
        }
        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) statement.executeQuery();
        }else {
            return(T)(Boolean)(statement.executeUpdate()>0);
        }
    }
}
