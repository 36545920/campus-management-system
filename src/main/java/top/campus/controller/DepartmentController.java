package top.campus.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.service.DepartmentService;
import top.campus.vo.DepartmentListVO;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @PreAuthorize("hasAuthority('department:list')")
    @PostMapping("/list")
    public Result<PageInfo<DepartmentListVO>> getDepartmentList(@RequestBody @Validated DepartmentQueryDTO queryDTO) {
        return departmentService.getDepartmentList(queryDTO);
    }

    @PreAuthorize("hasAuthority('department:add')")
    @PostMapping("/add")
    public Result<String> addDepartment(@RequestBody @Validated DepartmentSaveDTO dto) {
        return departmentService.addDepartment(dto);
    }

    @PreAuthorize("hasAuthority('department:update')")
    @PostMapping("/update")
    public Result<String> updateDepartment(@RequestBody @Validated DepartmentUpdateDTO dto) {
        return departmentService.updateDepartment(dto);
    }

    @PreAuthorize("hasAuthority('department:delete')")
    @PostMapping("/delete")
    public Result<String> deleteDepartment(@RequestBody DepartmentIdDTO dto) {
        return departmentService.deleteDepartment(dto);
    }

    @PreAuthorize("hasAuthority('department:restore')")
    @PostMapping("/restore")
    public Result<String> restoreDepartment(@RequestBody DepartmentIdDTO dto) {
        return departmentService.restoreDepartment(dto);
    }

    @PreAuthorize("hasAuthority('department:list')")
    @PostMapping("/detail")
    public Result<DepartmentListVO> getDepartmentById(@RequestBody DepartmentIdDTO dto) {
        return departmentService.getDepartmentById(dto);
    }
}
