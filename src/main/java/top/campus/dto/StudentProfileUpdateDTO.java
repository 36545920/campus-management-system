package top.campus.dto;

import lombok.Data;

@Data
public class StudentProfileUpdateDTO {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 家庭住址
     */
    private String address;
}
