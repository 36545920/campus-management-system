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
import top.campus.dto.TeacherQueryDTO;
import top.campus.dto.TeacherSaveDTO;
import top.campus.service.TeacherService;
import top.campus.vo.TeacherListVO;



@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    TeacherService teacherService;

    /**
     * 根据条件查找教师
     * @param teacherQueryDTO 查询条件
     * @return 符合条件的老师
     */
    @PreAuthorize("hasAuthority('teacher:list')")
    @PostMapping("/list")
    public Result<PageInfo<TeacherListVO>> getTeacherList(@RequestBody @Validated TeacherQueryDTO teacherQueryDTO) {
        return teacherService.getTeacherListQuery(teacherQueryDTO);
    }

    @PreAuthorize("hasAuthority('teacher:add')")
    @PostMapping("/add")
    public Result<String> addTeacher(@RequestBody @Validated TeacherSaveDTO teacherSaveDTO) {
        return teacherService.addTeacher(teacherSaveDTO);
    }

}
