package dev.Tejveer.EcomUserAuthService.Service;

import dev.Tejveer.EcomUserAuthService.DTO.RoleRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);

    List<RoleResponseDTO> getAllRoles();
}
