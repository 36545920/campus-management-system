package top.campus.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MajorQueryDTO {
    @Min(1)
    @NotNull
    private Integer pageNum = 1;

    @Min(1)
    @NotNull
    private Integer pageSize = 10;

    private String keyword;
    private Long departmentId;
    private Integer status;
}
