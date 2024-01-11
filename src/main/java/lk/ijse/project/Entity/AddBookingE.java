package lk.ijse.project.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddBookingE {
    private String bookingid;
    private  String nic;
    private  String icode;
    private double initialcost;
    private  String qty;
    private  String date;

}
