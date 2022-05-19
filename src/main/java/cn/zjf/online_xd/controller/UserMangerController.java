package cn.zjf.online_xd.controller;

import cn.zjf.online_xd.model.entity.Admin;
import cn.zjf.online_xd.model.entity.User;
import cn.zjf.online_xd.service.UserMangerService;
import cn.zjf.online_xd.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/23 20:48
 **/
@RestController
@RequestMapping("admin/v1/pri/user")
public class UserMangerController {

    @Autowired
    private UserMangerService userMangerService;

    @GetMapping("modifyInfo")
    public JsonData changeUserInfo(@RequestBody User user){
        int row = userMangerService.changeUserInfo(user);
        if (row==1){
            return JsonData.buildSuccess("修改成功");
        }else {
            return JsonData.buildError("修改失败");
        }
    }

    @PostMapping("login")
    public JsonData adminLogin(@RequestBody Admin admin){
        String token = userMangerService.login(admin);
        return token == null ? JsonData.buildError("登录失败，账号或密码错误") : JsonData.buildSuccess(token);
    }

    @GetMapping("selectUser")
    public JsonData selectUser(){
        List<User> userList = userMangerService.selectUser();
        return JsonData.buildSuccess(userList);
    }

}
