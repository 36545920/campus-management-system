package top.campus.entity;

import lombok.Data;

@Data
public class SysUserRole {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
}
