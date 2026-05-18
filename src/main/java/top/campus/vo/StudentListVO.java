package top.campus.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private String genderName;

    /**
     * 手机号
     */
    private String phone;

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

    /**
     * 专业名称
     */
    private String majorName;

}
