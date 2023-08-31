package com.aekira.aekiraBlog.service;

import com.aekira.aekiraBlog.entity.user_data;
import com.aekira.aekiraBlog.pojo.user_data_gsid_pojo;
import com.aekira.aekiraBlog.pojo.user_data_pojo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import java.util.List;

public interface user_data_service {
     List<user_data> findAll();
     user_data getUsername(user_data_gsid_pojo user_data_gsid_pojo);
     void save(user_data_pojo user_data_pojo);
     Subject getSubject();
     UsernamePasswordToken getToken(user_data_pojo user_data_pojo);
}
