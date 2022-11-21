package com.example.dto;

import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="StudentInfoDto", description="学生信息")
public class StudentInfoDto {

    @ApiModelProperty(value = "学号")
    private String studentCode;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "学生年龄")
    private int age;

    @ApiModelProperty(value = "学生性别")
    private String sex;

    @ApiModelProperty(value = "学生住址")
    private String address;
}
