package top.campus.vo;

import lombok.Data;

@Data
public class TeacherListVO {
    /**
     * 教师ID
     */
    private String id;

    /**
     * 教师工号
     */
    private String teacherNo;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 教师姓名
     */
    private String name;

    /**
     * 所属学院
     */
    private String departmentName;

    /**
     * 教师性别
     * 1 男
     * 0 女
     */
    private Integer gender;

    /**
     * 状态
     * 1 正常
     * 0 离职
     */
    private Integer status;
}
