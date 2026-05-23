package top.campus.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeacherQueryDTO {

    @Min(1)
    @NotNull
    private Integer pageNum = 1;

    @Min(1)
    @NotNull
    private Integer pageSize = 10;

    /**
     * 教师工号
     */
    private String teacherNo;

    /**
     * 教师姓名
     */
    private String name;

    /**
     * 教师性别
     * 1 男
     * 0 女
     */
    private Integer gender;

    /**
     * 所属学院ID
     */
    private Long departmentId;

    /**
     * 状态
     * 1 正常
     * 0 离职
     */
    private Integer status;
}
