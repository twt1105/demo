package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.UserDto;
import com.example.dto.UserPageDto;
import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author twt
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 新增用户信息
     *
     * @param userDto
     */
    @PostMapping("adduser")
    public void addUser(@RequestBody UserDto userDto){
         userService.addUser(userDto);
    }
    /**
     * 删除用户信息
     *
     * @param username
     */
    @PostMapping("deleteUserByName")
    public  void deleteUserByName(String  username){
        userService.deleteUserByName(username);
    }
    @PostMapping("deleteUserById")
    public  void deleteUserById(Integer  userId){
        userService.deleteUserById(userId);
    }
    /**
     * 根据名称修改用户信息
     *
     * @param userDto
     */
    @PostMapping("updateUserByName")
    public void updateUserByName(@RequestBody UserDto userDto){
        userService.updateUserByName(userDto);

    }

    /**
     * 根据id获取用户信息
     *
     * @param userId
     * @return
     */
    @PostMapping("getUserById")
    public User getUserById(Integer  userId){return userService.getUserById(userId);}


    /**
     * 根据名称和年龄列表查询
     *
     * @param username
     * @param userId
     * @return
     */
    @PostMapping("getUserByNameAndId")
    public List<User> getUserByNameAndId(String username, Integer  userId){return userService.getUserByNameAndId(username,userId);}


//    @GetMapping("/getUserBySQL")
//    public String getUserBySQL(@RequestParam Integer userId) {
//        return userService.getUserBySQL(userId);
//    }

    @GetMapping("/getUserBySQL")
    public List<UserDto> getUserBySQL(@RequestParam String username) {
        return userService.getUserBySQL(username);
    }

    /**
     * 根据名称和年龄分页查询
     *
     * @param userPageDto
     * @return
     */
    @ApiOperation(value = "根据名称和性别分页查询")
    @PostMapping("/getUserByPage")
    public Page<User> getUserByPage(@RequestBody UserPageDto userPageDto) {
        return userService.getUserByPage(userPageDto);
    }


}

