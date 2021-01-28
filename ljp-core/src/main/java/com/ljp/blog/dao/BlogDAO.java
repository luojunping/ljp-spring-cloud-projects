package com.ljp.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljp.blog.dto.BlogDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/23
 * @since 1.0.0
 **/
@Mapper
public interface BlogDAO extends BaseMapper<BlogDTO> {


}
