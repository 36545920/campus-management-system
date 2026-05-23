package top.campus.service;

import com.github.pagehelper.PageInfo;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.vo.NoticeDetailedVO;
import top.campus.vo.NoticeListVO;

public interface NoticeService {
    Result<PageInfo<NoticeListVO>> getNoticeList(NoticeQueryDTO queryDTO);
    Result<String> addNotice(NoticeSaveDTO dto);
    Result<String> updateNotice(NoticeUpdateDTO dto);
    Result<String> deleteNotice(NoticeIdDTO dto);
    Result<String> restoreNotice(NoticeIdDTO dto);
    Result<NoticeDetailedVO> getNoticeById(NoticeIdDTO dto);
}
