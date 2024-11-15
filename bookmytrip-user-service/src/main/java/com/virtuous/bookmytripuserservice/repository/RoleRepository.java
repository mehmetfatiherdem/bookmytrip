package com.virtuous.bookmytripuserservice.repository;

import com.virtuous.bookmytripuserservice.model.Role;
import com.virtuous.bookmytripuserservice.model.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findRoleByName(RoleName roleName);
}
