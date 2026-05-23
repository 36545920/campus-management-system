package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.mapper.NoticeMapper;
import top.campus.service.NoticeService;
import top.campus.vo.NoticeDetailedVO;
import top.campus.vo.NoticeListVO;
import top.campus.utils.SecurityUtils;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public Result<PageInfo<NoticeListVO>> getNoticeList(NoticeQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<NoticeListVO> list = noticeMapper.selectNoticeList(queryDTO);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result<String> addNotice(NoticeSaveDTO dto) {
        try {
            dto.setPublisher(SecurityUtils.getCurrentUsername());
        } catch (Exception e) {
            return Result.fail("获取当前用户失败");
        }
        return noticeMapper.addNotice(dto) > 0 ? Result.success() : Result.fail("添加失败");
    }

    @Override
    public Result<String> updateNotice(NoticeUpdateDTO dto) {
        return noticeMapper.updateNotice(dto) > 0 ? Result.success() : Result.fail("更新失败");
    }

    @Override
    public Result<String> deleteNotice(NoticeIdDTO dto) {
        return noticeMapper.deleteNotice(dto) > 0 ? Result.success() : Result.fail("删除失败");
    }

    @Override
    public Result<String> restoreNotice(NoticeIdDTO dto) {
        return noticeMapper.restoreNotice(dto) > 0 ? Result.success() : Result.fail("恢复失败");
    }

    @Override
    public Result<NoticeDetailedVO> getNoticeById(NoticeIdDTO dto) {
        return Result.success(noticeMapper.selectNoticeById(dto));
    }
}
