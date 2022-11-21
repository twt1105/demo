package com.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UserPageDto", description = "用户分页查询参数")
public class UserPageDto {


    @ApiModelProperty(value = "当前页", required = true)
    private Integer currentPage;

    @ApiModelProperty(value = "分页大小", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "用户名称", required = false)
    private String username;

    @ApiModelProperty(value = "用户性别")
    private String gender;
}