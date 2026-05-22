package top.campus.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentListVO {
    /**
     * 学生ID
     */
    private Long id;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 状态
     */
    private Integer status;



}
