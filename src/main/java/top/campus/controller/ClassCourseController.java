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
import top.campus.service.ClassCourseService;
import top.campus.vo.ClassCourseListVO;

@RestController
@RequestMapping("/classCourse")
public class ClassCourseController {

    @Resource
    private ClassCourseService classCourseService;

    @PreAuthorize("hasAuthority('classCourse:list')")
    @PostMapping("/list")
    public Result<PageInfo<ClassCourseListVO>> getClassCourseList(@RequestBody @Validated ClassCourseQueryDTO queryDTO) {
        return classCourseService.getClassCourseList(queryDTO);
    }

    @PreAuthorize("hasAuthority('classCourse:add')")
    @PostMapping("/add")
    public Result<String> addClassCourse(@RequestBody @Validated ClassCourseSaveDTO dto) {
        return classCourseService.addClassCourse(dto);
    }

    @PreAuthorize("hasAuthority('classCourse:update')")
    @PostMapping("/update")
    public Result<String> updateClassCourse(@RequestBody @Validated ClassCourseUpdateDTO dto) {
        return classCourseService.updateClassCourse(dto);
    }

    @PreAuthorize("hasAuthority('classCourse:delete')")
    @PostMapping("/delete")
    public Result<String> deleteClassCourse(@RequestBody ClassCourseIdDTO dto) {
        return classCourseService.deleteClassCourse(dto);
    }

    @PreAuthorize("hasAuthority('classCourse:restore')")
    @PostMapping("/restore")
    public Result<String> restoreClassCourse(@RequestBody ClassCourseIdDTO dto) {
        return classCourseService.restoreClassCourse(dto);
    }

    @PreAuthorize("hasAuthority('classCourse:list')")
    @PostMapping("/detail")
    public Result<ClassCourseListVO> getClassCourseById(@RequestBody ClassCourseIdDTO dto) {
        return classCourseService.getClassCourseById(dto);
    }
}
