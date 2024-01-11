package lk.ijse.project.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeMmanage {
    private String employee_id;
    private String first_name;
    private String last_name;
    private String address;
    private int tele_no;
    private String join_date;
    private String nic;

}
