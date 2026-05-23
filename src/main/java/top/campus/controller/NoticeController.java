package top.campus.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.service.NoticeService;
import top.campus.vo.NoticeDetailedVO;
import top.campus.vo.NoticeListVO;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @PreAuthorize("hasAuthority('notice:list')")
    @PostMapping("/list")
    public Result<PageInfo<NoticeListVO>> getNoticeList(@RequestBody @Validated NoticeQueryDTO queryDTO) {
        return noticeService.getNoticeList(queryDTO);
    }

    @PreAuthorize("hasAuthority('notice:add')")
    @PostMapping("/add")
    public Result<String> addNotice(@RequestBody @Validated NoticeSaveDTO dto) {
        return noticeService.addNotice(dto);
    }

    @PreAuthorize("hasAuthority('notice:update')")
    @PostMapping("/update")
    public Result<String> updateNotice(@RequestBody @Validated NoticeUpdateDTO dto) {
        return noticeService.updateNotice(dto);
    }

    @PreAuthorize("hasAuthority('notice:delete')")
    @PostMapping("/delete")
    public Result<String> deleteNotice(@RequestBody NoticeIdDTO dto) {
        return noticeService.deleteNotice(dto);
    }

    @PreAuthorize("hasAuthority('notice:restore')")
    @PostMapping("/restore")
    public Result<String> restoreNotice(@RequestBody NoticeIdDTO dto) {
        return noticeService.restoreNotice(dto);
    }

    @PreAuthorize("hasAuthority('notice:list')")
    @PostMapping("/detail")
    public Result<NoticeDetailedVO> getNoticeById(@RequestBody NoticeIdDTO dto) {
        return noticeService.getNoticeById(dto);
    }
}
