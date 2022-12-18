package net.gt.test.service;

import net.gt.test.entity.User;

/**
 * 测试Service
 *
 * @author gt-it
 * @since 2022/12/18
 */
public interface UserService {

    /**
     * 获取一条用户记录
     *
     * @return 用户
     */
    User getOne();
}
