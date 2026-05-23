package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.vo.DepartmentListVO;

public interface DepartmentService {
    Result<PageInfo<DepartmentListVO>> getDepartmentList(DepartmentQueryDTO queryDTO);
    Result<String> addDepartment(DepartmentSaveDTO dto);
    Result<String> updateDepartment(DepartmentUpdateDTO dto);
    Result<String> deleteDepartment(DepartmentIdDTO dto);
    Result<String> restoreDepartment(DepartmentIdDTO dto);
    Result<DepartmentListVO> getDepartmentById(DepartmentIdDTO dto);
}
