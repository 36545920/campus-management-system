package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClassInfo {
    /**
     * 班级ID
     */
    private Long id;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 学生数量
     */
    private Integer count;

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

    /**
     * 专业ID
     */
    private Long managerId;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班主任ID
     */
    private Long headTeacherId;
}
