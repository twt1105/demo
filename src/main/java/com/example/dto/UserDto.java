package com.example.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author tao511221
 */
@Data
public class UserDto {
    private Integer userId;

    private String username;

    private String password;

    private String gender;

    private String profession;

    private String favor;

    private String description;

    private Date createDate;

    private Date lastLoginTime;

    private String role;

    private Integer state;
}
