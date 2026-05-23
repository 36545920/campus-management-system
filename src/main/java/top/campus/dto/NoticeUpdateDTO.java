package top.campus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NoticeUpdateDTO {
    @NotNull(message = "公告ID不能为空")
    private Long id;

    private String title;
    private String content;
    private Integer isTop;
    private Integer status;
}
