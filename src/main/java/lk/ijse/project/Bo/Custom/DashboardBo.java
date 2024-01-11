package lk.ijse.project.Bo.Custom;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.SQLException;

public interface DashboardBo extends SuperBo{
    ObservableList<PieChart.Data> getFundDataForPieChart() throws SQLException, ClassNotFoundException;

    ObservableList<PieChart.Data> getFundData2ForPieChart() throws SQLException, ClassNotFoundException;

}
