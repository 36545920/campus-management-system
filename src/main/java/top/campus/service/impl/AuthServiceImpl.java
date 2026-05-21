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

    /**
     * 登录验证，成功返回jwt令牌
     * @param loginDTO 前端登录数据
     * @return jwt令牌
     */
    @Override
    public LoginVO login(LoginDTO loginDTO) {
        SysUser sysUser = userMapper.selectUserByUsername(loginDTO.getUsername());
        if (sysUser == null) {
            throw  new RuntimeException("用户不存在");
        }

        if (!bCryptPasswordEncoder.matches(loginDTO.getPassword(), sysUser.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        String token = JwtUtils.createToken(sysUser.getId(), sysUser.getUsername());
        System.out.println(sysUser);
        Integer roleType = sysUser.getUserType();
        String role = "";
        if (roleType == 1) {
            role = "admin";
        }else if (roleType == 2) {
            role = "teacher";
        }else if (roleType == 3) {
            role = "student";
        }
        return new LoginVO(token,role);
    }
}
