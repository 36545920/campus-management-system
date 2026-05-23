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
import top.campus.service.CourseService;
import top.campus.vo.CourseListVO;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @PreAuthorize("hasAuthority('course:list')")
    @PostMapping("/list")
    public Result<PageInfo<CourseListVO>> getCourseList(@RequestBody @Validated CourseQueryDTO queryDTO) {
        return courseService.getCourseList(queryDTO);
    }

    @PreAuthorize("hasAuthority('course:add')")
    @PostMapping("/add")
    public Result<String> addCourse(@RequestBody @Validated CourseSaveDTO dto) {
        return courseService.addCourse(dto);
    }

    @PreAuthorize("hasAuthority('course:update')")
    @PostMapping("/update")
    public Result<String> updateCourse(@RequestBody @Validated CourseUpdateDTO dto) {
        return courseService.updateCourse(dto);
    }

    @PreAuthorize("hasAuthority('course:delete')")
    @PostMapping("/delete")
    public Result<String> deleteCourse(@RequestBody CourseIdDTO dto) {
        return courseService.deleteCourse(dto);
    }

    @PreAuthorize("hasAuthority('course:restore')")
    @PostMapping("/restore")
    public Result<String> restoreCourse(@RequestBody CourseIdDTO dto) {
        return courseService.restoreCourse(dto);
    }

    @PreAuthorize("hasAuthority('course:list')")
    @PostMapping("/detail")
    public Result<CourseListVO> getCourseById(@RequestBody CourseIdDTO dto) {
        return courseService.getCourseById(dto);
    }
}
