package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.StudentSaveDTO;
import top.campus.vo.StudentListVO;

public interface StudentService {
    PageInfo<StudentListVO> getStudentList(int pageNum, int pageSize);

    Result<String> addStudent(StudentSaveDTO student);
}
