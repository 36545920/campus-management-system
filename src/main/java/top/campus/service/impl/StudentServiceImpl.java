package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.StudentIdDTO;
import top.campus.dto.StudentQueryDTO;
import top.campus.dto.StudentSaveDTO;
import top.campus.dto.UpdateStudentDTO;
import top.campus.entity.Student;
import top.campus.mapper.StudentMapper;
import top.campus.service.StudentService;
import top.campus.vo.StudentDetailedVO;
import top.campus.vo.StudentListVO;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public PageInfo<StudentListVO> getStudentList(StudentQueryDTO studentQueryDTO) {
        PageHelper.startPage(studentQueryDTO.getPageNum(),studentQueryDTO.getPageSize());
        List<StudentListVO> list = studentMapper.getStudentList(studentQueryDTO);
        return new PageInfo<>(list);
    }

    @Override
    public Result<StudentDetailedVO> getStudentDetailed(StudentIdDTO dto) {
        StudentDetailedVO studentDetailedVO = studentMapper.findStudentByStudentId(dto);
        return Result.success(studentDetailedVO);
    }

    @Override
    public Result<String> addStudent(StudentSaveDTO student) {
        Student student1 = studentMapper.findStudentByStudentNo(student.getStudentNo());
        if(student1 != null){
            return Result.build(409,"用户已存在");
        }

        return studentMapper.addStudent(student) > 0 ? Result.success():Result.fail("添加失败");
    }

    @Override
    public Result<String> updateStudent(UpdateStudentDTO student) {
        return studentMapper.updateStudent(student) > 0 ? Result.success():Result.fail("更新失败");
    }

    @Override
    public Result<String> deleteStudent(StudentIdDTO idDTO) {
        return studentMapper.deleteStudent(idDTO) > 0 ? Result.success():Result.fail("删除失败");
    }

    @Override
    public Result<String> restoreStudent(StudentIdDTO dto) {
        return studentMapper.restoreStudent(dto) > 0 ? Result.success():Result.fail("恢复失败");
    }
}
