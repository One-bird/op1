package cn.zjf.online_xd.service.impl;

import cn.zjf.online_xd.model.entity.User;
import cn.zjf.online_xd.mapper.UserMapper;
import cn.zjf.online_xd.service.UserService;
import cn.zjf.online_xd.utils.CommonUtils;
import cn.zjf.online_xd.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author OneBird
 * @date 2022/3/19 10:48
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {
        User user = paseToUser(userInfo);
        if (user!=null){
            return userMapper.save(user);
        }else {
            return -1;
        }

    }

    @Override
    public String findByPhoneAndPwd(Integer phone, String pwd) {
        User user =  userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if(user==null){
            return null;
        }else {
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }
    }

    @Override
    public User findUserById(Integer userId) {
        User user = userMapper.findUserById(userId);
        return user;
    }

    /**
     * 解析user对象
     * @param userInfo
     * @return
     */
    private User paseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("name") && userInfo.containsKey("phone") && userInfo.containsKey("pwd")){
            User user = new User();
            user.setCreateTime(new Date());
            user.setHeadImg(getRandomImg());
            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            pwd = CommonUtils.MD5(pwd);
            user.setPwd(pwd);
            return user;
        }
        return null;
    }

    /**
     * CDN头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cnbeijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    /**
     * 生成随机头像
     * @return
     */
    private String getRandomImg(){
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
