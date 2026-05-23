package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.TeacherQueryDTO;
import top.campus.dto.TeacherSaveDTO;
import top.campus.mapper.TeacherMapper;
import top.campus.service.TeacherService;
import top.campus.vo.TeacherListVO;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public Result<PageInfo<TeacherListVO>> getTeacherListQuery(TeacherQueryDTO teacherQueryDTO) {
        PageHelper.startPage(teacherQueryDTO.getPageNum(), teacherQueryDTO.getPageSize());
        List<TeacherListVO> list = teacherMapper.selectTeachers(teacherQueryDTO);
        return Result.success(PageInfo.of(list));
    }

    @Override
    public Result<String> addTeacher(TeacherSaveDTO teacherSaveDTO) {
        return teacherMapper.addTeacher(teacherSaveDTO) > 0 ? Result.success() : Result.fail("添加失败");
    }
}
