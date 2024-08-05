package dev.Tejveer.EcomUserAuthService.Service;

import dev.Tejveer.EcomUserAuthService.DTO.RoleRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.RoleResponseDTO;
import dev.Tejveer.EcomUserAuthService.Entity.Role;
import dev.Tejveer.EcomUserAuthService.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRole(roleRequestDTO.getRole());
        role.setDescription(roleRequestDTO.getDescription());

        return RoleResponseDTO.from(rolesRepository.save(role));
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        List<RoleResponseDTO> list = new ArrayList<>();
        for (Role role : rolesRepository.findAll()){
            list.add(RoleResponseDTO.from(role));

        }
        return list;
    }
}
