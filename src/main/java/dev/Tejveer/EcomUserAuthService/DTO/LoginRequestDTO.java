package dev.Tejveer.EcomUserAuthService.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDTO {

    private String emailId;
    private String password;

}
