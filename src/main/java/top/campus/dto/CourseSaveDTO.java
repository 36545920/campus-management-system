package top.campus.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseSaveDTO {
    @NotBlank(message = "课程名称不能为空")
    private String courseName;

    private String courseCode;
    private String remark;
}
