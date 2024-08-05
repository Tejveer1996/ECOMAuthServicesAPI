package dev.Tejveer.EcomUserAuthService.DTO;

import dev.Tejveer.EcomUserAuthService.Entity.Role;
import dev.Tejveer.EcomUserAuthService.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDTO {

    private String username;
    private String emailId;
    private String token;
    private List<RoleResponseDTO> roles;

    public static UserResponseDTO from(User user){
        if(user == null){
            return null;
        }

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.emailId = user.getEmailId();
        responseDTO.username = user.getUsername();
        responseDTO.token = user.getToken();
        responseDTO.roles = new ArrayList<>();

        for (Role role : user.getRoles()){
            RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
            roleResponseDTO.setRole(role.getRole());
            roleResponseDTO.setDescription(role.getDescription());

            responseDTO.roles.add(roleResponseDTO);
        }

        return responseDTO;
    }
}
