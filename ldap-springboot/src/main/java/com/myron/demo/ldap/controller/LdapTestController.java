package com.myron.demo.ldap.controller;

import com.myron.demo.ldap.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linrx1 on 2019/10/9.
 */
@Controller
@RequestMapping("/")
public class LdapTestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LdapTestController.class);
    @Autowired
    private LdapTemplate ldapTemplate;

    @ApiOperation("测试ad账号")
    @RequestMapping(value = "/testUser", method = RequestMethod.POST)
//    @ApiImplicitParam(name = "password", value = "用户ID", required = true,paramType = "form" )
    @ResponseBody
    public String testUser(String username, String password) {
        LdapQuery query = LdapQueryBuilder.query()
                .where("sAMAccountName").is(username);
        Long start = System.currentTimeMillis();
        LOGGER.info("开始登入验证:{}", username);
        this.ldapTemplate.authenticate(query, password);
        Long end = System.currentTimeMillis();
        Long count1 = end - start;
        LOGGER.info("结束登入验证 用时:" + count1);
        final User user = this.ldapTemplate.findOne(query, User.class);
        Long count2 = System.currentTimeMillis() - end;
        LOGGER.info("结束用户查询 用时:{}" , count2);
        LOGGER.info(user.toString());
        return "用户鉴权用时:" + count1 + "\n查询用户用时:" + count2+"\n信息内容:" + user.toString();
    }
}
