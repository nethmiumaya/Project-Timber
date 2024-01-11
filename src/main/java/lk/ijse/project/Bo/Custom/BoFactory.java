package lk.ijse.project.Bo.Custom;

import lk.ijse.project.Bo.Custom.BoImp.*;
import lk.ijse.project.Dao.Custom.Impl.*;
import lk.ijse.project.Dao.DaoFactory;
import lk.ijse.project.Dao.SuperDao;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){

    }

    public static BoFactory getBoFactory (){
        return (boFactory==null) ? boFactory=new BoFactory():boFactory;
    }
    public enum BoType{
        AddCustomer,AddDeliver,Booking,Customer,CustomerOrder,CustomerOrderDetail,
        Dashboard,Deliver,EmpAttendance,Employee,EmployeeManage,Login,PlaceOrder,
        Stock,StockDetail,SupplierOrder
    }
    public SuperBo getBo(BoFactory.BoType dadType) {
        switch (dadType) {
            case AddCustomer: return new AddCustomeBoImp();
            case  AddDeliver:return new AddDeliverBoImp();
            case Booking:return new BookingBoImp();
            case Customer:return new CustomerBoImp();
            case Dashboard:return new DashboardBoImp();
            case Deliver:return new DeliverBoImp();
            case EmpAttendance:return new EmpAttendanceBoImp();
            case Employee:return new EmployeeBoImp();
            case EmployeeManage:return new EmployeeManageBoImp();
            case Login:return new LoginBoImp();
            case PlaceOrder:return new PlaceOrderBoImp();
            case Stock:return new StockBoImp();
            case StockDetail:return new StockDetailBoImp();
            case SupplierOrder:return new SupplierOrderBoImp();
            default:return null;
        }
    }
}
