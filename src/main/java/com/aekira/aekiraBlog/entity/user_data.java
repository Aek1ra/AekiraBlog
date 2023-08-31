package com.aekira.aekiraBlog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户数据表")
public class user_data{
    @ApiModelProperty(value = "用户账号")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "id序号")
    private Integer id;
//    @ApiModelProperty(value = "昵称")
//    private String nickname;
}
