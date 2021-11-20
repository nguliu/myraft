package org.nguliu.myraft.common.utils.enums;

import java.util.Arrays;

public enum ErrorCodeEnum {

    SUCCESS("SUCCESS", "成功"),

    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),

    PARAM_INVALID_ERROR("PARAM_INVALID_ERROR", "参数非法错误"),

    UNKNOWN_ERROR("UNKNOWN_ERROR", "未知错误")

    ;

    private final String code;

    private final String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ErrorCodeEnum getByCode(String code) {
        return Arrays.stream(ErrorCodeEnum.values())
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
