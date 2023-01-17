package net.gt.spring.boot.test.service;

import net.gt.spring.boot.test.pojo.UserPO;

/**
 * 用户
 *
 * @author gt-it
 * @version 0.0.1
 * @since 2023/01/17
 */
public interface UserService {

    /**
     * 获取一个用户
     *
     * @return {@link UserPO}
     */
    UserPO getOneUser();

    /**
     * 根据用户id获取用户信息
     *
     * @param id id
     * @return {@link UserPO}
     */
    UserPO getUserById(Integer id);

}
