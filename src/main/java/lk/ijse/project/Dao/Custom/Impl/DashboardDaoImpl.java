package lk.ijse.project.Dao.Custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.project.Dao.Custom.DashboardDao;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardDaoImpl implements DashboardDao {
    @Override
    public  ObservableList<PieChart.Data> getFundDataForPieChart() throws SQLException, ClassNotFoundException {
       ResultSet subscriptionResult = SQLUtile.execute("select count(*) from deliver where dueDate = DATE(NOW())");
        ObservableList<PieChart.Data> fundData = FXCollections.observableArrayList();

        if(subscriptionResult.next()){
            Double subscriptionTotal = subscriptionResult.getDouble(1);
            fundData.add(new PieChart.Data("Available_Delivery_Count", subscriptionTotal));
        }

        return fundData;
    }
@Override
    public  ObservableList<PieChart.Data> getFundData2ForPieChart() throws SQLException, ClassNotFoundException {

       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet BookingResult = SQLUtile.execute("SELECT COUNT(booking_id) FROM booking_detail WHERE date = DATE(NOW())");
        ObservableList<PieChart.Data> fundData1 = FXCollections.observableArrayList();

        if(BookingResult.next()){
            Double membershipTotal = BookingResult.getDouble(1);
            fundData1.add(new PieChart.Data("Availability_Booking_Count", membershipTotal));
        }
        return fundData1;
    }
}
