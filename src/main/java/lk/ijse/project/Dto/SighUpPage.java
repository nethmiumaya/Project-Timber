package lk.ijse.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SighUpPage {
    private  String fullname;
    private String username;
    private  String email;
    private String password;
}
