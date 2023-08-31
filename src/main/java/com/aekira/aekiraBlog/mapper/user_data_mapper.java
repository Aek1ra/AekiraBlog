package com.aekira.aekiraBlog.mapper;

import com.aekira.aekiraBlog.entity.user_data;
import com.aekira.aekiraBlog.pojo.user_data_gsid_pojo;
import com.aekira.aekiraBlog.pojo.user_data_pojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface user_data_mapper {
    List<user_data> findAll();

    user_data findId(@Param("user_data_gsid_pojo") user_data_gsid_pojo user_data_gsid_pojo);

    void save(@Param("user_data_pojo") user_data_pojo user_data_pojo);
}

