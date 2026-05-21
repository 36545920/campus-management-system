package top.campus.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UseQueryDTO {

    @Min(1)
    @NotNull
    private Integer pageNum = 1;

    @Min(1)
    @NotNull
    private Integer pageSize = 10;

    private String keyword;
    private Integer userType;
    private Integer status;
    private Boolean isDeleted;
}
