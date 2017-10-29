package com.boa.persons;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuenBoa
 * @date 2017/10/27
 */
public class UserTest {
    public static void main(String[] args) {

        User5 u5 = new User5() {{
            setxId(1L);
            setxName("1");
        }};

        User4 u4 = new User4() {{
            setzId(1L);
            setzName("1");
        }};

        User3 u3 = new User3() {{
            setsId(1L);
            setsName("1");
            setUser5(u5);
        }};

        List<User3> list1 = new ArrayList<>();
        List<User3> list2 = new ArrayList<>();
        list1.add(u3);
        list2.add(u3);
        list2.add(u3);

        User u1 = new User(){{
            setId(1L);
            setName("1");
            setSex(1);
            setUser4(u4);
            setList(list1);
        }};

        User u2 = new User(){{
            setId(1L);
            setName("1");
            setSex(1);
            setUser4(u4);
            setList(list2);
        }};

        System.out.println(u1.equals(u2));
    }
}
