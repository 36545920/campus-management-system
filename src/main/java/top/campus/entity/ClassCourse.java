package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClassCourse {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
