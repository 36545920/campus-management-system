package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResetPasswordDTO {
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @NotNull(message = "密码不能为空")
    private String password;

}
