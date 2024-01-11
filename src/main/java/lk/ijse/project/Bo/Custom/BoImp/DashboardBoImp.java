package lk.ijse.project.Bo.Custom.BoImp;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.project.Bo.Custom.DashboardBo;
import lk.ijse.project.Dao.Custom.DashboardDao;
import lk.ijse.project.Dao.DaoFactory;

import java.sql.SQLException;

public class DashboardBoImp implements DashboardBo {
    DashboardDao dashboardDao = (DashboardDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.Dashboard);

    @Override
    public ObservableList<PieChart.Data> getFundDataForPieChart() throws SQLException, ClassNotFoundException {
        return dashboardDao.getFundDataForPieChart();
    }

    @Override
    public ObservableList<PieChart.Data> getFundData2ForPieChart() throws SQLException, ClassNotFoundException {
        return dashboardDao.getFundData2ForPieChart();
    }
}
