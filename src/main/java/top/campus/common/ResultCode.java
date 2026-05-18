package top.campus.common;

public enum ResultCode {

    SUCCESS(200, "操作成功"),

    FAIL(500, "操作失败"),

    UNAUTHORIZED(401, "未登录"),

    FORBIDDEN(403, "无权限");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
