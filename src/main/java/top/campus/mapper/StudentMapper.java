package top.campus.mapper;

import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.campus.dto.StudentSaveDTO;
import top.campus.entity.Student;
import top.campus.vo.StudentListVO;


import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 查找所有用户
     * @return 所有用户列表
     */
    @Select("""
select campus_management.student.id,
       campus_management.student.student_no,
       campus_management.student.name,
       case when campus_management.student.gender = 1 then '男' else '女' end as genderName,
       campus_management.student.phone,
       campus_management.student.avatar,
       campus_management.class_info.class_name,
       campus_management.student.status,
       campus_management.major.major_name
from campus_management.student
left join campus_management.class_info on class_info.id = student.class_id
left join campus_management.major on major.id = class_info.major_id
""")
    List<StudentListVO> studentlist();

    /**
     * 添加用户
     * @param student 新增用户数据
     */
    @Insert("""
insert into campus_management.student(
student_no, name, gender, age, phone, email, avatar, class_id, address, status
)
values (#{studentNO},#{name},#{gender},#{age},#{phone},#{email},#{avatar},#{class_id},#{address},#{status})
""")
    void addStudent(StudentSaveDTO student);

    /**
     * 根据学号找学生
     * @param studentNo 学号
     * @return 学号对应的学生
     */
    @Select("""
select
    * 
from student 
where student_no = #{studentNo}
""")
    Student findStudentByStudentNo(@NotBlank(message = "学号不能为空") String studentNo);

    int updateStudent(StudentSaveDTO student);
}
