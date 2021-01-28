package com.ljp.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ljp.blog.dao.BlogDAO;
import com.ljp.blog.dto.BlogDTO;
import com.ljp.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/23
 * @since 1.0.0
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogDAO;

    @Transactional(readOnly = true)
    @Override
    public List<BlogDTO> getBlogDTO(String blogName) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setBlogName(blogName);
        List<BlogDTO> blogDTOList = blogDAO.selectList(Wrappers.query(blogDTO));
        return blogDTOList;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public BlogDTO addBlogDTO(BlogDTO blogDTO) {
        blogDAO.insert(blogDTO);
        return blogDTO;
    }

}
