package top.campus.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClassCourseQueryDTO {
    @Min(1)
    @NotNull
    private Integer pageNum = 1;

    @Min(1)
    @NotNull
    private Integer pageSize = 10;

    private Long classId;
    private Long courseId;
    private Long teacherId;
    private Integer status;
}
