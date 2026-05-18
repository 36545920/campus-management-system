package top.campus.controller;


import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.campus.entity.Student;
import top.campus.service.StudentService;
import top.campus.vo.StudentListVO;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/list")
    public PageInfo<StudentListVO> getStudentList(@RequestParam(defaultValue = "1") int pageNum,
                                                   @RequestParam(defaultValue = "10") int pageSize){
        return studentService.getStudentlist(pageNum,pageSize);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){return null;}

}
