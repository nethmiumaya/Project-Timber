package lk.ijse.project.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item extends AddCustomer {
    private String i_code;
    private String i_name;
    private int qtyofHand;
    private double unit_price;
}
