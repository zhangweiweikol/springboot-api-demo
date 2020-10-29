package com.demo.modules.sys.service.impl;

import com.demo.modules.sys.dao.AccountDao;
import com.demo.modules.sys.entity.Account;
import com.demo.modules.sys.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public Account login(Account account) {
        return accountDao.selectOne(account);
    }

    @Override
    public List<Account> findList(Account account) {
        return accountDao.select(account);
    }
}
