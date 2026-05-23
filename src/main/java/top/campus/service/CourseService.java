package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.vo.CourseListVO;

public interface CourseService {
    Result<PageInfo<CourseListVO>> getCourseList(CourseQueryDTO queryDTO);
    Result<String> addCourse(CourseSaveDTO dto);
    Result<String> updateCourse(CourseUpdateDTO dto);
    Result<String> deleteCourse(CourseIdDTO dto);
    Result<String> restoreCourse(CourseIdDTO dto);
    Result<CourseListVO> getCourseById(CourseIdDTO dto);
}
