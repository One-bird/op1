package cn.zjf.online_xd.service;

import cn.zjf.online_xd.model.entity.Admin;
import cn.zjf.online_xd.model.entity.User;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/23 20:58
 **/
public interface UserMangerService {
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int changeUserInfo(User user);

    /**
     * 管理员登录接口
     * @param admin
     * @return
     */
    String login(Admin admin);

    /**
     * 查询用户信息
     * @return
     */
    List<User> selectUser();
}
