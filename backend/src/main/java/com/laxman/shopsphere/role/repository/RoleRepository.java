package com.laxman.shopsphere.role.repository;

import com.laxman.shopsphere.common.enums.RoleType;
import com.laxman.shopsphere.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);
}