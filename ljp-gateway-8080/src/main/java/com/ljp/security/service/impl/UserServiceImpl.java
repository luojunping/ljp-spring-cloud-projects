package com.ljp.security.service.impl;

import com.ljp.common.entity.Result;
import com.ljp.common.util.ResultUtils;
import com.ljp.security.dao.UserDAO;
import com.ljp.security.dto.UserDTO;
import com.ljp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Result addUserDTO(UserDTO userDTO) {
        userDAO.insert(userDTO);
        if ("dadao".equals(userDTO.getUsername())) throw new RuntimeException("baocuole!!!!!!!!!!!");
        return ResultUtils.success();
    }

    @Override
    @Transactional(readOnly = true)
    public Result getUserDTO(Long id) {
        return ResultUtils.success(userDAO.selectById(id));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Result deleteUserDTO(Long id) {
        return ResultUtils.success(userDAO.deleteById(id));
    }

}
