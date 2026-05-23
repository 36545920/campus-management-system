package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.mapper.CourseMapper;
import top.campus.service.CourseService;
import top.campus.vo.CourseListVO;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public Result<PageInfo<CourseListVO>> getCourseList(CourseQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<CourseListVO> list = courseMapper.selectCourseList(queryDTO);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result<String> addCourse(CourseSaveDTO dto) {
        return courseMapper.addCourse(dto) > 0 ? Result.success() : Result.fail("添加失败");
    }

    @Override
    public Result<String> updateCourse(CourseUpdateDTO dto) {
        return courseMapper.updateCourse(dto) > 0 ? Result.success() : Result.fail("更新失败");
    }

    @Override
    public Result<String> deleteCourse(CourseIdDTO dto) {
        return courseMapper.deleteCourse(dto) > 0 ? Result.success() : Result.fail("删除失败");
    }

    @Override
    public Result<String> restoreCourse(CourseIdDTO dto) {
        return courseMapper.restoreCourse(dto) > 0 ? Result.success() : Result.fail("恢复失败");
    }

    @Override
    public Result<CourseListVO> getCourseById(CourseIdDTO dto) {
        return Result.success(courseMapper.selectCourseById(dto));
    }
}
