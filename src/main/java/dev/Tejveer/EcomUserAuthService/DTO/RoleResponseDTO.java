package dev.Tejveer.EcomUserAuthService.DTO;


import dev.Tejveer.EcomUserAuthService.Entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO {

    private String role;
    private String description;
    private UUID roleId;

    public static RoleResponseDTO from(Role role){
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.role = role.getRole();
        responseDTO.description = role.getDescription();
        responseDTO.roleId = role.getId();

        return responseDTO;
    }
}
