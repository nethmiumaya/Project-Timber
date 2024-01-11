package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.BookingDao;
import lk.ijse.project.Dto.AddBooking;
import lk.ijse.project.utill.SQLUtile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImp implements BookingDao {
    @Override
    public boolean saveOrder(final AddBooking dto) throws SQLException, ClassNotFoundException {

        return SQLUtile.execute("INSERT INTO booking_detail VALUES(?,?,?,?,?,?)",dto.getBookingid(),dto.getNic(),dto.getIcode(),dto.getInitialcost(),dto.getQty(),dto.getDate());

    }
@Override
    public boolean updateBooking(final AddBooking dto) throws SQLException, ClassNotFoundException {
      return SQLUtile.execute("UPDATE booking_detail SET nic = ?, i_code = ?, initial_cost = ?,qty = ?, date=? WHERE booking_id = ?",dto.getNic(),dto.getIcode(),dto.getInitialcost(),dto.getQty(),dto.getDate(),dto.getBookingid());
    }

@Override

      public String splitbookingId(String currentbookingId) {
        if ( currentbookingId != null) {
            String[] split =  currentbookingId.split("B");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            return "B00" + id;
        }
        return "B001";
    }
@Override
    public String generateNextbOOKINGId() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtile.execute("SELECT booking_id FROM booking_detail ORDER BY booking_id DESC LIMIT 1");

        String currentBookingId = null;
        if (resultSet.next()) {
            currentBookingId = resultSet.getString(1);

            return splitbookingId(currentBookingId);
        }
        return splitBookingId(null);
    }
@Override
      public String splitBookingId(String currentBookingId) {
        if (currentBookingId != null) {
            String[] split = currentBookingId.split("B");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            String formattedId = String.format("%B3d",id);
            return "B" + formattedId;
        }
        return "B001";
    }
    @Override
    public AddBooking searchbooking_detail(String nc) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM booking_detail WHERE nic = ?");

        AddBooking dto = null;

        if(resultSet.next()) {


            String bookingid= resultSet.getString(1);
            String nic = resultSet.getString(2);
            String i_code = resultSet.getString(3);
            double initialcost = Double.parseDouble(resultSet.getString(4));
            String qty = resultSet.getString(5);

            String date  = resultSet.getString(6);

            dto = new AddBooking(bookingid,nic,i_code,initialcost,qty,date);
        }

        return dto;
    }
@Override
    public List<AddBooking> getAllbooking_detail() throws SQLException, ClassNotFoundException {

    ResultSet resultSet = SQLUtile.execute("SELECT * FROM booking_detail");

        List<AddBooking> dtoList = new ArrayList<>();

        while (resultSet.next()) {

            String bookingid= resultSet.getString(1);
            String nic = resultSet.getString(2);
            String i_code = resultSet.getString(3);
            double initialcost = resultSet.getDouble(4);
            String qty = resultSet.getString(5);

            String date  = resultSet.getString(6);


            var dto = new AddBooking(bookingid,nic,i_code,initialcost,qty,date);
            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public boolean deleteBooking(String bid) throws SQLException, ClassNotFoundException {
        return SQLUtile.execute("DELETE FROM booking_detail WHERE booking_id = ?",bid);
    }
@Override
    public List<AddBooking> loadAllCustomers() throws SQLException, ClassNotFoundException {
       // Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM booking_detail");

        List<AddBooking> bookList = new ArrayList<>();

        while (resultSet.next()) {
            var dto=new AddBooking(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString( 5),
                    resultSet.getString( 6)


            );
            bookList.add(dto);
        }
        return bookList;
    }
@Override
    public List<AddBooking> getAllBooking() throws SQLException, ClassNotFoundException {
        //Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM booking_detail");

        List<AddBooking> dtoList = new ArrayList<>();

        while (resultSet.next()) {


            String bookingid = resultSet.getString(1);
            String nic = resultSet.getString(2);
            String icode = resultSet.getString(3);
            double initialcost = resultSet.getDouble(4);
            String qty = resultSet.getString(5);
            String date = resultSet.getString(6);


            var dto = new AddBooking(bookingid,nic,icode,initialcost,qty,date);

            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public  int dashboardtodaybooking() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtile.execute("SELECT COUNT(booking_id) FROM booking_detail WHERE date = DATE(NOW())");

        if (set.next()){
            int count = set.getInt(1);
            return count;
        }
        return 0;
    }

}
