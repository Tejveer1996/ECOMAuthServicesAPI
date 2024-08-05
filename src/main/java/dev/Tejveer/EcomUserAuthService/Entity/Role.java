package dev.Tejveer.EcomUserAuthService.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ECOM_Roles")
public class Role extends BaseModel{

    private String role;
    private String description;
}
