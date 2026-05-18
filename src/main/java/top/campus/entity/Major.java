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
     * 学院名称
     */
    private String departmentName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
