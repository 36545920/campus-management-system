package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.mapper.ClassCourseMapper;
import top.campus.service.ClassCourseService;
import top.campus.vo.ClassCourseListVO;

import java.util.List;

@Service
public class ClassCourseServiceImpl implements ClassCourseService {

    @Resource
    private ClassCourseMapper classCourseMapper;

    @Override
    public Result<PageInfo<ClassCourseListVO>> getClassCourseList(ClassCourseQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<ClassCourseListVO> list = classCourseMapper.selectClassCourseList(queryDTO);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result<String> addClassCourse(ClassCourseSaveDTO dto) {
        return classCourseMapper.addClassCourse(dto) > 0 ? Result.success() : Result.fail("添加失败");
    }

    @Override
    public Result<String> updateClassCourse(ClassCourseUpdateDTO dto) {
        return classCourseMapper.updateClassCourse(dto) > 0 ? Result.success() : Result.fail("更新失败");
    }

    @Override
    public Result<String> deleteClassCourse(ClassCourseIdDTO dto) {
        return classCourseMapper.deleteClassCourse(dto) > 0 ? Result.success() : Result.fail("删除失败");
    }

    @Override
    public Result<String> restoreClassCourse(ClassCourseIdDTO dto) {
        return classCourseMapper.restoreClassCourse(dto) > 0 ? Result.success() : Result.fail("恢复失败");
    }

    @Override
    public Result<ClassCourseListVO> getClassCourseById(ClassCourseIdDTO dto) {
        return Result.success(classCourseMapper.selectClassCourseById(dto));
    }
}
