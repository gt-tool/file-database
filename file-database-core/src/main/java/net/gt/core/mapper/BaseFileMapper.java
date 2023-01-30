package net.gt.core.mapper;

import net.gt.core.param.QueryParam;

import java.util.List;

/**
 * Mapper 继承该接口后，自动获得对文件的CRUD功能
 *
 * @author gt-it
 * @since 2022/12/18
 */
public interface BaseFileMapper<T> extends FileMapper<T> {

    /**
     * 新增
     *
     * @param entity 记录
     * @return 成功：1, 失败：0
     */
    int insert(T entity);

    /**
     * 根据主键删除，主键名默认为id
     *
     * @param id id
     * @return 删除记录数
     */
    int deleteById(Object id);

    /**
     * 根据主键修改，主键名默认为id
     *
     * @param entity 数据
     * @return 修改成功记录数
     */
    int updateById(T entity);

    /**
     * 根据主键查找，主键名默认为id
     *
     * @param id id
     * @return 数据
     */
    T selectById(Object id);

    /**
     * 查询全部
     *
     * @return 文件内全部数据
     */
    List<T> selectAll();

    /**
     * 查询一条记录
     *
     * @return 记录
     */
    T selectOne(QueryParam<T> queryParam);

}
