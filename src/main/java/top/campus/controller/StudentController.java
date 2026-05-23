package top.campus.controller;


import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.exception.BusinessException;
import top.campus.service.StudentService;
import top.campus.vo.StudentDetailedVO;
import top.campus.vo.StudentListVO;



@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 按条件查找学生
     * @param studentQueryDTO 条件列表
     * @return 返回条件的学生列表
     */
    @PreAuthorize("hasAuthority('student:list')")
    @PostMapping("/list")
    public Result<PageInfo<StudentListVO>> getStudentList(@RequestBody @Validated StudentQueryDTO studentQueryDTO) {
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
     * 更新学生信息(管理员)
     * @param student 要更新的学生信息
     * @return 是否更新成功
     */
    @PreAuthorize("hasAuthority('student:update')")
    @PostMapping("/update")
    public Result<String> updateStudent(@RequestBody StudentUpdateDTO student) {
        return studentService.updateStudent(student);
    }

    /**
     * 请求删除学生
     * @param idDTO 要删除的学生ID
     * @return 是否删除成功
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
     * 更新当前用户为学生的个人信息
     * @param studentUserProfileUpdateDTO 要更新的个人信息
     * @return 是否更新成功
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/updateProfile")
    public Result<String> student(@RequestBody @Validated StudentUserProfileUpdateDTO studentUserProfileUpdateDTO) throws BusinessException {
        return studentService.updateStudentUserProfile(studentUserProfileUpdateDTO);
    }
}
