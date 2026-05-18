package top.campus.service;


import top.campus.dto.LoginDTO;
import top.campus.vo.LoginVO;

public interface AuthService {
    LoginVO login(LoginDTO loginDTO);
}
