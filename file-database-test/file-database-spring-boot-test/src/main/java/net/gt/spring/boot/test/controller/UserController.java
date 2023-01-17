package net.gt.spring.boot.test.controller;

import net.gt.spring.boot.test.pojo.UserPO;
import net.gt.spring.boot.test.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author gt-it
 * @version 0.0.1
 * @since 2023/01/17
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 得到一个用户
     *
     * @return {@link UserPO}
     */
    @RequestMapping("/getOneUser")
    public UserPO getOneUser() {
        return userService.getOneUser();
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id id
     * @return {@link UserPO}
     */
    @RequestMapping("/getUserById")
    public UserPO getUserById(Integer id) {
        return userService.getUserById(id);
    }

}
