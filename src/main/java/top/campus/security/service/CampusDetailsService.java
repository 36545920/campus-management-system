package top.campus.security;

import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.campus.entity.SysUser;
import top.campus.mapper.PermissionMapper;
import top.campus.mapper.UserMapper;

import java.util.List;

@Service
public class CampusDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userMapper.selectByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException(username + " not found");
        }
        List<String> permissions = permissionMapper.selectPermissionByUsername(username);
        System.out.println(permissions);
        return new LoginUser(sysUser, permissions);
    }
}
