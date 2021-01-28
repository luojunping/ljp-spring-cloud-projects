package com.ljp.blog.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/23
 * @since 1.0.0
 **/
@TableName(value = "t_blog")
@Data
public class BlogDTO {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String userId;
    private String catalog;
    private String blogName;
    private String blogContent;
    private Date createTime;
    private Date updateTime;

}
