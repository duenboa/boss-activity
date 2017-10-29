package com.boa.persons;

/**
 * @author DuenBoa
 * @date 2017/10/27
 */
public class User5 {
    private Long xId;
    private String xName;

    public Long getxId() {
        return xId;
    }

    public void setxId(Long xId) {
        this.xId = xId;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof User5)) {
            return false;
        }

        User5 p = ((User5) o);
        return ((xId == null && p.getxId() == null) || xId.longValue() == p.getxId().longValue())
                && (xName == null && p.getxName() == null) || String.valueOf(xName).equals(String.valueOf(p.getxName()));
    }
}
