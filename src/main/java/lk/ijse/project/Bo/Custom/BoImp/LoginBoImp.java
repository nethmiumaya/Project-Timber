package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.LoginBo;
import lk.ijse.project.Dao.Custom.LoginDao;
import lk.ijse.project.Dao.DaoFactory;

import java.sql.SQLException;

public class LoginBoImp implements LoginBo {
    LoginDao loginDao = (LoginDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.Login);

    @Override
    public boolean loginusername(String username, String password) throws SQLException, ClassNotFoundException {
        return loginDao.loginusername(username,password);
    }
}
