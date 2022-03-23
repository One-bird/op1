package cn.zjf.online_xd.service;

import cn.zjf.online_xd.model.entity.User;

import java.util.Map;

/**
 * @author OneBird
 * @date 2022/3/19 10:47
 **/
public interface UserService {
    /**
     * 保存注册用户
     * @param userInfo
     */
    int save (Map<String,String> userInfo);

    /**
     * 用户登录接口
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(Integer phone, String pwd);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findUserById(Integer userId);
}
