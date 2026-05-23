package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentUpdateDTO {
    @NotNull(message = "学院ID不能为空")
    private Long id;

    private String departmentName;
    private String remark;
}
