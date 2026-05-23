package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseUpdateDTO {
    @NotNull(message = "课程ID不能为空")
    private Long id;

    private String courseName;
    private String courseCode;
    private String remark;
}
