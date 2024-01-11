package lk.ijse.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class Supplier {
   private  String o_id;
    private double total_price;
    private double unit_price;
    private int qty;
    private String date;
}
