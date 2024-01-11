package lk.ijse.project.Entity;


import lk.ijse.project.Dto.AddCustomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemE extends AddCustomer {
    private String i_code;
    private String i_name;
    private int qtyofHand;
    private double unit_price;
}
