package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.StudentIdDTO;
import top.campus.dto.StudentQueryDTO;
import top.campus.dto.StudentSaveDTO;
import top.campus.dto.UpdateStudentDTO;
import top.campus.vo.StudentDetailedVO;
import top.campus.vo.StudentListVO;

import java.util.List;

public interface StudentService {

    Result<String> addStudent(StudentSaveDTO student);

    Result<String> updateStudent(UpdateStudentDTO student);

    Result<String> deleteStudent(StudentIdDTO sysUserIdDTO);

    Result<String> restoreStudent(StudentIdDTO dto);

    PageInfo<StudentListVO> getStudentList(StudentQueryDTO studentQueryDTO);

    Result<StudentDetailedVO> getStudentDetailed(StudentIdDTO dto);
}
