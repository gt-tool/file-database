package net.gt.spring.boot.test.service.impl;

import net.gt.core.param.QueryParam;
import net.gt.spring.boot.test.filedao.UserFileDao;
import net.gt.spring.boot.test.pojo.UserPO;
import net.gt.spring.boot.test.pojo.UserPO1;
import net.gt.spring.boot.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务impl
 *
 * @author gt-it
 * @version 0.0.1
 * @since 2023/01/17
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserFileDao userFileDao;

    @Override
    public UserPO getOneUser() {
        QueryParam<UserPO> objectQueryParam = new QueryParam<>(UserPO.class);
        UserPO user = userFileDao.selectOne(objectQueryParam);
        logger.debug(user.toString());
        return user;
    }

    @Override
    public UserPO getUserById(Integer id) {
        return userFileDao.selectById(id);
    }
}
