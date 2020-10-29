package com.demo.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.demo.modules.sys.entity.Account;
import com.demo.modules.sys.entity.AccountField;
import com.demo.modules.sys.service.AccountService;
import com.demo.platform.common.annotation.SysLog;
import com.demo.platform.common.enums.ResultEnum;
import com.demo.platform.common.global.ResponeData;
import com.demo.platform.common.utils.JwtUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.demo.platform.common.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/admin/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    @LoginRequired
    @SysLog(title = "账户分页查询")
    public ResponeData<PageInfo> findPage( @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        Account account = new Account();
        account.setAccountId(accountField.getAccountId());
        account.setAccountNo(accountField.getAccountNo());
        account.setPassword(accountField.getPassword());
        PageHelper.startPage(accountField.getPageNo(), accountField.getPageSize());
        List<Account> list = accountService.findList(account);
        PageInfo<Account> pageInfo = new PageInfo<Account>(list,5);
        return new ResponeData<>(ResultEnum.SUCCESS, pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponeData<String> login(@Valid @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        Account account = new Account();
        account.setAccountId(accountField.getAccountId());
        account.setAccountNo(accountField.getAccountNo());
        account.setPassword(accountField.getPassword());
        Account login = accountService.login(account);
        if (login!=null){
            //计算token
            String token = JwtUtil.signToken(login.getAccountId(), JSON.toJSONString(login), JwtUtil.EXPIRE_TIME);
            return new ResponeData<>(ResultEnum.SUCCESS,token);
        }else{
            return new ResponeData<>(ResultEnum.LOGIN_FAILED,"用户名或密码错误！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "getAccount",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<String> getAccountByToken(HttpServletRequest request) {
        Claims claims = JwtUtil.parseToken(request.getHeader("token"));
        String subject = claims.getSubject();
        Account login = accountService.login(new Account());
        return new ResponeData<>(ResultEnum.SUCCESS,subject);
    }

}
