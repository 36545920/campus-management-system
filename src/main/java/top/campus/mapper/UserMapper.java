package top.campus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.campus.entity.SysUser;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名查用户
     * @param username 用户名
     * @return 用户对象
     */
    @Select("""
            SELECT
                id,
                username,
                password,
                nickname,
                avatar,
                phone,
                email,
                status,
                user_type,
                create_time,
                update_time
            FROM campus_management.sys_user
            WHERE username = #{username}
            """)
    SysUser selectByUsername(String username);



}
