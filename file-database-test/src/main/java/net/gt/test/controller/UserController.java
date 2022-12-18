package net.gt.test.controller;

import net.gt.test.entity.User;
import net.gt.test.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试Controller
 *
 * @author gt-it
 * @since 2022/12/14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getOne")
    public User getOne() {
        User users = userService.getOne();
        return users;
    }
    @GetMapping("/test")
    public void test() {

    }

}
