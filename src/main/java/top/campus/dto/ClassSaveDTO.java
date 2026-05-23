package top.campus.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClassSaveDTO {
    @NotBlank(message = "班级名称不能为空")
    private String className;

    private Long majorId;
    private Long headTeacherId;
    private String remark;
}
