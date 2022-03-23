package cn.zjf.online_xd.controller;

import cn.zjf.online_xd.model.entity.User;
import cn.zjf.online_xd.model.request.LoginRequest;
import cn.zjf.online_xd.service.UserService;
import cn.zjf.online_xd.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author OneBird
 * @date 2022/3/19 11:02
 **/
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo){
        int row = userService.save(userInfo);
        return row == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败，请重试");
    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(),loginRequest.getPwd());
        return token == null ? JsonData.buildError("登录失败，账号或密码错误") : JsonData.buildSuccess(token);
    }

    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId==null){
            return JsonData.buildError("查询失败");
        }
        User user = userService.findUserById(userId);
        return JsonData.buildSuccess(user);
    }
}
