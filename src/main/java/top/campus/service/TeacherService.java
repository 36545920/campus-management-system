package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.TeacherQueryDTO;
import top.campus.dto.TeacherSaveDTO;
import top.campus.vo.TeacherListVO;

public interface TeacherService {
    Result<PageInfo<TeacherListVO>> getTeacherListQuery(TeacherQueryDTO teacherQueryDTO);

    Result<String> addTeacher(TeacherSaveDTO teacherSaveDTO);
}
