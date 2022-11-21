package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.UserDto;
import com.example.dto.UserPageDto;
import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *xxxxx
 *
 * xxxx
 * @author twt
 * @since 2022-11-10
 */
public interface UserService extends IService<User> {
    void addUser(UserDto userDto);



    void deleteUserByName(String  username);

    void deleteUserById(Integer userId);

    void updateUserByName(UserDto userDto);

    User getUserById(Integer userId);



    List<User> getUserByNameAndId(String username, Integer userId );

    Page<User> getUserByPage(UserPageDto userPageDto);

//    String getUserBySQL(Integer userId);
List<UserDto> getUserBySQL(String username);
}
