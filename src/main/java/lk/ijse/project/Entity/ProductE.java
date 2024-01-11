package lk.ijse.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductE {

    private  String product_id;
    private String category;
    private double unit_price;
    private double rest_price;
    private String description;
    private int qty;
}
