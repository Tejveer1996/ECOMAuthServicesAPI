package dev.Tejveer.EcomUserAuthService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_User")
public class User extends BaseModel{

    private String username;
    private String password;
    private String emailId;
    private String token;

    @OneToMany
    private List<Role> roles;
}
