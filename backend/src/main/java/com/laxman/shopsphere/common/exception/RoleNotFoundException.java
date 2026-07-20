package com.laxman.shopsphere.common.exception;

import com.laxman.shopsphere.common.enums.RoleType;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(RoleType roleType) {
        super(String.format("Role with type %s not found.", roleType));
    }
}