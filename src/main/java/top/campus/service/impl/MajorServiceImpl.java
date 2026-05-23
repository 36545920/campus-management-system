package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.mapper.MajorMapper;
import top.campus.service.MajorService;
import top.campus.vo.MajorListVO;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Resource
    private MajorMapper majorMapper;

    @Override
    public Result<PageInfo<MajorListVO>> getMajorList(MajorQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<MajorListVO> list = majorMapper.selectMajorList(queryDTO);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result<String> addMajor(MajorSaveDTO dto) {
        return majorMapper.addMajor(dto) > 0 ? Result.success() : Result.fail("添加失败");
    }

    @Override
    public Result<String> updateMajor(MajorUpdateDTO dto) {
        return majorMapper.updateMajor(dto) > 0 ? Result.success() : Result.fail("更新失败");
    }

    @Override
    public Result<String> deleteMajor(MajorIdDTO dto) {
        return majorMapper.deleteMajor(dto) > 0 ? Result.success() : Result.fail("删除失败");
    }

    @Override
    public Result<String> restoreMajor(MajorIdDTO dto) {
        return majorMapper.restoreMajor(dto) > 0 ? Result.success() : Result.fail("恢复失败");
    }

    @Override
    public Result<MajorListVO> getMajorById(MajorIdDTO dto) {
        return Result.success(majorMapper.selectMajorById(dto));
    }
}
