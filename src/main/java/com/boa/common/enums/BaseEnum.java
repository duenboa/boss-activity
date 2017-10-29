package com.boa.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright (C), 2012-2020 DuenBoa 版权所有
 * @Author: Created by DengBenbo 20160289
 * @Date: 2017/5/23
 * @Version: 1.0.0
 * @Description:
 * @History: 变更记录
 * <author>           <time>             <version>        <desc>
 * Duenboa            2017/5/23            00000001         创建文件
 */
public enum BaseEnum {
    ENUM1("描述1", "1"),
    ENUM2("描述2", "2");

    private        String                desc;
    private        String                val;
    private static Map<String, BaseEnum> descEnumMap;
    private static Map<String, BaseEnum> valEnumMap;

    BaseEnum(String desc, String val) {
        this.desc = desc;
        this.val = val;
    }

    public String val() {
        return val;
    }

    public String desc() {
        return desc;
    }


    public static BaseEnum descOf(String desc) {
        if (desc == null) {
            return null;
        }
        if (descEnumMap == null) {
            descEnumMap = new HashMap<>(BaseEnum.values().length);
            synchronized (descEnumMap) {
                if (descEnumMap.isEmpty()) {
                    for (BaseEnum e : BaseEnum.values()) {
                        descEnumMap.put(e.desc, e);
                    }
                }
            }
        }

        return descEnumMap.get(desc);
    }


    public static BaseEnum valOf(String val) {
        if (val == null) {
            return null;
        }
        if (valEnumMap == null) {
            valEnumMap = new HashMap<>(BaseEnum.values().length);
            synchronized (valEnumMap) {
                if (valEnumMap.isEmpty()) {
                    for (BaseEnum e : BaseEnum.values()) {
                        valEnumMap.put(e.val, e);
                    }
                }
            }
        }
        return valEnumMap.get(val);
    }


    public static String getValByDesc(String desc){
        BaseEnum baseEnum = descOf(desc);
        if (baseEnum != null) {
            return baseEnum.val;
        }
        return null;
    }
}
