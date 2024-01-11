package lk.ijse.project.Dao.Custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.db.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DashboardDao extends SuperDao {
    ObservableList<PieChart.Data> getFundDataForPieChart() throws SQLException, ClassNotFoundException;

     ObservableList<PieChart.Data> getFundData2ForPieChart() throws SQLException, ClassNotFoundException;
}
