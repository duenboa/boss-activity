package com.boa.service;

import com.boa.entity.TAdmin;
import com.boa.mapper.TAdminMapper;
import com.boa.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author DuenBoa
 * @date 2017/10/29
 */
@Service
public class LoginService {
    @Autowired
    private TAdminMapper tAdminMapper;

    //xiaofu
    //qazxsw2
    public TAdmin login(String username, String password) {
        Assert.hasText(username, "用户名不能为空");
        Assert.hasText(password, "密码不能为空");

        TAdmin condition = new TAdmin();
        condition.setUsername(username);
        List<TAdmin> adminList = tAdminMapper.findByCondition(condition);
        if (!CollectionUtils.isEmpty(adminList)) {
            TAdmin admin = adminList.get(0);
            String md5Encode = MD5.MD5Encode(password);
            if (admin.getPassword().equals(md5Encode)) {
                return admin;
            }
            throw new IllegalArgumentException("用户名或密码不正确");

        } else {
            throw new IllegalArgumentException("用户不存在");
        }
    }


}
