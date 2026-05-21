package top.campus.vo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDetailedVO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;


    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态 1正常 0禁用
     */
    private Integer status;

    /**
     * 用户类型
     * 1 管理员
     * 2 教师
     * 3 学生
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
