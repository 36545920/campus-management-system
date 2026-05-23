package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.vo.MajorListVO;

public interface MajorService {
    Result<PageInfo<MajorListVO>> getMajorList(MajorQueryDTO queryDTO);
    Result<String> addMajor(MajorSaveDTO dto);
    Result<String> updateMajor(MajorUpdateDTO dto);
    Result<String> deleteMajor(MajorIdDTO dto);
    Result<String> restoreMajor(MajorIdDTO dto);
    Result<MajorListVO> getMajorById(MajorIdDTO dto);
}
