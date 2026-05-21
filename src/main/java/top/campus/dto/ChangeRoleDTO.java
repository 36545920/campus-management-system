package top.campus.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangeRoleDTO {
    @NotNull
    private Long id;
    @NotNull
    @Min(1) @Max(3)
    private Integer roleId;
}
