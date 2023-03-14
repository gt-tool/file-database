package net.gt.core.mapper.impl;

import net.gt.core.mapper.BaseFileMapper;
import net.gt.core.param.QueryParam;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文件数据库基础Mapper实现
 *
 * @author gt-it
 * @since 2022/12/18
 */
@Component
public class BaseFileMapperImpl<T> implements BaseFileMapper<T> {
    @Override
    public int insert(T entity) {
        return 0;
    }

    @Override
    public int deleteById(Object id) {
        return 0;
    }

    @Override
    public int updateById(T entity) {
        return 0;
    }

    @Override
    public T selectById(Object id) {
        return null;
    }

    @Override
    public List<T> selectAll() {
        return null;
    }

    @Override
    public T selectOne(QueryParam<T> queryParam) {
//        Class<?> aClass = ClassUtil.extractModelClass(queryParam.getClass());
        try {
            return (T) queryParam.getClazz().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
