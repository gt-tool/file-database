package net.gt.test.filemapper;

import net.gt.core.mapper.BaseFileMapper;
import net.gt.test.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类描述
 *
 * @author gt-it
 * @since 2022/12/18
 */

@Component
public class UserFileMapperImpl implements UserFileMapper {
    @Override
    public int insert(User entity) {
        return 0;
    }

    @Override
    public int deleteById(Object id) {
        return 0;
    }

    @Override
    public int updateById(User entity) {
        return 0;
    }

    @Override
    public User selectById(Object id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public User selectOne() {
        return new User();
    }
}
