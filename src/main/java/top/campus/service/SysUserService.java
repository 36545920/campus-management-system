package top.campus.service;

import com.github.pagehelper.PageInfo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.exception.BusinessException;
import top.campus.vo.UserListVO;

public interface SysUserService {
    
    Result<String> addSysUser(SysUserSaveDTO sysUserSaveDTO);

    Result<String> updateSysUserInfo(SysUserUpdateDTO sysUserUpdateDTO);

    Result<String> changeUserStatusByUserID(Long userID, int status);

    Result<String> deletedSysUserById(SysUserIdDTO dto);


    Result<String> restoreSysUser(SysUserIdDTO dto);

    Result<String> changeUserRole(@NotNull Long id, @NotNull @Min(1) @Max(3) Integer roleId);

    Result<PageInfo<UserListVO>> getUserList(UseQueryDTO useQueryDTO);

    Result<String> changePassword(ChangeMyPasswordDTO resetPasswordDTO) throws BusinessException;

    Result<String> resetPassword(ResetPasswordDTO dto) throws BusinessException;

    Result<String> updateProfile(ProfileUpdateDTO dto) throws BusinessException;
}
