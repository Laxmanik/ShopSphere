package com.laxman.shopsphere.role.config;

import com.laxman.shopsphere.common.enums.RoleType;
import com.laxman.shopsphere.role.entity.Role;
import com.laxman.shopsphere.role.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleDataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleDataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void run(String... args) {
        //Check if roles are already present in the database
        if(roleRepository.findByRoleType(RoleType.ADMIN).isEmpty()) {
            roleRepository.save(
                    new Role(RoleType.ADMIN,
                            "System Administrator")
            );
        }

        if(roleRepository.findByRoleType(RoleType.CUSTOMER).isEmpty()) {
            roleRepository.save(
                    new Role(RoleType.CUSTOMER,
                            "Application Customer")
            );
        }

        System.out.println("Default Roles Initialized");
    }
}