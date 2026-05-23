package top.campus.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import top.campus.dto.TeacherQueryDTO;
import top.campus.dto.TeacherSaveDTO;
import top.campus.vo.TeacherListVO;

import java.util.List;

@Mapper
public interface TeacherMapper {
    List<TeacherListVO> selectTeachers(TeacherQueryDTO teacherQueryDTO);

    @Insert("""
            insert into teacher(teacher_no, name)
            values (#{teacherNo}, #{name})
            """)
    int addTeacher(TeacherSaveDTO teacherSaveDTO);
}
