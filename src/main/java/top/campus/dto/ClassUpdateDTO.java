package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClassUpdateDTO {
    @NotNull(message = "班级ID不能为空")
    private Long id;

    private String className;
    private Long majorId;
    private Long headTeacherId;
    private String remark;
}
