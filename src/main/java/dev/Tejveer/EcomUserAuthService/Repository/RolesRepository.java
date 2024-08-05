package dev.Tejveer.EcomUserAuthService.Repository;

import dev.Tejveer.EcomUserAuthService.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<Role, UUID> {
}
