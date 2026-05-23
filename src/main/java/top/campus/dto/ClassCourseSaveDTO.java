package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClassCourseSaveDTO {
    @NotNull(message = "班级ID不能为空")
    private Long classId;

    @NotNull(message = "课程ID不能为空")
    private Long courseId;

    @NotNull(message = "教师ID不能为空")
    private Long teacherId;
}
