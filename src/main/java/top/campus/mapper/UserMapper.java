package top.campus.mapper;

import org.apache.ibatis.annotations.*;
import top.campus.dto.SysUserIdDTO;
import top.campus.dto.SysUserSaveDTO;
import top.campus.dto.SysUserUpdateDTO;
import top.campus.dto.UseQueryDTO;
import top.campus.entity.SysUser;
import top.campus.vo.UserListVO;

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
    SysUser selectUserByUsername(String username);

    /**
     * 根据用户id查用户
     * @param id 用户id
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
            WHERE id = #{id}
            """)
    SysUser selectUserById(Long id);

    /**
     * 添加用户
     * @param sysUserSaveDTO 前端传过来的use数据
     */
    @Insert("""
            insert into sys_user(
            username, nickname, password,avatar, phone, email, user_type
            ) VALUES (#{username},#{password},#{nickname},#{avatar},#{phone},#{email},#{userType})
            """)
    void addSysUser(SysUserSaveDTO sysUserSaveDTO);

    /**
     * 更新用户信息
     * @param sysUserUpdateDTO 更新的用户信息
     * @return 影响行数
     */
    int updateSysUser(SysUserUpdateDTO sysUserUpdateDTO);

    /**
     * 根据用户ID删除用户
     * @param dto 用户ID
     * @return 影响行数
     */
    @Update("update sys_user set sys_user.is_deleted = 1 ,update_time = NOW() where id = #{id}")
    int deleteSysUserById(SysUserIdDTO dto);

    /**
     * 启用用户
     * @param dto 用户id
     * @return 影响行数
     */
    @Update("update sys_user set is_deleted = 0,update_time = NOW() where id = #{id}")
    int restoreSysUser(SysUserIdDTO dto);

    /**
     * 根据用户ID修改状态
     * @param userID 用户ID
     * @param status 状态
     * @return 影响行数
     */
    @Update("update sys_user set status = #{status},update_time = NOW() where id = #{userID} and is_deleted = 0")
    int changeUserStatusByUserID(@Param("userID") Long userID, @Param("status") int status);

    /**
     * 根据用户id修改角色
     * @param id 用户id
     * @param roleId 角色ID
     * @return 影响行数
     */
    @Update("update sys_user set user_type = #{roleId},update_time = NOW() where id = #{userID} and is_deleted = 0")
    int changeUserRole(@Param("userID") Long id, @Param("roleId") Integer roleId);

    /**
     * 根据条件查找用户
     * @param useQueryDTO 条件列表
     * @return 用户列表
     */
    List<UserListVO> getUserList(UseQueryDTO useQueryDTO);

    /**
     * 根据用户ID修改密码
     * @param sysUser 用户信息（主要是ID和密码）
     * @return 影响行数
     */
    @Update("update sys_user set password = #{password} where id = #{id} and is_deleted = 0")
    int changePassword(SysUser sysUser);
}
