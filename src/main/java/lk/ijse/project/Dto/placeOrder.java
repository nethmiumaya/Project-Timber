package lk.ijse.project.Dto;

import lk.ijse.project.Dto.Tm.CartTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class placeOrder {
    private String order_id;
    private String cus_order_id;
    private LocalDate date;
    private List<CartTm> tmList = new ArrayList<>();
}
