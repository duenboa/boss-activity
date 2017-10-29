package com.boa.persons;

/**
 * @author DuenBoa
 * @date 2017/10/27
 */
public class User3 {

    private Long sId;
    private String sName;
    private User5 user5;

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public User5 getUser5() {
        return user5;
    }

    public void setUser5(User5 user5) {
        this.user5 = user5;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof User3)) {
            return false;
        }

        User3 p = ((User3) o);

        return ((sId == null && p.getsId() == null) || sId.longValue() == p.getsId().longValue())
                && (sName == null && p.getsName() == null) || String.valueOf(sName).equals(String.valueOf(p.getsName()))
                && ((user5 == null && p.getUser5() == null) || user5 != null ? user5.equals(p.getUser5()) : p.getUser5().equals(user5));
    }
}
