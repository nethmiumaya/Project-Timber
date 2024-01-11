package lk.ijse.project.Dao.Custom;
import lk.ijse.project.Dao.SuperDao;
import lk.ijse.project.Dto.Product;
import lk.ijse.project.Dto.Tm.CartTm;
import java.sql.SQLException;
import java.util.List;

public interface CustomerOrderDetailDao extends SuperDao {
     boolean saveProduct(Product dto) throws SQLException, ClassNotFoundException;

     boolean deleteProduct(String productId) throws SQLException, ClassNotFoundException;
     List<Product> loadAllProductID() throws SQLException, ClassNotFoundException;

     Product searchProduct(String pid) throws SQLException, ClassNotFoundException;

     String generateNextOrderId() throws SQLException, ClassNotFoundException;

     String splitOrderId(String currentOrderId);

     String generateNextProductid() throws SQLException, ClassNotFoundException;
     String splitproductId(String currentcustomerId);




     boolean updateProduct(Product dto) throws SQLException, ClassNotFoundException;

    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException;



     boolean updateProduct(List<CartTm> tmList) throws SQLException;

     boolean updateQty(CartTm tm) throws SQLException;

}
