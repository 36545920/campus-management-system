package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Teacher {
    /**
     * 教师ID
     */
    private String id;

    /**
     * 教师工号
     */
    private String teacherNo;

    /**
     * 教师姓名
     */
    private String name;

    /**
     * 教师性别
     * 1 男
     * 0 女
     */
    private Integer gender;

    /**
     * 教师年龄
     */
    private Integer age;

    /**
     * 教师手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职称
     */
    private String title;

    /**
     * 所属专业ID
     */
    private Long majorId;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 状态
     * 1 正常
     * 0 离职
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
