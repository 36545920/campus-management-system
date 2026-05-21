package top.campus.controller;


import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.campus.common.Result;
import top.campus.dto.StudentSaveDTO;
import top.campus.service.StudentService;
import top.campus.vo.StudentListVO;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @PreAuthorize("hasAuthority('student:list')")
    @GetMapping("/list")
    public Result<PageInfo<StudentListVO>> getStudentList(@RequestParam(defaultValue = "1") int pageNum,
                                                          @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo<StudentListVO> list = studentService.getStudentList(pageNum, pageSize);
        return Result.success(list);
    }

    @PreAuthorize("hasAuthority('student:add')")
    @PostMapping("/add")
    public Result<String> addStudent(@RequestBody StudentSaveDTO student) {
        return  studentService.addStudent(student);

    }

    @PreAuthorize("hasAuthority('student:update')")
    @PostMapping("/update")
    public Result<String> updateStudent(@RequestBody StudentSaveDTO student) {
        return Result.success();
    }

}
