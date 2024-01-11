package lk.ijse.project.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.project.Bo.Custom.*;


import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static lk.ijse.project.utill.Navigation.switchNavigation;

public class DashboardPageController {




    @FXML
    private Label lblemployeecount;

    @FXML
    private Label lblordercount;

    @FXML
    private Label lblbookingcount;

    @FXML
    private Label lblstockcount;

    @FXML
    private AnchorPane piechartPane;

    @FXML
    private Label lbltime;

    @FXML
    private Label lbldate;

    @FXML
    private AnchorPane piechart2Pane;



    EmployeeBo employeeBo = (EmployeeBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Employee);
    EmpAttendanceBo empAttendaceBo = (EmpAttendanceBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.EmpAttendance);

    StockBo stockBo = (StockBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Stock);

    BookingBo bookingBo = (BookingBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Booking);

    DashboardBo dashboardBo = (DashboardBo) BoFactory.getBoFactory().getBo(BoFactory.BoType.Dashboard);

    @FXML
        private void initialize() throws ClassNotFoundException {
        pieChart1();
        pieChart2();
        setTime();
        setDate();
            try {
                showDashboardValue(employeeBo);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                todayemployeecount(empAttendaceBo);
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        try {
            showbookingValue(bookingBo);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            showStockDetail(stockBo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void setDate() {
        String date = String.valueOf(LocalDate.now());
        lbldate.setText(date);
    }
    private void setTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        lbltime.setText(currentTime.format(formatter));
    }



    private void showDashboardValue(EmployeeBo AddEmployeeModel) throws SQLException, ClassNotFoundException {
            int totalemployee = employeeBo.dashboardemployeecount();
            lblemployeecount.setText(String.valueOf(totalemployee));
        }


    private void todayemployeecount(EmpAttendanceBo EmployeeAttendanceModel) throws SQLException, ClassNotFoundException {
        int todayemployeecount = empAttendaceBo.dashboardemployeetodayCount();
        lblordercount.setText(String.valueOf(todayemployeecount));
    }


        private void showbookingValue(BookingBo BookingDetailModel) throws SQLException, ClassNotFoundException {
        int todayBookingCount = bookingBo.dashboardtodaybooking();
        lblbookingcount.setText(String.valueOf(todayBookingCount));
        }

        private void showStockDetail(StockBo AddItemModel) throws SQLException, ClassNotFoundException {
        int todaystockcount = stockBo.dashboardStockCount();
        lblstockcount.setText(String.valueOf(todaystockcount));
        }




    public void pieChart1() throws ClassNotFoundException {
        PieChart pieChart = new PieChart();

        try {
            ObservableList<PieChart.Data> pieChartData = dashboardBo.getFundDataForPieChart();
            pieChart.setData(pieChartData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        piechartPane.getChildren().add(pieChart);
    }
    public void pieChart2() throws ClassNotFoundException {
        PieChart pieChart = new PieChart();

        try {
            ObservableList<PieChart.Data> pieChartData = dashboardBo.getFundData2ForPieChart();
            pieChart.setData(pieChartData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        piechart2Pane.getChildren().add(pieChart);
    }
}
