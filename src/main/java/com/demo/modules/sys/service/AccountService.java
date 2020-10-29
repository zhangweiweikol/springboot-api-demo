package com.demo.modules.sys.service;

import com.demo.modules.sys.entity.Account;

import java.util.List;

public interface AccountService {

    Account login(Account account);

    List<Account> findList(Account account);
}
