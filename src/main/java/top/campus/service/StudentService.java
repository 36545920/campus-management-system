package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.exception.BusinessException;
import top.campus.vo.StudentDetailedVO;
import top.campus.vo.StudentListVO;

public interface StudentService {

    Result<String> addStudent(StudentSaveDTO student);

    Result<String> updateStudent(StudentUpdateDTO student);

    Result<String> deleteStudent(StudentIdDTO sysUserIdDTO);

    Result<String> restoreStudent(StudentIdDTO dto);

    PageInfo<StudentListVO> getStudentList(StudentQueryDTO studentQueryDTO);

    Result<StudentDetailedVO> getStudentDetailed(StudentIdDTO dto);


    Result<String> updateStudentUserProfile(StudentUserProfileUpdateDTO studentUserProfileUpdateDTO) throws BusinessException;
}
