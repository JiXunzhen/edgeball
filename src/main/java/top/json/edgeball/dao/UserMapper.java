package top.json.edgeball.dao;

import org.apache.ibatis.annotations.*;
import top.json.edgeball.domain.UserDO;

@Mapper
public interface UserMapper {
    String ALL_COLUMN_LIST = "id, name, password, mobile, gender";

    @Insert("INSERT INTO t_user (name, password, mobile, gender) values (#{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{mobile, jdbcType=VARCHAR}, #{gender, jdbcType=TINYINT})")
    @Options(useGeneratedKeys = true, flushCache = Options.FlushCachePolicy.TRUE)
    @SelectKey(statement = "SELECT LAST_INSERT_ID();", before = false, keyProperty = "id", resultType = Long.class)
    Long insert(UserDO user);

    @Select("SELECT " + ALL_COLUMN_LIST + " from t_user where id = #{id}")
    UserDO get(Long id);

    @Select("SELECT " + ALL_COLUMN_LIST + " from t_user where mobile = #{mobile}")
    UserDO queryByMobile(String mobile);

    @Select("SELECT " + ALL_COLUMN_LIST + " from t_user where name = #{name}")
    UserDO queryByName(String name);
}
