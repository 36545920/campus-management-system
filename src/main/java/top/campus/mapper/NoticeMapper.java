package top.campus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.campus.dto.NoticeIdDTO;
import top.campus.dto.NoticeQueryDTO;
import top.campus.dto.NoticeSaveDTO;
import top.campus.dto.NoticeUpdateDTO;
import top.campus.vo.NoticeDetailedVO;
import top.campus.vo.NoticeListVO;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeListVO> selectNoticeList(NoticeQueryDTO queryDTO);

    @Insert("insert into notice(title, content, publisher, is_top) values (#{title}, #{content}, #{publisher}, #{isTop})")
    int addNotice(NoticeSaveDTO dto);

    int updateNotice(NoticeUpdateDTO dto);

    @Update("update notice set status = 0, update_time = NOW() where id = #{id}")
    int deleteNotice(NoticeIdDTO dto);

    @Update("update notice set status = 1, update_time = NOW() where id = #{id}")
    int restoreNotice(NoticeIdDTO dto);

    @Select("select * from notice where id = #{id}")
    NoticeDetailedVO selectNoticeById(NoticeIdDTO dto);
}
