package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.DeliverDao;
import lk.ijse.project.db.DbConnection;
import lk.ijse.project.Dto.Deliver;
import lk.ijse.project.utill.SQLUtile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliverImp implements DeliverDao {
    public List<Deliver> getAllDeliver() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT * FROM deliver");

        List<Deliver> dtoList = new ArrayList<>();

        while (resultSet.next()) {


            String deliver_id = resultSet.getString(1);
            String address = resultSet.getString(2);
            int teleno = resultSet.getInt(3);
            String date = resultSet.getString(4);
            double payment = resultSet.getDouble(5);

            var dto = new Deliver(deliver_id,address,teleno,date,payment);

            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<Deliver> loadAllDeliver() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM deliver");

        List<Deliver> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            var dto=new Deliver(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getDouble( 5)

            );
            dtoList .add(dto);
        }
        return dtoList;
    }

}
