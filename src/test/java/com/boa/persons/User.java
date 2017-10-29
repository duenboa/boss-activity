package com.boa.persons;

import java.util.List;

/**
 * @author DuenBoa
 * @date 2017/10/27
 */
public class User {
    private Long id;
    private String name;
    private int sex;
    private User4 user4;
    private List<User3> list;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public User4 getUser4() {
        return user4;
    }

    public void setUser4(User4 user4) {
        this.user4 = user4;
    }

    public List<User3> getList() {
        return list;
    }

    public void setList(List<User3> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User p = ((User) o);
        List<User3> pList = p.getList();
        if (pList != null && list != null && pList.size() != list.size()) {
            return false;
        }

        return ((id == null && p.getId() == null) || id.longValue() == p.getId().longValue())
                && (name == null && p.getName() == null) || String.valueOf(name).equals(String.valueOf(p.getName()))
                && ((user4 == null && p.getUser4() == null) || user4 != null ? user4.equals(p.getUser4()) : p.getUser4().equals(user4))
                && (list != null ? list.equals(pList) : pList.equals(list));
    }
}
