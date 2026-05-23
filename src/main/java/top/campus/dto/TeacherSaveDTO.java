package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeacherSaveDTO {
    @NotNull(message = "学号不能为空")
    private String teacherNo;

    @NotNull(message = "名字不能为空")
    private String name;



}
