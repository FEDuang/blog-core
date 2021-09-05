package org.za.blog.service.impl;

import org.za.blog.dao.AccountMapper;
import org.za.blog.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.za.blog.service.IAccountService;

@Service
public class AccountImpl implements IAccountService {

    private final AccountMapper accountMapper;

    @Autowired
    public AccountImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account login(String UserName, String Password) {
        Account account = accountMapper.selectByUserName(UserName);
        if (account.getPassword().equals(Password)){
            account.setPassword(null);
            return account;
        }
        return null;
    }

    @Override
    public Account getOneUserByUsername(String UserName) {
        return accountMapper.selectByUserName(UserName);
    }
}
