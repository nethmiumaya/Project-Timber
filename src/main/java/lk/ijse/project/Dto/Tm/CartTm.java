package lk.ijse.project.Dto.Tm;

import javafx.scene.control.Button;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CartTm {
    private String product_id;
    private String description;
    private int Qty;
    private double unit_price;
    private double total_price;
    private Button btn;
}
