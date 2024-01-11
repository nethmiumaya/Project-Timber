package lk.ijse.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeliverE {

    private  String deliver_id;
    private String address;
    private int tele_no;
    private String dueDate;
    private double payment;
}
