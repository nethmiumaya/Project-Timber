package lk.ijse.project.Dao;

import lk.ijse.project.Dao.Custom.CustomerOrderDao;
import lk.ijse.project.Dao.Custom.Impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory ;
    private DaoFactory(){

    }
    public static DaoFactory getDADFactory (){
        return (daoFactory==null) ? daoFactory=new DaoFactory():daoFactory;
    }
    public enum DADType{
        AddCustomer,AddDeliver,Booking,Customer,CustomerOrder,CustomerOrderDetail,
        Dashboard,Deliver,EmpAttendance,Employee,EmployeeManage,Login,PlaceOrder,
        Stock,StockDetail,SupplierOrder
    }
    public SuperDao getDao(DADType dadType) {
        switch (dadType) {
            case AddCustomer: return new AddcustomerDaoImp();
            case  AddDeliver:return new AddDeliverDaoImp();
            case Booking:return new BookingDaoImp();
            case Customer:return new CustomerDaoImpl();
            case CustomerOrder:return new CustomerOrderImp();
            case CustomerOrderDetail:return new CustomerOrderDetailDaoImp();
            case Dashboard:return new DashboardDaoImpl();
            case Deliver:return new DeliverImp();
            case EmpAttendance:return new EmpAttendaceDaoImp();
            case Employee:return new EmployeeDaoImp();
            case EmployeeManage:return new EmployeeManageDaoImp();
            case Login:return new LoginDaoImpl();
            case PlaceOrder:return new placeOrderDaoImp();
            case Stock:return new StockDaoImp();
            case StockDetail:return new StockDetailDaoImp();
            case SupplierOrder:return new SupplierOrderDaoImp();
            default:return null;
        }
    }
}
