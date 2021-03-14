package com.ljp.blog.controller;

import com.ljp.blog.dto.BlogDTO;
import com.ljp.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/23
 * @since 1.0.0
 **/
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/getBlogDTO")
    public List<BlogDTO> getBlogDTO(@RequestParam("blogName") String blogName) {
        return blogService.getBlogDTO(blogName);
    }

    @PostMapping("/blog/addBlogDTO")
    public int addBlogDTO(@RequestBody BlogDTO blogDTO) {
        return blogService.addBlogDTO(blogDTO);
    }

    @PutMapping("/blog/updateBlogDTO")
    public int updateBlogDTO(@RequestBody BlogDTO blogDTO) {
        return blogService.updateBlogDTO(blogDTO);
    }

    @DeleteMapping("/blog/deleteBlogDTO")
    public int deleteBlogDTO(@RequestParam("id") Long id) {
        return blogService.deleteBlogDTO(id);
    }

}
