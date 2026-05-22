package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Major {
    /**
     * 专业ID
     */
    private Integer id;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 专业编码
     */
    private String majorCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 学院ID
     */
    private String departmentID;

    /**
     * 状态
     * 1 正常
     * 0 停止
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
