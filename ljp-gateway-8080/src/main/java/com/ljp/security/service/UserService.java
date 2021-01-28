package com.ljp.security.service;

import com.ljp.common.entity.Result;
import com.ljp.security.dto.UserDTO;

public interface UserService {

    Result addUserDTO(UserDTO userDTO);

    Result getUserDTO(Long id);

    Result deleteUserDTO(Long id);

}
