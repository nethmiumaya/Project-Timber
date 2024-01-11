package lk.ijse.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddCustomerOrderClassE {
    private String cus_order_id;
    private String cid;
    private double total_price;
    private double unit_price;
    private int qty;
    private Date date;
    private Time time;

}
