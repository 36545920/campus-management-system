package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.vo.StudentListVO;

public interface StudentService {
    PageInfo<StudentListVO> getStudentlist(int pageNum, int pageSize);
}
