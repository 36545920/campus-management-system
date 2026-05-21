package top.campus.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysPermission {
    /**
     * 权限ID
     */
    private Long id;

    /**
    * 权限名称
    */
    private String permissionName;

    /**
    * 权限标识
    */
    private String permissionCode;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 类型
     * 1 菜单
     * 2 按钮
     * 3 接口
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
