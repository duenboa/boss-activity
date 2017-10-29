package com.boa.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Copyright (C), 2012-2020 上海好屋网信息技术有限公司
 * @Author: DengBenbo 20160289
 * @Date: 2017/4/12
 * @Version: 1.0.0
 * @Description: 正则匹配常用数据类型
 * @History: 变更记录
 * <author>           <time>             <version>        <desc>
 * Duenboa            2017/4/12            00000001         创建文件
 */
public class RegexUtil {


    /**
     * 正则校验枚举
     */
    public static enum TYPE {
        电话(0),
        邮箱(1),
        用户名(2),
        密码(3),
        中文(4),
        非零正整数(5),
        数字和字母(6),
        单个数字(7),
        身份证(8),
        人名(9),
        时间(10),
        域名(11),
        URL(12),
        座机(13),
        强密码(14),
        日期(15);

        private int code;

        public int code() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        TYPE(int code) {
            this.code = code;
        }
    }


    /**
     * 匹配输入数据类型
     * <b>
     * 不会自动去除空格,注意参数的首位空格
     * </b>
     *
     * @param param
     * @param TYPE  {@link com.boa.stu.test.util.RegexUtil.TYPE}
     * @return
     */
    public static boolean isMatch(String param, TYPE type) {
        String pat = "";
        switch (type.code()) {
            case 0: // /手机号
                pat = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
                break;
            case 1:// /邮箱
                pat = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
                break;
            case 2: // /用户名
                pat = "^[0-9a-zA-Z_]{4,12}$";
                break;
            case 3: // /密码
                pat = "^[\\s\\S,.<>!@#]{6,18}$";
                break;
            case 4: // /中文
                pat = "^[0-9a-z\u4e00-\u9fa5|admin]{2,15}$";
                break;
            case 5: // /非零正整数
                pat = "^\\+?[1-9][0-9]*$";
                break;
            case 6: // /数字和字母
                pat = "^[A-Za-z0-9]+$";
                break;
            case 7: // /0-9的数字
                pat = "^[0-9]";
                break;
            case 8: // /身份证
                pat = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
                break;
            case 9: // /名字 英文或中文名 可以包含空格
                pat = "^([A-Za-z ]|[\u4E00-\u9FA5])+$";
                break;
            case 10: // /时间 时：分：秒
                pat = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
                break;
            case 11: // 域名
                pat = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+.?";
                break;
            case 12: // URL
                pat = "[a-zA-z]+://[^\\s]*";
                break;
            case 13: // 座机
                pat = "^\\d{3}-\\d{8}|\\d{4}-\\d{7}$";
                break;
            case 14: //  强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在6-20之间)
                pat = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
                break;
            case 15: // 日期 yyyy-MM-dd
                pat = "^\\d{4}-\\d{1,2}-\\d{1,2}";
                break;
        }
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(param);
        return m.matches();
    }

    public static void main(String[] args) {
//        String userName = "user_boa123";  boolean match = RegexUtil.isMatch(userName, TYPE.用户名);     System.out.println(match); //true
//        String personName = "duen boa ";  boolean match = RegexUtil.isMatch(personName, TYPE.人名);     System.out.println(match); //true
        String email = "duen@163.cn";
        boolean match = RegexUtil.isMatch(email, TYPE.邮箱);
        System.out.println(match); //true
    }
}
