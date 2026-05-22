package top.campus.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentQueryDTO {
    @Min(1)
    @NotNull
    private Integer pageNum = 1;

    @Min(1)
    @NotNull
    private Integer pageSize = 10;

    /**
     * 学号模糊查询
     */
    private String studentNo;

    /**
     * name名字关键词模糊查询
     */
    private String keyword;

    /**
     * 性别
     * 1 男
     * 0 女
     */
    private Integer gender;

    /**
     * 班级ID
     */
    private Integer classId;

    /**
     * 状态
     * 1 正常
     * 0 休学，删除或者毕业
     */
    private Integer status;
}
