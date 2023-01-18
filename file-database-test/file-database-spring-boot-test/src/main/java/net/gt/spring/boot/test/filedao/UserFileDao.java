package net.gt.spring.boot.test.filedao;

import net.gt.core.annotations.FileMapper;
import net.gt.core.mapper.BaseFileMapper;
import net.gt.spring.boot.test.pojo.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户FileDao
 *
 * @author gt-it
 * @version 0.0.1
 * @since 2023/01/17
 */

@FileMapper
public interface UserFileDao extends BaseFileMapper<UserPO> {

}
