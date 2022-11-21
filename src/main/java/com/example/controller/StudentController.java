package com.example.controller;

import com.example.conf.ListConfig;
import com.example.conf.User;
import com.example.dto.StudentInfoDto;
import com.example.service.StudentService;
import io.swagger.annotations.*;
import com.example.utils.MySQLConnectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Api(value = "StudentController", tags = "学生信息")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Value("${name.value}")
    private String name;

    @Value("#{${friends}}")
    private Map<Object,Object> friends;

    @Value("${pets}")
    private List<String> pets;
    @Autowired
    private User user;
    @Autowired
    private MySQLConnectUtils mySQLConnectUtils;

    @ApiOperation("/getValue")
    @GetMapping("/getValue")
    public User getValue(){
        System.out.println(user);
        return user;
    }

    @Autowired
    private ListConfig listConfig;


//
    @GetMapping("/testMysql")
    public void testMysql() {
        mySQLConnectUtils.getConnect();
    }


    @ApiOperation(value = "获取学生信息", notes = "获取学生信息")
    public StudentInfoDto getStudentInfo() {
        return studentService.getStudentInfo();
    }

    @ApiOperation(value = "根据学生名称获取学生信息", notes = "根据学生名称获取学生信息")
    @GetMapping("/getStudentInfoByName")
    public StudentInfoDto getStudentInfo(@RequestParam @ApiParam("学生名称") String name) {
        return studentService.getStudentInfo(name);
    }

    @ApiOperation(value = "根据学生名称和学号获取学生信息", notes = "根据学生名称获取学生信息")
    @GetMapping("/getStudentInfoByNameAndCode")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "String", name = "name", value = "学生姓名"),
            @ApiImplicitParam(paramType = "String", name = "studentCode", value = "学号", required = true)
    })
    @ApiResponses({
            @ApiResponse(response = StudentInfoDto.class, message = "成功", code = 200),
            @ApiResponse(response = String.class, message = "失败", code = 500)
    })
    public StudentInfoDto getStudentInfo(@RequestParam String name, @RequestParam String studentCode) {
        return studentService.getStudentInfo(name, studentCode);
    }

    @ApiOperation(value = "根据学生信息称获取学生信息", notes = "根据学生信息称获取学生信息")
    @PostMapping("/getStudentInfoByInfo")
    public StudentInfoDto getStudentInfo(@RequestBody @Validated StudentInfoDto studentInfoDto) {
        return studentService.getStudentInfo(studentInfoDto);
    }

}
