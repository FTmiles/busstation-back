package online.anyksciaibus.restback.repositories;


import online.anyksciaibus.restback.models.ERole;
import online.anyksciaibus.restback.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}