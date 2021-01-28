package com.ljp.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljp.security.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO extends BaseMapper<UserDTO> {

}
