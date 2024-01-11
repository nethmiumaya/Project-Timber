package lk.ijse.project.Bo.Custom.BoImp;

import lk.ijse.project.Bo.Custom.BookingBo;
import lk.ijse.project.Dao.Custom.BookingDao;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dto.AddBooking;

import java.sql.SQLException;
import java.util.List;

public class BookingBoImp implements BookingBo {
    BookingDao bookingDao = (BookingDao) DaoFactory.getDADFactory().getDao(DaoFactory.DADType.Booking);
    @Override
    public boolean saveOrder(AddBooking dto) throws SQLException, ClassNotFoundException {
        return bookingDao.saveOrder(dto);
    }

    @Override
    public boolean updateBooking(AddBooking dto) throws SQLException, ClassNotFoundException {
        return bookingDao.updateBooking(dto);
    }

    @Override
    public String splitbookingId(String currentbookingId) {
        return bookingDao.splitbookingId(currentbookingId);
    }

    @Override
    public String generateNextbOOKINGId() throws SQLException, ClassNotFoundException {
        return bookingDao.generateNextbOOKINGId();
    }

    @Override
    public String splitBookingId(String currentBookingId) {
        return bookingDao.splitBookingId(currentBookingId);
    }

    @Override
    public AddBooking searchbooking_detail(String nc) throws SQLException, ClassNotFoundException {
        return bookingDao.searchbooking_detail(nc);
    }

    @Override
    public List<AddBooking> getAllbooking_detail() throws SQLException, ClassNotFoundException {
        return bookingDao.getAllbooking_detail();
    }

    @Override
    public boolean deleteBooking(String bid) throws SQLException, ClassNotFoundException {
        return bookingDao.deleteBooking(bid);
    }

    @Override
    public List<AddBooking> loadAllCustomers() throws SQLException, ClassNotFoundException {
        return bookingDao.loadAllCustomers();
    }

    @Override
    public List<AddBooking> getAllBooking() throws SQLException, ClassNotFoundException {
        return bookingDao.getAllBooking();
    }

    @Override
    public int dashboardtodaybooking() throws SQLException, ClassNotFoundException {
        return bookingDao.dashboardtodaybooking();
    }
}
