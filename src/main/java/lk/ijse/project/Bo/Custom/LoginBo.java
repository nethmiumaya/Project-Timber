package lk.ijse.project.Bo.Custom;

import java.sql.SQLException;

public interface LoginBo extends  SuperBo {

    boolean loginusername(String username, String password) throws SQLException, ClassNotFoundException;

}
