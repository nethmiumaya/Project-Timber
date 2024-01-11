package lk.ijse.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeeAttendance extends EmployeeMmanage {

    private String name;
    private String date;
    private  String jobrole;

}
