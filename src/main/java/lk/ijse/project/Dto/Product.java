package lk.ijse.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private  String product_id;
    private String category;
    private double unit_price;
    private double rest_price;
    private String description;
    private int qty;
}
