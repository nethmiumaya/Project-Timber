package lk.ijse.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class SupplierE {
   private  String o_id;
    private double total_price;
    private double unit_price;
    private int qty;
    private Date date;
}
