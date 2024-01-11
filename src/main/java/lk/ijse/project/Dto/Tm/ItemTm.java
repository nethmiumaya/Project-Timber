package lk.ijse.project.Dto.Tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemTm {
    
        private String i_code;
        private String i_name;
        private int qtyofHand;
        private double unit_price;
    }


