package lk.ijse.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddCustomerOrderClass {
    private String cus_order_id;
    private String cid;
    private double total_price;
    private double unit_price;
    private int qty;
    private Date date;
    private Time time;

}
