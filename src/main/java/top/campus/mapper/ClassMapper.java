package top.campus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.campus.dto.ClassIdDTO;
import top.campus.dto.ClassQueryDTO;
import top.campus.dto.ClassSaveDTO;
import top.campus.dto.ClassUpdateDTO;
import top.campus.vo.ClassListVO;

import java.util.List;

@Mapper
public interface ClassMapper {

    List<ClassListVO> selectClassList(ClassQueryDTO queryDTO);

    @Insert("insert into class_info(major_id, class_name, head_teacher_id, remark) values (#{majorId}, #{className}, #{headTeacherId}, #{remark})")
    int addClass(ClassSaveDTO dto);

    int updateClass(ClassUpdateDTO dto);

    @Update("update class_info set status = 0, update_time = NOW() where id = #{id}")
    int deleteClass(ClassIdDTO dto);

    @Update("update class_info set status = 1, update_time = NOW() where id = #{id}")
    int restoreClass(ClassIdDTO dto);

    @Select("""
            select
                ci.id,
                ci.class_name,
                m.major_name,
                t.name as head_teacher_name,
                ci.student_count,
                ci.remark,
                ci.status
            from class_info ci
            left join major m on ci.major_id = m.id
            left join teacher t on ci.head_teacher_id = t.id
            where ci.id = #{id}
            """)
    ClassListVO selectClassById(ClassIdDTO dto);
}
