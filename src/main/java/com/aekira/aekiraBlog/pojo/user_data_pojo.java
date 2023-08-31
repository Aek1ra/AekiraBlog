package com.aekira.aekiraBlog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "注册所填写的账号密码")
public class user_data_pojo {
    @ApiModelProperty(value = "用户账号")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;
}
