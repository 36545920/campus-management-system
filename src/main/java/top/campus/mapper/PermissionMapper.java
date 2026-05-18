package top.campus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("""
select distinct
    campus_management.sys_permission.permission_code
from campus_management.sys_user
left join campus_management.sys_user_role on sys_user.id = sys_user_role.user_id
left join campus_management.sys_role on sys_user_role.role_id = sys_role.id
left join campus_management.sys_role_permission on sys_role.id = sys_role_permission.role_id
left join campus_management.sys_permission on sys_role_permission.permission_id = sys_permission.id
where username = #{username}
""")
    List<String> selectPermissionByUsername(String username);
}
