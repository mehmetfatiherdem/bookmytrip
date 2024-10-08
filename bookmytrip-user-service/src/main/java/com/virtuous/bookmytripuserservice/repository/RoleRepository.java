package com.virtuous.bookmytripuserservice.repository;

import com.virtuous.bookmytripuserservice.model.Role;
import com.virtuous.bookmytripuserservice.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(RoleType roleType);
}
