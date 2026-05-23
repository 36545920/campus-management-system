package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.mapper.ClassMapper;
import top.campus.service.ClassService;
import top.campus.vo.ClassListVO;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;

    @Override
    public Result<PageInfo<ClassListVO>> getClassList(ClassQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<ClassListVO> list = classMapper.selectClassList(queryDTO);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result<String> addClass(ClassSaveDTO dto) {
        return classMapper.addClass(dto) > 0 ? Result.success() : Result.fail("添加失败");
    }

    @Override
    public Result<String> updateClass(ClassUpdateDTO dto) {
        return classMapper.updateClass(dto) > 0 ? Result.success() : Result.fail("更新失败");
    }

    @Override
    public Result<String> deleteClass(ClassIdDTO dto) {
        return classMapper.deleteClass(dto) > 0 ? Result.success() : Result.fail("删除失败");
    }

    @Override
    public Result<String> restoreClass(ClassIdDTO dto) {
        return classMapper.restoreClass(dto) > 0 ? Result.success() : Result.fail("恢复失败");
    }

    @Override
    public Result<ClassListVO> getClassById(ClassIdDTO dto) {
        return Result.success(classMapper.selectClassById(dto));
    }
}
