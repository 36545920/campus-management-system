package top.campus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.campus.dto.DepartmentIdDTO;
import top.campus.dto.DepartmentQueryDTO;
import top.campus.dto.DepartmentSaveDTO;
import top.campus.dto.DepartmentUpdateDTO;
import top.campus.vo.DepartmentListVO;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    List<DepartmentListVO> selectDepartmentList(DepartmentQueryDTO queryDTO);

    @Insert("insert into department(department_name, remark) values (#{departmentName}, #{remark})")
    int addDepartment(DepartmentSaveDTO dto);

    int updateDepartment(DepartmentUpdateDTO dto);

    @Update("update department set status = 0, update_time = NOW() where id = #{id}")
    int deleteDepartment(DepartmentIdDTO dto);

    @Update("update department set status = 1, update_time = NOW() where id = #{id}")
    int restoreDepartment(DepartmentIdDTO dto);

    @Select("select * from department where id = #{id}")
    DepartmentListVO selectDepartmentById(DepartmentIdDTO dto);
}
