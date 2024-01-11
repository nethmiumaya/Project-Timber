package lk.ijse.project.Entity;

import lk.ijse.project.Dto.EmployeeMmanage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeeAttendanceE extends EmployeeMmanage {

    private String name;
    private String date;
    private  String jobrole;

}
