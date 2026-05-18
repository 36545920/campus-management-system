package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperationLog {
    /**
     * 日志ID
     */
    private Integer id;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作类型
     */
    private String operationType;

    /**
     * 请求方法(java)
     */
    private String method;

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 请求类型
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回结果
     */
    private String requestResult;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;
}
