package top.campus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.campus.dto.CourseIdDTO;
import top.campus.dto.CourseQueryDTO;
import top.campus.dto.CourseSaveDTO;
import top.campus.dto.CourseUpdateDTO;
import top.campus.vo.CourseListVO;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<CourseListVO> selectCourseList(CourseQueryDTO queryDTO);

    @Insert("insert into course(course_name, course_code, remark) values (#{courseName}, #{courseCode}, #{remark})")
    int addCourse(CourseSaveDTO dto);

    int updateCourse(CourseUpdateDTO dto);

    @Update("update course set status = 0, update_time = NOW() where id = #{id}")
    int deleteCourse(CourseIdDTO dto);

    @Update("update course set status = 1, update_time = NOW() where id = #{id}")
    int restoreCourse(CourseIdDTO dto);

    @Select("select * from course where id = #{id}")
    CourseListVO selectCourseById(CourseIdDTO dto);
}
