package net.gt.test.service.impl;

import net.gt.test.filemapper.UserFileMapper;
import net.gt.test.entity.User;
import net.gt.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试Service
 *
 * @author gt-it
 * @since 2022/12/18
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserFileMapper userFileMapper;

    public User getOne() {
        User user = userFileMapper.selectOne();
        return user;
    }
}
