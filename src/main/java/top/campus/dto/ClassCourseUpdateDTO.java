package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClassCourseUpdateDTO {
    @NotNull(message = "ID不能为空")
    private Long id;

    private Long classId;
    private Long courseId;
    private Long teacherId;
}
