package top.campus.mapper;

import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.campus.dto.StudentIdDTO;
import top.campus.dto.StudentQueryDTO;
import top.campus.dto.StudentSaveDTO;
import top.campus.dto.UpdateStudentDTO;
import top.campus.entity.Student;
import top.campus.vo.StudentDetailedVO;
import top.campus.vo.StudentListVO;


import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 根据条件查询学生
     *
     * @return 符合条件的学生列表
     */
    List<StudentListVO> getStudentList(StudentQueryDTO studentQueryDTO);

    /**
     * 添加学生
     *
     * @param student 新增的学生数据
     */
    @Insert("""
            insert into campus_management.student(
            student_no, name, gender, age, phone, email, avatar, class_id, address, status
            )
            values (#{studentNO},#{name},#{gender},#{age},#{phone},#{email},#{avatar},#{class_id},#{address},#{status})
            """)
    int addStudent(StudentSaveDTO student);

    /**
     * 根据学号找学生
     *
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

    int updateStudent(UpdateStudentDTO student);

    @Update("update student set status = 0 ,student.update_time = NOW() where id = #{id}")
    int deleteStudent(StudentIdDTO idDTO);

    @Update("update student set status = 1 ,student.update_time = NOW() where id = #{id}")
    int restoreStudent(StudentIdDTO dto);

    @Select("""
            select
                *
            from student
            where id = #{id}
            """)
    StudentDetailedVO findStudentByStudentId(StudentIdDTO dto);
}
