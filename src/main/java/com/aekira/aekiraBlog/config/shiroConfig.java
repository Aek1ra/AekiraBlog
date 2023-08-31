package com.aekira.aekiraBlog.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class shiroConfig {

    //创建realm自定义对象
    @Bean
    public userRealm userRealm(){
        return new userRealm();
    }

    //提供默认Web安全管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(userRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //配置默认Web安全管理器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加Shiro内置过滤器
        /*
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/common/login","anon");
        filterMap.put("/common/findAll","anon");
        filterMap.put("/**","authc");


        //设置默认登录页面
        bean.setLoginUrl("/login");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }
}
