package cn.zjf.online_xd.mapper;

import cn.zjf.online_xd.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author OneBird
 * @date 2022/3/19 10:45
 **/
public interface UserMapper {
    /**
     * 注册保存用户信息
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 用户登录
     * @param phone
     * @param pwd
     * @return
     */
    User findByPhoneAndPwd(@Param("phone") Integer phone,@Param("pwd") String pwd);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findUserById(@Param("user_id") Integer userId);
}
