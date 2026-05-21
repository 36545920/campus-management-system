package top.campus.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/**
 * 前端传来用户数据
 */
@Data
public class SysUserSaveDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */

    private String password;

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
    @NotBlank(message = "用户类型不能为空")
    private Integer userType;

}
