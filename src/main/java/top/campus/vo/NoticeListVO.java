package top.campus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeListVO {
    private Long id;
    private String title;
    private String publisher;
    private Integer isTop;
    private Integer status;
    private LocalDateTime createTime;
}
