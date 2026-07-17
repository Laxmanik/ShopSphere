package com.laxman.shopsphere.role.entity;

import com.laxman.shopsphere.common.entity.BaseEntity;
import com.laxman.shopsphere.common.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false, unique = true, length = 50)
    private RoleType roleType;

    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    public Role(){

    }

    public Role(RoleType roleType, String description) {
        this.roleType = roleType;
        this.description = description;
    }

    public RoleType getRoleType(){
        return roleType;
    }

    public String getDescription() {
        return description;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}