package top.campus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentSaveDTO {
    @NotBlank(message = "学号不能为空")
    private String studentNo;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "性别不能为空")
    private Integer gender;// 1男 2女
    private Integer age;
    private String phone;
    private String email;
    private String avatar;
    private Long classId;     // 班级ID
    private String address;
    private Integer status;

    // 如果需要初始密码，可以不从前端传，后端统一设置
}