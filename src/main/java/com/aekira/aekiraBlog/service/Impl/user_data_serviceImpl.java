package com.aekira.aekiraBlog.service.Impl;

import com.aekira.aekiraBlog.entity.user_data;

import com.aekira.aekiraBlog.pojo.user_data_gsid_pojo;
import com.aekira.aekiraBlog.mapper.user_data_mapper;
import com.aekira.aekiraBlog.pojo.user_data_pojo;
import com.aekira.aekiraBlog.service.user_data_service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class user_data_serviceImpl implements user_data_service {

    @Autowired
    private user_data_mapper user_data_mapper;


    @Override
    public List<user_data> findAll() {
        return user_data_mapper.findAll();
    }

    @Override
    public user_data getUsername(user_data_gsid_pojo user_data_gsid_pojo) {
        return user_data_mapper.findId(user_data_gsid_pojo);
    }

    @Override
    public void save(user_data_pojo user_data_pojo) {
        user_data_mapper.save(user_data_pojo);
    }

    @Override
    public Subject getSubject() {
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }

    @Override
    public UsernamePasswordToken getToken(user_data_pojo user_data_pojo) {
        UsernamePasswordToken token = new UsernamePasswordToken(user_data_pojo.getUsername(),user_data_pojo.getPassword());
        return token;
    }

}
