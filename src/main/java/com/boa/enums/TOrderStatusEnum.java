package com.boa.enums;

import com.mysql.jdbc.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DuenBoa
 * @date 2017/10/28
 */
public enum TOrderStatusEnum {
    browe("browe", "浏览"),
    visit("visit", "入店"),
    taked("taked", "已领取奖品"),
    other("other", "其他状态");

    private volatile static Map<String, TOrderStatusEnum> map = new HashMap(8);
    private String name;
    private String desc;

    TOrderStatusEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static TOrderStatusEnum nameOf(String name) {
        if (StringUtils.isEmptyOrWhitespaceOnly(name)) {
            return null;
        }
        if (map.isEmpty() || map.size() != TOrderStatusEnum.values().length) {
            synchronized (map) {
                if (map.isEmpty() || map.size() != TOrderStatusEnum.values().length) {
                    for (TOrderStatusEnum e : TOrderStatusEnum.values()) {
                        map.put(e.getName(), e);
                    }
                }
            }
        }
        return map.get(name);
    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
