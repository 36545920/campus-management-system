package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Course {
    /**
     * 课程ID
     */
    private Long id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程编码
     */
    private String courseCode;

    /**
     * 授课教师ID
     */
    private String teacherId;

    /**
     * 课时
     */
    private Integer classHour;

    /**
     * 备注
     */
    private String remark;

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
