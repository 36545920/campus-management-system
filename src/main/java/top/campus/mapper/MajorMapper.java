package top.campus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.campus.dto.MajorIdDTO;
import top.campus.dto.MajorQueryDTO;
import top.campus.dto.MajorSaveDTO;
import top.campus.dto.MajorUpdateDTO;
import top.campus.vo.MajorListVO;

import java.util.List;

@Mapper
public interface MajorMapper {

    List<MajorListVO> selectMajorList(MajorQueryDTO queryDTO);

    @Insert("insert into major(major_name, major_code, remark, department_id) values (#{majorName}, #{majorCode}, #{remark}, #{departmentId})")
    int addMajor(MajorSaveDTO dto);

    int updateMajor(MajorUpdateDTO dto);

    @Update("update major set status = 0, update_time = NOW() where id = #{id}")
    int deleteMajor(MajorIdDTO dto);

    @Update("update major set status = 1, update_time = NOW() where id = #{id}")
    int restoreMajor(MajorIdDTO dto);

    @Select("""
            select
                m.id,
                m.major_name,
                m.major_code,
                m.remark,
                d.department_name,
                m.department_id,
                m.status,
                m.create_time
            from major m
            left join department d on m.department_id = d.id
            where m.id = #{id}
            """)
    MajorListVO selectMajorById(MajorIdDTO dto);
}
