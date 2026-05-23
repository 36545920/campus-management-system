package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.vo.ClassListVO;

public interface ClassService {
    Result<PageInfo<ClassListVO>> getClassList(ClassQueryDTO queryDTO);
    Result<String> addClass(ClassSaveDTO dto);
    Result<String> updateClass(ClassUpdateDTO dto);
    Result<String> deleteClass(ClassIdDTO dto);
    Result<String> restoreClass(ClassIdDTO dto);
    Result<ClassListVO> getClassById(ClassIdDTO dto);
}
