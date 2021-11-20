package org.nguliu.myraft.core.role;

import org.nguliu.myraft.core.enums.RoleTypeEnum;

public abstract class AbstractNodeRole {

    private final RoleTypeEnum roleType;

    protected final Integer term;

    public AbstractNodeRole(RoleTypeEnum roleType, Integer term) {
        this.roleType = roleType;
        this.term = term;
    }

    public abstract void cancelTimeoutOrTask();

    public RoleTypeEnum getRoleType() {
        return roleType;
    }

    public Integer getTerm() {
        return term;
    }
}
