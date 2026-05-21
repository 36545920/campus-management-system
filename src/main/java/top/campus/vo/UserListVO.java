package top.campus.vo;

import lombok.Data;



@Data
public class UserListVO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    private String avatar;


    /**
     * 用户类型
     * 1 管理员
     * 2 教师
     * 3 学生
     */
    private Integer userType;

}
