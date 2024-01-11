package lk.ijse.project.Dao.Custom.Impl;

import lk.ijse.project.Dao.Custom.CustomerOrderDetailDao;
import lk.ijse.project.db.DbConnection;
import lk.ijse.project.Dto.Product;
import lk.ijse.project.Dto.Tm.CartTm;
import lk.ijse.project.utill.SQLUtile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderDetailDaoImp implements CustomerOrderDetailDao {
    @Override
    public  boolean saveProduct(Product dto) throws SQLException, ClassNotFoundException {
        return   SQLUtile.execute("insert into product values(?,?,?,?,?,?)",dto.getProduct_id(),dto.getCategory(),dto.getUnit_price(),dto.getRest_price(),dto.getDescription(),dto.getQty());
    }
@Override
    public  boolean deleteProduct(String productId) throws SQLException, ClassNotFoundException {
        return   SQLUtile.execute("DELETE FROM product WHERE product_id = ?",productId);

    }
@Override
    public  List<Product> loadAllProductID() throws SQLException, ClassNotFoundException {
      //  Connection connection = DbConnection.getInstance().getConnection();
      ResultSet resultSet = SQLUtile.execute("SELECT * FROM product");

        List<Product> dtoList = new ArrayList<>();
        while (resultSet.next()) {
            var dto = new Product(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5),
                    resultSet.getInt(6)

            );

            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public Product searchProduct(String pid) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM product WHERE product_id = ?",pid);

        Product dto = null;

        if(resultSet.next()) {
            String product_id =resultSet.getString(1);
            String category=  resultSet.getString(2);
            double unit_price =resultSet.getDouble(3);
            double rest_price= resultSet.getDouble(4);
            String description= resultSet.getString(5);
            int qty= resultSet.getInt(6);

            dto=new Product(product_id,category,unit_price,rest_price,description,qty);

        }
        return dto;
    }
@Override
    public  String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT cus_order_id FROM customer_order ORDER BY cus_order_id DESC LIMIT 1");

        String currentOrderId = null;
        if (resultSet.next()) {
            currentOrderId = resultSet.getString(1);

            return splitOrderId(currentOrderId);
        }
        return splitOrderId(null);
    }
@Override
    public String splitOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("O");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            String formattedId = String.format("%03d",id);
            return "O" + formattedId;
        }
        return "O001";
    }
@Override
    public  String generateNextProductid() throws SQLException, ClassNotFoundException {
       ResultSet resultSet =  SQLUtile.execute("SELECT product_id FROM product ORDER BY product_id DESC LIMIT 1");

        String currentproductId = null;
        if (resultSet.next()) {
            currentproductId = resultSet.getString(1);

            return splitproductId(currentproductId);
        }
        return splitproductId(null);
    }
    @Override
    public String splitproductId(String currentcustomerId) {
        if ( currentcustomerId != null) {
            String[] split =  currentcustomerId.split("P");
            int id = Integer.parseInt(split[1]);    //008
            id++;  //9
            return "P00" + id;
        }
        return "P001";
    }



@Override
    public boolean updateProduct(Product dto) throws SQLException, ClassNotFoundException {
        return SQLUtile.execute("UPDATE product SET category = ?, unit_price = ?, rest_price = ?, description = ?, qty_on_hand=? WHERE product_id = ?",dto.getCategory(),dto.getUnit_price(),dto.getRest_price(),dto.getDescription(),dto.getQty(),dto.getProduct_id());
    }
@Override
    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtile.execute("SELECT * FROM product");

        List<Product> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String product_id = resultSet.getString(1);
            String category = resultSet.getString(2);
            double unit_price = resultSet.getDouble(3);
            double rest_price = resultSet.getDouble(4);
            String description = resultSet.getString(5);
            int qty_on_hand = resultSet.getInt(6);

            var dto = new Product(product_id,category,unit_price,rest_price,description,qty_on_hand);
            dtoList.add(dto);
        }
        return dtoList;
    }
@Override
    public boolean updateProduct(List<CartTm> tmList) throws SQLException {
        for (CartTm tm:tmList){
            if (!updateQty(tm)){
                return false;
            }
        }
        return true;
    }
@Override
public boolean updateQty(CartTm tm) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "update product set qty_on_hand = qty_on_hand - ? where product_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1,tm.getQty());
        pstm.setString(2,tm.getProduct_id());
        return pstm.executeUpdate()> 0 ;
    }

}
