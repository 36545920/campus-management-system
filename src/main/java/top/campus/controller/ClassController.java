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
import top.campus.service.ClassService;
import top.campus.vo.ClassListVO;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Resource
    private ClassService classService;

    @PreAuthorize("hasAuthority('class:list')")
    @PostMapping("/list")
    public Result<PageInfo<ClassListVO>> getClassList(@RequestBody @Validated ClassQueryDTO queryDTO) {
        return classService.getClassList(queryDTO);
    }

    @PreAuthorize("hasAuthority('class:add')")
    @PostMapping("/add")
    public Result<String> addClass(@RequestBody @Validated ClassSaveDTO dto) {
        return classService.addClass(dto);
    }

    @PreAuthorize("hasAuthority('class:update')")
    @PostMapping("/update")
    public Result<String> updateClass(@RequestBody @Validated ClassUpdateDTO dto) {
        return classService.updateClass(dto);
    }

    @PreAuthorize("hasAuthority('class:delete')")
    @PostMapping("/delete")
    public Result<String> deleteClass(@RequestBody ClassIdDTO dto) {
        return classService.deleteClass(dto);
    }

    @PreAuthorize("hasAuthority('class:restore')")
    @PostMapping("/restore")
    public Result<String> restoreClass(@RequestBody ClassIdDTO dto) {
        return classService.restoreClass(dto);
    }

    @PreAuthorize("hasAuthority('class:list')")
    @PostMapping("/detail")
    public Result<ClassListVO> getClassById(@RequestBody ClassIdDTO dto) {
        return classService.getClassById(dto);
    }
}
