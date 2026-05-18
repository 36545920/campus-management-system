package top.campus.service.impl;


import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.campus.dto.LoginDTO;
import top.campus.entity.SysUser;
import top.campus.mapper.UserMapper;
import top.campus.service.AuthService;
import top.campus.security.utils.JwtUtils;
import top.campus.vo.LoginVO;

@Service
public class  AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        SysUser sysUser = userMapper.selectByUsername(loginDTO.getUsername());
        if (sysUser == null) {
            throw  new RuntimeException("用户不存在");
        }

        if (!bCryptPasswordEncoder.matches(loginDTO.getPassword(), sysUser.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        String token = JwtUtils.createToken(sysUser.getId(), sysUser.getUsername());
        return new LoginVO(token);
    }
}
