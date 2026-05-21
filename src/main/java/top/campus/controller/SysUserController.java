package top.campus.controller;


import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.campus.common.Result;
import top.campus.dto.*;

import top.campus.exception.BusinessException;
import top.campus.service.SysUserService;
import top.campus.vo.UserListVO;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    /**
     * 根据条件查找用户
     * @param useQueryDTO 条件
     * @return 符合条件的用户列表
     */
    @PreAuthorize("hasAuthority('user:list')")
    @PostMapping("/list")
    public Result<PageInfo<UserListVO>> getUserList(@RequestBody UseQueryDTO useQueryDTO) {
        return sysUserService.getUserList(useQueryDTO);
    }  // null-全部, true-已删, false-正常

    /**
     * 新增用户请求
     * @param sysUserSaveDTO 新增用户数据
     * @return 是否添加成功
     */
    @PreAuthorize("hasAuthority('user:add')")
    @PostMapping("/add")
    public Result<String> addSysUser(@RequestBody SysUserSaveDTO sysUserSaveDTO) {
        return sysUserService.addSysUser(sysUserSaveDTO);
    }

    /**
     * 更新用户信息
     * @param sysUserUpdateDTO 要更新的信息
     * @return 更新是否成功
     */
    @PreAuthorize("hasAuthority('user:update')")
    @PostMapping("/update")
    public Result<String> updateSysUser(@RequestBody SysUserUpdateDTO sysUserUpdateDTO) {

        return sysUserService.updateSysUserInfo(sysUserUpdateDTO);
    }

    /**
     * 禁用用户
     * @param dto 禁用的用户ID
     * @return 是否禁用成功
     */
    @PreAuthorize("hasAuthority('user:disable')")
    @PostMapping("/disable")
    public Result<String> disableUser(@RequestBody @Validated SysUserIdDTO dto) {
        return sysUserService.changeUserStatusByUserID(dto.getId(),0); // 假设 0 为禁用
    }

    /**
     * 启用用户
     * @param dto 启用的用户ID
     * @return 是否启用成功
     */
    @PreAuthorize("hasAuthority('user:activate')")
    @PostMapping("/activate")
    public Result<String> activateUser(@RequestBody @Validated SysUserIdDTO dto) {
        return sysUserService.changeUserStatusByUserID(dto.getId(),1); // 假设 1 为启用
    }

    /**
     * 删除用户
     * @param dto 要删除的用户ID
     * @return 是否删除成功
     */
    @PreAuthorize("hasAuthority('user:delete')")
    @PostMapping("/delete")
    public Result<String> deleteUser(@RequestBody @Validated SysUserIdDTO dto) {
        return sysUserService.deletedSysUserById(dto);
    }

    /**
     * 恢复用户
     * @param dto 要恢复的用户ID
     * @return 是否恢复成功
     */
    @PreAuthorize("hasAuthority('user:restore')")
    @PostMapping("/restore")
    public Result<String> restoreUser(@RequestBody @Validated SysUserIdDTO dto) {
        return sysUserService.restoreSysUser(dto);
    }

    /**
     * 修改用户角色
     * @param dto 要修改的用户ID和要修改成的角色
     * @return 是否修改成功
     */
    @PreAuthorize("hasAuthority('user:changeRole')")
    @PostMapping("/changeRole")
    public Result<String> changeRole(@RequestBody @Validated ChangeRoleDTO dto) {
        return sysUserService.changeUserRole(dto.getId(), dto.getRoleId());
    }


    @PreAuthorize("hasAuthority('user:changePassword')")
    @PostMapping("/changePassword")
    public Result<String> changePassword(@RequestBody @Validated ChangeMyPasswordDTO dto) throws BusinessException {
        return sysUserService.changePassword(dto);
    }

    @PreAuthorize("hasAuthority('user:resetPassword')")
    @PostMapping("/resetPassword")
    public Result<String> resetPassword(@RequestBody @Validated ResetPasswordDTO dto) throws BusinessException {
        return sysUserService.resetPassword(dto);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/profile")
    public Result<String> updateProfile(@RequestBody @Validated ProfileUpdateDTO dto) throws BusinessException {
        return sysUserService.updateProfile(dto);
    }

}
