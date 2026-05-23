package top.campus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MajorSaveDTO {
    @NotBlank(message = "专业名称不能为空")
    private String majorName;

    private String majorCode;
    private String remark;

    @NotNull(message = "学院ID不能为空")
    private Long departmentId;
}
