package top.campus.controller;


import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.campus.common.Result;
import top.campus.dto.StudentIdDTO;
import top.campus.dto.StudentQueryDTO;
import top.campus.dto.StudentSaveDTO;
import top.campus.dto.UpdateStudentDTO;
import top.campus.service.StudentService;
import top.campus.vo.StudentDetailedVO;
import top.campus.vo.StudentListVO;



@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @PreAuthorize("hasAuthority('student:list')")
    @GetMapping("/list")
    public Result<PageInfo<StudentListVO>> getStudentList(@RequestBody StudentQueryDTO studentQueryDTO) {
        PageInfo<StudentListVO> list = studentService.getStudentList(studentQueryDTO);
        return Result.success(list);
    }

    /**
     * 添加学生
     * @param student 要添加学生的信息
     * @return 是否添加成功
     */
    @PreAuthorize("hasAuthority('student:add')")
    @PostMapping("/add")
    public Result<String> addStudent(@RequestBody StudentSaveDTO student) {
        return  studentService.addStudent(student);

    }

    /**
     * 更新学生信息
     * @param student 要更新的学生信息
     * @return 是否更新成功
     */
    @PreAuthorize("hasAuthority('student:update')")
    @PostMapping("/update")
    public Result<String> updateStudent(@RequestBody UpdateStudentDTO student) {
        return studentService.updateStudent(student);
    }

    /**
     * 停止学生的请求
     * @param idDTO 要停止的学生ID
     * @return 是否停止成功
     */
    @PreAuthorize("hasAuthority('student:delete')")
    @PostMapping("/delete")
    public Result<String> deleteStudent(@RequestBody StudentIdDTO idDTO) {
        return studentService.deleteStudent(idDTO);
    }

    /**
     * 恢复学生的请求
     * @param dto 要恢复的学生ID
     * @return 是否恢复成功
     */
    @PreAuthorize("hasAuthority('student:restore')")
    @PostMapping("/restore")
    public Result<String> restoreStudent(@RequestBody @Validated StudentIdDTO dto) {
        return studentService.restoreStudent(dto);
    }

    /**
     * 请求学生的详细信息
     * @param dto 学生ID
     * @return 学生的详细信息
     */
    @PreAuthorize("hasAuthority('student:detailed')")
    @PostMapping("/detailed")
    public Result<StudentDetailedVO> studentDetailed(@RequestBody @Validated StudentIdDTO dto) {
        return studentService.getStudentDetailed(dto);
    }

    /**
     * 请求学生的详细信息
     * @param dto 学生ID
     * @return 学生的详细信息
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/profile")
    public Result<StudentDetailedVO> student(@RequestBody @Validated StudentIdDTO dto) {
        return studentService.getUserDetailed(dto);
    }



}
