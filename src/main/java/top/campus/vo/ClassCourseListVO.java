package top.campus.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassCourseListVO {
    private Long id;
    private String className;
    private String courseName;
    private String teacherName;
    private Long classId;
    private Long courseId;
    private Long teacherId;
    private Integer status;
}
