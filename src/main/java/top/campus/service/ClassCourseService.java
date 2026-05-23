package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.vo.ClassCourseListVO;

public interface ClassCourseService {
    Result<PageInfo<ClassCourseListVO>> getClassCourseList(ClassCourseQueryDTO queryDTO);
    Result<String> addClassCourse(ClassCourseSaveDTO dto);
    Result<String> updateClassCourse(ClassCourseUpdateDTO dto);
    Result<String> deleteClassCourse(ClassCourseIdDTO dto);
    Result<String> restoreClassCourse(ClassCourseIdDTO dto);
    Result<ClassCourseListVO> getClassCourseById(ClassCourseIdDTO dto);
}
