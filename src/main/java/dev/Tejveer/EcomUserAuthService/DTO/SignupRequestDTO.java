package dev.Tejveer.EcomUserAuthService.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SignupRequestDTO {
    private String username;
    private String password;
    private String emailId;

    private UUID role;
}
