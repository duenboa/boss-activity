package com.boa.persons;

/**
 * @author DuenBoa
 * @date 2017/10/27
 */
public class User4 {
    private Long zId;
    private String zName;

    public Long getzId() {
        return zId;
    }

    public void setzId(Long zId) {
        this.zId = zId;
    }

    public String getzName() {
        return zName;
    }

    public void setzName(String zName) {
        this.zName = zName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof User4)) {
            return false;
        }

        User4 p = ((User4) o);
        return ((zId == null && p.getzId() == null) || zId.longValue() == p.getzId().longValue())
                && (zName == null && p.getzName() == null) || String.valueOf(zName).equals(String.valueOf(p.getzName()));

    }
}
