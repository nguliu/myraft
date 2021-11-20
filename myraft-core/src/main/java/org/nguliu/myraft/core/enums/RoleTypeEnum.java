package org.nguliu.myraft.core.enums;

import java.util.Arrays;

public enum RoleTypeEnum {

    LEADER("LEADER", "集群Leader"),

    CANDIDATE("CANDIDATE", "Leader候选者"),

    FOLLOWER("FOLLOWER", "Leader跟随者")

    ;

    private final String code;

    private final String desc;

    RoleTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static RoleTypeEnum getByCode(String code) {
        return Arrays.stream(RoleTypeEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }


    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
