package top.campus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassListVO {
    private Long id;
    private String className;
    private String majorName;
    private String headTeacherName;
    private Integer studentCount;
    private String remark;
    private Integer status;
}
