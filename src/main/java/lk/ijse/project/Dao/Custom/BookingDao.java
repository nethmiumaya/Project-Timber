package lk.ijse.project.Dao.Custom;

import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.AddBooking;

import java.sql.SQLException;
import java.util.List;

public interface BookingDao extends SuperDao {
    boolean saveOrder(final AddBooking dto) throws SQLException, ClassNotFoundException;


     boolean updateBooking(final AddBooking dto) throws SQLException, ClassNotFoundException;


     String splitbookingId(String  currentbookingId);


     String generateNextbOOKINGId() throws SQLException, ClassNotFoundException;

     String splitBookingId(String currentBookingId);
     AddBooking searchbooking_detail(String nc) throws SQLException, ClassNotFoundException;
     List<AddBooking> getAllbooking_detail() throws SQLException, ClassNotFoundException;

     boolean deleteBooking(String bid) throws SQLException, ClassNotFoundException;


     List<AddBooking> loadAllCustomers() throws SQLException, ClassNotFoundException;

     List<AddBooking> getAllBooking() throws SQLException, ClassNotFoundException;

     int dashboardtodaybooking() throws SQLException, ClassNotFoundException;

    }


