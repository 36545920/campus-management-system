package top.campus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseListVO {
    private Long id;
    private String courseName;
    private String courseCode;
    private String remark;
    private Integer status;
    private LocalDateTime createTime;
}
