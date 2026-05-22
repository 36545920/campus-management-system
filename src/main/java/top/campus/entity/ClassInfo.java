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
     * 专业ID
     */
    private Long majorId;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 班主任ID
     */
    private String headTeacherId;

    /**
     * 学生数量
     */
    private Integer studentCount;

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
