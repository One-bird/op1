package cn.zjf.online_xd.service.impl;

import cn.zjf.online_xd.mapper.UserMangerMapper;
import cn.zjf.online_xd.model.entity.Admin;
import cn.zjf.online_xd.model.entity.User;
import cn.zjf.online_xd.service.UserMangerService;
import cn.zjf.online_xd.utils.CommonUtils;
import cn.zjf.online_xd.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/23 21:00
 **/
@Service
public class UserMangerServiceImpl implements UserMangerService {
    @Autowired
    private UserMangerMapper userMangerMapper;

    @Override
    public int changeUserInfo(User user ) {
        return userMangerMapper.changeUserInfo(user);
    }

    @Override
    public String login(Admin admin) {
        admin.setPwd(CommonUtils.MD5(admin.getPwd()));
        Admin admin1 = userMangerMapper.adminLogin(admin);
        if (admin1 == null){
            return null;
        }else {
            String token = JWTUtils.adminJsonWebToken(admin1);
            System.out.println(token+"===============");
            return token;
        }
    }

    @Override
    public List<User> selectUser() {
        List<User> userList = userMangerMapper.selectUser();
        return userList;
    }
}
