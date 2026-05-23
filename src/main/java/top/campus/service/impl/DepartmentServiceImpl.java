package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.mapper.DepartmentMapper;
import top.campus.service.DepartmentService;
import top.campus.vo.DepartmentListVO;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public Result<PageInfo<DepartmentListVO>> getDepartmentList(DepartmentQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<DepartmentListVO> list = departmentMapper.selectDepartmentList(queryDTO);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result<String> addDepartment(DepartmentSaveDTO dto) {
        return departmentMapper.addDepartment(dto) > 0 ? Result.success() : Result.fail("添加失败");
    }

    @Override
    public Result<String> updateDepartment(DepartmentUpdateDTO dto) {
        return departmentMapper.updateDepartment(dto) > 0 ? Result.success() : Result.fail("更新失败");
    }

    @Override
    public Result<String> deleteDepartment(DepartmentIdDTO dto) {
        return departmentMapper.deleteDepartment(dto) > 0 ? Result.success() : Result.fail("删除失败");
    }

    @Override
    public Result<String> restoreDepartment(DepartmentIdDTO dto) {
        return departmentMapper.restoreDepartment(dto) > 0 ? Result.success() : Result.fail("恢复失败");
    }

    @Override
    public Result<DepartmentListVO> getDepartmentById(DepartmentIdDTO dto) {
        return Result.success(departmentMapper.selectDepartmentById(dto));
    }
}
