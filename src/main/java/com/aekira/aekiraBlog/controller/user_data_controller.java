package com.aekira.aekiraBlog.controller;

import com.aekira.aekiraBlog.entity.user_data;
import com.aekira.aekiraBlog.pojo.user_data_gsid_pojo;
import com.aekira.aekiraBlog.pojo.user_data_pojo;
import com.aekira.aekiraBlog.service.Impl.user_data_serviceImpl;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.aekira.aekiraBlog.common.user_code.CODE_SUCCESS;

@RestController
@RequestMapping("/common")
public class user_data_controller {
    @Autowired
    private user_data_serviceImpl user_data_serviceImpl;

    @RequestMapping("/findAll")
    public List<user_data> getAll(){
        return user_data_serviceImpl.findAll();
    }

    @PostMapping ("/findID")
    public user_data getUsername(@RequestBody user_data_gsid_pojo user_data_gsid_pojo){
        return user_data_serviceImpl.getUsername(user_data_gsid_pojo);
    }

    @PostMapping("/save")
    public Integer save(@RequestBody user_data_pojo user_data_pojo){
        user_data_serviceImpl.save(user_data_pojo);
        return CODE_SUCCESS;
    }

    @PostMapping ("/login")
    public String login(@RequestBody user_data_pojo user_data_pojo){
        try {
            user_data_serviceImpl.getSubject().login(user_data_serviceImpl.getToken(user_data_pojo));
            return "findAll";
        } catch (UnknownAccountException e) {
            System.out.println("用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "login";
        }
    }
}
