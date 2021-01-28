package com.ljp.blog.service;

import com.ljp.blog.dto.BlogDTO;

import java.util.List;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/23
 * @since 1.0.0
 **/
public interface BlogService {

    List<BlogDTO> getBlogDTO(String blogName);

    BlogDTO addBlogDTO(BlogDTO blogDTO);

}
