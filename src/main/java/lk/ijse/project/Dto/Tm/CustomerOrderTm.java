package lk.ijse.project.Dto.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerOrderTm {
    private String cus_order_id;
    private String cid;
    private double total_price;
    private double unit_price;
    private int qty;
}
