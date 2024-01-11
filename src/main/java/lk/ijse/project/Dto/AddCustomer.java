package lk.ijse.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddCustomer {
    private String cid;
    private String first_name;
    private String last_name;
    private String nic;
    private String address;
    private String tele_no;
    private String email;

}
