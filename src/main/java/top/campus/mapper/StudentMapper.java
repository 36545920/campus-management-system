package top.campus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.campus.vo.StudentListVO;


import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("""
select campus_management.student.id,
       campus_management.student.student_no,
       campus_management.student.name,
       case when campus_management.student.gender = 1 then '男' else '女' end as genderName,
       campus_management.student.phone,
       campus_management.student.avatar,
       campus_management.class_info.class_name,
       campus_management.student.status,
       campus_management.major.major_name
from campus_management.student
left join campus_management.class_info on class_info.id = student.class_id
left join campus_management.major on major.id = class_info.major_id
""")
    List<StudentListVO> studentlist();
}
