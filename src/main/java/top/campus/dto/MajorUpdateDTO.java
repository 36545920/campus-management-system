package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MajorUpdateDTO {
    @NotNull(message = "专业ID不能为空")
    private Long id;

    private String majorName;
    private String majorCode;
    private String remark;
    private Long departmentId;
}
