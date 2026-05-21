package top.campus.security.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.campus.entity.SysUser;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {


    private SysUser sysUser;

    private List<String> permissionList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (permissionList == null) {
            return Collections.emptyList();
        }
        //Spring Security 的权限校验机制只认 GrantedAuthority 接口，不认裸字符串。
        //你必须把角色/权限字符串包装成 GrantedAuthority 对象，框架才能用 hasRole()、hasAuthority() 等方法进行比对
        //把用户的权限字符串列表，转换成 Spring Security 所需的 GrantedAuthority 集合
        return permissionList.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return sysUser.getId();
    }
    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    // 账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //凭证（密码）是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否启用
    // 返回 true：账户启用。
    // 返回 false：账户禁用，抛出 DisabledException。
    @Override
    public boolean isEnabled() {
        return sysUser.getStatus() == 1 && sysUser.getIsDeleted() == 0;
    }
}
