package top.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import top.campus.common.Result;
import top.campus.dto.*;
import top.campus.entity.SysUser;
import top.campus.exception.BusinessException;
import top.campus.mapper.UserMapper;
import top.campus.service.SysUserService;
import top.campus.utils.SecurityUtils;
import top.campus.vo.UserListVO;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;




    @Override
    public Result<String> addSysUser(SysUserSaveDTO sysUserSaveDTO) {
        SysUser sysUser = userMapper.selectUserByUsername(sysUserSaveDTO.getUsername());
        if (sysUser != null) {
            return Result.build(409,"用户已存在");
        }
        String defaultPassword = passwordEncoder.encode("123456");
        sysUserSaveDTO.setPassword(defaultPassword);
        userMapper.addSysUser(sysUserSaveDTO);
        return Result.success();
    }

    @Override
    public Result<String> updateSysUserInfo(SysUserUpdateDTO sysUserUpdateDTO) {
        int i = userMapper.updateSysUser(sysUserUpdateDTO);
        if (i > 0) {
            return Result.success();
        }else {
            return Result.fail("更新失败");
        }
    }

    @Override
    public Result<String> changeUserStatusByUserID(Long userID, int status) {
        int i = userMapper.changeUserStatusByUserID(userID,status);
        if (i > 0) {
            return Result.success();
        }else {
            return Result.fail("更新失败");
        }
    }

    @Override
    public Result<String> deletedSysUserById(SysUserIdDTO dto) {
        int i = userMapper.deleteSysUserById(dto);
        if (i > 0) {
            return Result.success();
        }else {
            return Result.fail("删除失败");
        }

    }

    @Override
    public Result<String> restoreSysUser(SysUserIdDTO dto) {
        int i = userMapper.restoreSysUser(dto);
        if (i > 0) {
            return Result.success();
        }else {
            return Result.fail("恢复失败");
        }
    }

    @Override
    public Result<String> changeUserRole(Long id, Integer roleId) {
        int i = userMapper.changeUserRole(id, roleId);
        if (i > 0) {
            return Result.success();
        }else {
            return Result.fail("恢复失败");
        }

    }

    @Override
    public Result<PageInfo<UserListVO>> getUserList(UseQueryDTO useQueryDTO) {
        PageHelper.startPage(useQueryDTO.getPageNum(), useQueryDTO.getPageSize());
        List<UserListVO> list = userMapper.getUserList(useQueryDTO);
        return Result.success(new PageInfo<>(list));
    }

    @Override
    public Result<String> changePassword(ChangeMyPasswordDTO changeMyPasswordDTO) throws BusinessException {

        if (!changeMyPasswordDTO.getNewPassword().equals(changeMyPasswordDTO.getConfirmPassword())) {
            return Result.build(422,"两次输入的密码不一致");
        }
        String newPassword = changeMyPasswordDTO.getNewPassword();
        if (newPassword.length() < 8 || !newPassword.matches("^(?=.*[A-Za-z])(?=.*\\d).+$")) {
            return Result.build(422,"密码必须至少8位，且包含字母和数字");
        }

        SysUser sysUser = userMapper.selectUserById(SecurityUtils.getCurrentUserId());
        if (sysUser == null) {
            return Result.build(404,"用户不存在");
        }
        if (sysUser.getIsDeleted() == 1){
            return Result.build(422,"该用户已被删除");
        }
        if (!passwordEncoder.matches(changeMyPasswordDTO.getOldPassword(), sysUser.getPassword())) {
            return Result.build(422, "旧密码错误");
        }
        String encodePassword = passwordEncoder.encode(newPassword);
        sysUser.setPassword(encodePassword);
        return userMapper.changePassword(sysUser) > 0 ? Result.success() : Result.fail("更新失败");
    }

    @Override
    public Result<String> resetPassword(ResetPasswordDTO dto) throws BusinessException {
        SysUser resetUser = userMapper.selectUserById(dto.getUserId());
        if (resetUser == null) {
            return Result.build(404,"用户不存在");
        }
        if (resetUser.getIsDeleted() == 1){
            return Result.build(422,"该用户已被删除");
        }
        SysUser sysUser = userMapper.selectUserById(SecurityUtils.getCurrentUserId());
        if(dto.getPassword().equals(sysUser.getPassword())){
            return Result.build(422,"密码错误");
        }
        String encodePassword = passwordEncoder.encode("123456");
        resetUser.setPassword(encodePassword);
        return userMapper.changePassword(resetUser) > 0 ? Result.success() : Result.fail("更新失败") ;
    }

    @Override
    public Result<String> updateProfile(ProfileUpdateDTO dto) throws BusinessException {
        SysUserUpdateDTO sysUserUpdateDTO = new SysUserUpdateDTO();
        BeanUtils.copyProperties(dto,sysUserUpdateDTO);
        sysUserUpdateDTO.setId(SecurityUtils.getCurrentUserId());
        return userMapper.updateSysUser(sysUserUpdateDTO) > 1 ? Result.success() : Result.fail("更新失败");
    }

}
