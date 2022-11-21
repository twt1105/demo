package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.UserDto;
import com.example.dto.UserPageDto;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author twt
 * @since 2022-11-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(UserDto userDto){
      User user = new User();
      user.setUserId(userDto.getUserId());
      user.setGender(userDto.getGender());
      user.setUsername(userDto.getUsername());
      user.setFavor(userDto.getFavor());
      user.setPassword(userDto.getPassword());
      user.setProfession(userDto.getProfession());
      this.save(user);
    }


    @Override
    public void deleteUserByName(String  username){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.lambda().eq(User::getUsername,username);
       userQueryWrapper.eq("username",username);
        remove(userQueryWrapper);

    }
    @Override
    public void deleteUserById(Integer   userId){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        1.第一种
//        userQueryWrapper.lambda().eq(User::getUsername,username);
//        2.第二种
        userQueryWrapper.eq("user_id",userId);
//        3.第三种
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getUserId,userId);
        remove(userQueryWrapper);

    }
    @Override
   public void updateUserByName(UserDto userDto){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,userDto.getUsername());

        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setGender(userDto.getGender());
        user.setUsername(userDto.getUsername());
        user.setFavor(userDto.getFavor());
        user.setPassword(userDto.getPassword());
        user.setProfession(userDto.getProfession());
        update(user,lambdaQueryWrapper);

//        //2.根据LambdaQueryWrapper修改用户信息
//        LambdaQueryWrapper<User> updateWrapper = new LambdaQueryWrapper<>();
//        updateWrapper.eq(User::getUsername,userDto.getUsername())
//                .set(User::getUsername,userDto.getUsername())
//                .set(User::getGender,userDto.getGender())
//                .set(User::getFavor,userDto.getFavor());
//        update(updateWrapper);
//        3.根据id修改用户信息
//        user.setUserId(5);
//        updateById(user);
    }

    @Override
    public User getUserById(Integer userId){
        return getById(userId);
    }

    @Override
    public List<User> getUserByNameAndId(String username, Integer userId){
       LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
       lambdaQueryWrapper.eq(User::getUsername,username).gt(User::getUserId,userId);
       List<User> user= list(lambdaQueryWrapper);
       return user;
    }

    /**
     * 根据用户名称模糊查询，根据性别查询
     *
     * @param userPageDto
     * @return
     */
    @Override
    public Page<User> getUserByPage(UserPageDto userPageDto) {
        Page<User> page = new Page<>();
        page.setCurrent(userPageDto.getCurrentPage());
        page.setSize(userPageDto.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(!StringUtils.isBlank(userPageDto.getUsername()), User::getUsername, userPageDto.getUsername())
                .eq(!StringUtils.isBlank(userPageDto.getGender()), User::getGender, userPageDto.getGender());
        Page<User> pageUser = page(page, lambdaQueryWrapper);
//        baseMapper.selectPage(page, lambdaQueryWrapper);
        return pageUser;
    }



//        @Override
//    public String getUserBySQL(Integer userId) {
//        String users = userMapper.getNameById(userId);
//        return users;
//    }
@Override
public List<UserDto> getUserBySQL(String username) {
    List<UserDto> users = userMapper.getUserDto(username);
    return users;
}

}
