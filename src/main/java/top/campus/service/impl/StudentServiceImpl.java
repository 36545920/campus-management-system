package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.mapper.StudentMapper;
import top.campus.service.StudentService;
import top.campus.vo.StudentListVO;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public PageInfo<StudentListVO> getStudentlist(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentListVO> list = studentMapper.studentlist();
        return new  PageInfo<>(list);
    }
}
