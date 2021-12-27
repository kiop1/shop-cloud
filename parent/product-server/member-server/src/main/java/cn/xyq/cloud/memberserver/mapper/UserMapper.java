package cn.xyq.cloud.memberserver.mapper;

import cn.xyq.cloud.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where id = #{id}")
    User selectById(Long id);
}
