package top.campus.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentSaveDTO {
    @NotBlank(message = "学院名称不能为空")
    private String departmentName;

    private String remark;
}
