package com.kamal.schoolerp.schoolerp.repositories;

import com.kamal.schoolerp.schoolerp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleName(String roleName);
}
