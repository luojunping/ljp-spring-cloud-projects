package com.ljp.security.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")
public class UserDTO {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String nickname;
    private Date createTime;
    private Date updateTime;

    public UserDTO(String username, String email, String phoneNumber, String password, String nickname) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nickname = nickname;
    }

}
