package top.campus.vo;

import java.time.LocalDateTime;

public class StudentDetailedVO {
    /**
     * 学生ID
     */
    private Integer id;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 性别
     * 1 男
     * 0 女
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 状态
     * 1 正常
     * 0 停用
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
