package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.StudentSaveDTO;
import top.campus.entity.Student;
import top.campus.mapper.StudentMapper;
import top.campus.service.StudentService;
import top.campus.vo.StudentListVO;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public PageInfo<StudentListVO> getStudentList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentListVO> list = studentMapper.studentlist();
        return new PageInfo<>(list);
    }

    @Override
    public Result<String> addStudent(StudentSaveDTO student) {
        Student student1 = studentMapper.findStudentByStudentNo(student.getStudentNo());
        if(student1 != null){
            return Result.build(409,"用户已存在");
        }
        studentMapper.addStudent(student);
        return Result.success();
    }

    @Override
    public Result<String> updateStudent(StudentSaveDTO student) {
        return studentMapper.updateStudent(student) > 0 ? Result.success():Result.fail("更新失败");
    }
}
