package com.aekira.aekiraBlog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "通过这个id来获取username或password")
public class user_data_gsid_pojo {
    @ApiModelProperty(value = "id值")
    private Integer id;
}
