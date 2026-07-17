package com.laxman.shopsphere.role.repository;

import com.laxman.shopsphere.common.enums.RoleType;
import com.laxman.shopsphere.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);
}