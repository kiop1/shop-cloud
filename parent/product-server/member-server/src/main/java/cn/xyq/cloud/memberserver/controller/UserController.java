package cn.xyq.cloud.memberserver.controller;

import cn.xyq.cloud.domain.User;
import cn.xyq.cloud.memberserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
