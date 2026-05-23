package top.campus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorListVO {
    private Long id;
    private String majorName;
    private String majorCode;
    private String remark;
    private String departmentName;
    private Long departmentId;
    private Integer status;
    private LocalDateTime createTime;
}
