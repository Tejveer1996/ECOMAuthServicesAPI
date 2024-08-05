package dev.Tejveer.EcomUserAuthService.Controller;

import dev.Tejveer.EcomUserAuthService.DTO.RoleRequestDTO;
import dev.Tejveer.EcomUserAuthService.DTO.RoleResponseDTO;
import dev.Tejveer.EcomUserAuthService.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO){
        return ResponseEntity.ok(roleService.createRole(roleRequestDTO));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles(){
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}
