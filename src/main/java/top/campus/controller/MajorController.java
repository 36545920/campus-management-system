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
import top.campus.service.MajorService;
import top.campus.vo.MajorListVO;

@RestController
@RequestMapping("/major")
public class MajorController {

    @Resource
    private MajorService majorService;

    @PreAuthorize("hasAuthority('major:list')")
    @PostMapping("/list")
    public Result<PageInfo<MajorListVO>> getMajorList(@RequestBody @Validated MajorQueryDTO queryDTO) {
        return majorService.getMajorList(queryDTO);
    }

    @PreAuthorize("hasAuthority('major:add')")
    @PostMapping("/add")
    public Result<String> addMajor(@RequestBody @Validated MajorSaveDTO dto) {
        return majorService.addMajor(dto);
    }

    @PreAuthorize("hasAuthority('major:update')")
    @PostMapping("/update")
    public Result<String> updateMajor(@RequestBody @Validated MajorUpdateDTO dto) {
        return majorService.updateMajor(dto);
    }

    @PreAuthorize("hasAuthority('major:delete')")
    @PostMapping("/delete")
    public Result<String> deleteMajor(@RequestBody MajorIdDTO dto) {
        return majorService.deleteMajor(dto);
    }

    @PreAuthorize("hasAuthority('major:restore')")
    @PostMapping("/restore")
    public Result<String> restoreMajor(@RequestBody MajorIdDTO dto) {
        return majorService.restoreMajor(dto);
    }

    @PreAuthorize("hasAuthority('major:list')")
    @PostMapping("/detail")
    public Result<MajorListVO> getMajorById(@RequestBody MajorIdDTO dto) {
        return majorService.getMajorById(dto);
    }
}
