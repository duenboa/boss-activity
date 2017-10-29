package com.boa.enums;

/**
 * @author DuenBoa
 * @date 2017/10/28
 */
public enum DeletedEnum {
    NO(0),
    YES(1);

    private int code;

    DeletedEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
