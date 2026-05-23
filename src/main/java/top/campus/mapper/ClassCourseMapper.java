package top.campus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.campus.dto.ClassCourseIdDTO;
import top.campus.dto.ClassCourseQueryDTO;
import top.campus.dto.ClassCourseSaveDTO;
import top.campus.dto.ClassCourseUpdateDTO;
import top.campus.vo.ClassCourseListVO;

import java.util.List;

@Mapper
public interface ClassCourseMapper {

    List<ClassCourseListVO> selectClassCourseList(ClassCourseQueryDTO queryDTO);

    @Insert("insert into class_course(class_id, course_id, teacher_id, status) values (#{classId}, #{courseId}, #{teacherId}, 1)")
    int addClassCourse(ClassCourseSaveDTO dto);

    @Update("update class_course set class_id = #{classId}, course_id = #{courseId}, teacher_id = #{teacherId}, update_time = NOW() where id = #{id}")
    int updateClassCourse(ClassCourseUpdateDTO dto);

    @Update("update class_course set status = 0, update_time = NOW() where id = #{id}")
    int deleteClassCourse(ClassCourseIdDTO dto);

    @Update("update class_course set status = 1, update_time = NOW() where id = #{id}")
    int restoreClassCourse(ClassCourseIdDTO dto);

    @Select("""
            select
                cc.id,
                ci.class_name,
                c.course_name,
                t.name as teacher_name,
                cc.class_id,
                cc.course_id,
                cc.teacher_id,
                cc.status
            from class_course cc
            left join class_info ci on cc.class_id = ci.id
            left join course c on cc.course_id = c.id
            left join teacher t on cc.teacher_id = t.id
            where cc.id = #{id}
            """)
    ClassCourseListVO selectClassCourseById(ClassCourseIdDTO dto);
}
