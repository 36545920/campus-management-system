package top.campus.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notice {
    /**
     * 公告ID
     */
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 发布人
     */
    private String publisher;

    /**
     * 是否置顶
     * 1 是
     * 0 否
     */
    private Integer isTop;

    /**
     * 状态
     * 1 正常
     * 0 下架
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
