package cn.xyq.cloud.memberserver.controller;

import cn.xyq.cloud.common.resp.Result;
import cn.xyq.cloud.domain.User;
import cn.xyq.cloud.memberserver.service.IUserService;
import cn.xyq.cloud.memberserver.utils.CookieUtil;
import cn.xyq.cloud.memberserver.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    //传入登录信息的vo对象，便于之后拓展
    @PostMapping("/login")
    public Result<?> login(LoginVo vo, HttpServletResponse response) {
        String token = userService.login(vo);
        CookieUtil.addCookie(CookieUtil.USER_TOKEN, token, response);
        return Result.success();
    }
}
