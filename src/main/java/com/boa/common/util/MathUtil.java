package com.boa.common.util;

/**
 * @author DuenBoa
 * @date 2017/10/24
 */
public class MathUtil {

    /**
     * 比如我有个需求 一位小数的数字 比如 90.2  小数小于0.5 则进位成90.5  小数如果大于0.5 则进位1  比如90.7 就是91.0  也就是小数要么是0要么是5
     */
    public static float mod5(float n) {
        int r = Math.round(n);
        n = r >= n ? r : (float) ((int) n + 0.5);
        return n;
    }

    public static void main(String[] args) {
        //91.0
        System.out.println(mod5(91.0f));
        //90.5
        System.out.println(mod5(90.2f));
        //91.0
        System.out.println(mod5(90.5f));
        //91.0
        System.out.println(mod5(90.7f));
    }


}
