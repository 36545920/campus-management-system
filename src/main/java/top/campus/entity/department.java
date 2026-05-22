package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class department {
    /**
     * 学院ID
     */
    private Long id;

    /**
     * 学院名称
     */
    private String departmentName;

    /**
     * 标注
     */
    private String remark;

    /**
     * 状态
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
